package ui.components

import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onShowFunction
import react.*
import styled.styledDiv

const val particleJsCodee =
    """
        particlesJS.load('particles-js', 'json/particles.json', function() {
            console.log('callback - particles-js config loaded');
        });
    """


class MainPage : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css.classes = mutableListOf("back")
            attrs {
                id = "particles-js"
                onShowFunction = {
                    js(particleJsCodee) as Unit
                }
                onClickFunction = {
                    js(particleJsCodee) as Unit
                }
            }
        }
    }
}


fun RBuilder.mainPage(handler: RProps.() -> Unit): ReactElement {
    return child(MainPage::class) {
        this.attrs(handler)
    }
}