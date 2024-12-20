package com.artemissoftware.restful_web_services.hello

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloWorldController(
    private val messageSource: MessageSource
) {

    @GetMapping(path = ["/hello"])
    fun helloWorld() = "Hello World"

    @GetMapping(path = ["/hello-bean"])
    fun helloWorldBean() = HelloWorldBean("Hello World")

    @GetMapping(path = ["/hello-world/{name}"])
    fun helloWorldPath(@PathVariable name: String) = HelloWorldBean("Hello World $name")

    @GetMapping(path = ["/hello-world-internationalized"])
    fun helloWorldInternationalized(): String? {
        val locale = LocaleContextHolder.getLocale()
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale)


        //return "Hello World V2";
//
//        //1:
//        //2:
////		- Example: `en` - English (Good Morning)
////		- Example: `nl` - Dutch (Goedemorgen)
////		- Example: `fr` - French (Bonjour)
////		- Example: `de` - Deutsch (Guten Morgen)
    }
}