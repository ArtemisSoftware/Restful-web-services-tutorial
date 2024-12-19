package com.artemissoftware.restful_web_services.hello

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping(path = ["/hello"])
    fun helloWorld() = "Hello World"

    @GetMapping(path = ["/hello-bean"])
    fun helloWorldBean() = HelloWorldBean("Hello World")
}