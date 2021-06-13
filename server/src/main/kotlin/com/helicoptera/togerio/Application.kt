package com.helicoptera.togerio

import com.helicoptera.togerio.authentification.JwtManager
import com.helicoptera.togerio.authentification.credential.UsernamePasswordCredential
import com.helicoptera.togerio.authentification.principal.UserPrincipal
import com.google.gson.Gson
import com.helicoptera.togerio.authentification.jwt.getRealm
import com.helicoptera.togerio.db.initDB
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*
import org.slf4j.event.Level

fun main(args: Array<String>) {
    initDB()
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused")
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    val jwtManager = JwtManager(environment)

    install(Authentication) {
        jwt("auth-jwt") {
            realm = getRealm(environment)
            verifier(jwtManager.verifier)
            validate { credential ->
                jwtManager.verifyCredential(credential)
            }
        }
    }

    install(CallLogging) {
        level = Level.INFO
    }

    install(Locations)

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        method(HttpMethod.Get)
        header(HttpHeaders.Authorization)
        allowCredentials = true
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            disableHtmlEscaping()
            register(ContentType.Application.Any, GsonConverter(Gson()))
        }
    }
    install(Sessions) {
//        cookie<Session>(session)
    }
    routing {
//        this.root()
        authenticate("auth-jwt") {
            get("/jwt") {
                val principal = call.authentication.principal<UserPrincipal>()
                val userId = principal!!.id
                call.respondText("Hello, $userId!")
            }
        }
        get("/lol") {
            val principal = call.authentication.principal<UserPrincipal>()
            call.respondText("Hello, $principal!")
        }
        post("/registration") {
            val credentials = call.receive<UsernamePasswordCredential>()
            val user = UserPrincipal(0)
            val token = jwtManager.makeToken(user)
            call.respondText(token)
        }
        static {
            //Url path to static folder
            static("static") {
                //Package name for resources
                resources("static")
            }
        }
    }
}