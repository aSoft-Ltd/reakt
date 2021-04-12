package reakt

import org.w3c.dom.HTMLFormElement

class HTMLFormBuilder {
    private var submitHandler: (HTMLFormElement.() -> Unit)? = null

    infix fun onSubmit(handler: HTMLFormElement.() -> Unit): HTMLFormBuilder {
        submitHandler = handler
        return this
    }

    internal fun executeSubmit(form: HTMLFormElement) = submitHandler?.invoke(form)
}