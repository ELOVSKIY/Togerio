package com.helicoptera.togerio.routing.registration

import com.helicoptera.togerio.authentification.JwtManager
import com.helicoptera.togerio.authentification.principal.UserPrincipal
import com.helicoptera.togerio.authorization.validation.PasswordValidator
import com.helicoptera.togerio.authorization.validation.UsernameValidator
import com.helicoptera.togerio.data.entity.UserEntity
import com.helicoptera.togerio.data.network.NetworkResponse
import com.helicoptera.togerio.db.transaction.fetchUserByUserId
import com.helicoptera.togerio.db.transaction.fetchUserByUsername
import com.helicoptera.togerio.db.transaction.insertUser
import com.helicoptera.togerio.db.transaction.md5
import io.ktor.locations.*
import io.ktor.routing.Routing
import com.helicoptera.togerio.routing.location.RegistrationLocation
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.response.*

@KtorExperimentalLocationsAPI
fun Routing.registration(jwtManager: JwtManager) {
    val usernameValidator = UsernameValidator()
    val passwordValidator = PasswordValidator()

    post<RegistrationLocation> { _ ->
        suspend fun respondSuccess(userEntity: UserEntity) {
            val userPrincipal = UserPrincipal(userEntity.id)
            val token = jwtManager.makeToken(userPrincipal)
            call.respond(NetworkResponse(value = token))
        }

        suspend fun respondFailure(reason: String) {
            call.respond(NetworkResponse<Any>(error = reason))
        }

        suspend fun register() {
            val user = call.receive<UserEntity>()
            val usernameValidationResult = usernameValidator.validateUsername(user.username)
            if (usernameValidationResult.valid) {
                val passwordValidationResult = passwordValidator.validatePassword(user.password)
                if (passwordValidationResult.valid) {
                    val userWithSameUsername = fetchUserByUsername(user.username)
                    if (userWithSameUsername == null) {
                        val passwordHash = md5(user.password)
                        val processedUser = UserEntity(username = user.username, password = passwordHash)
                        val insertedUser = insertUser(processedUser)
                        respondSuccess(insertedUser)
                    } else {
                        respondFailure("Username is busy")
                    }
                } else {
                    respondFailure(passwordValidationResult.errorDescription)
                }
            } else {
                respondFailure(usernameValidationResult.errorDescription)
            }
        }

        val token = call.authentication.principal as? UserPrincipal
        if (token != null) {
            val id = token.id
            val user = fetchUserByUserId(id)
            if (user != null) {
                respondSuccess(user)
            } else {
                register()
            }
        } else {
            register()
        }
    }
}