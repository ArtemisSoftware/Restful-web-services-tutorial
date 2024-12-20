package com.artemissoftware.restful_web_services.versioning

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class VersioningPersonController {

    @GetMapping("/v1/person")
    fun getFirstVersionOfPerson() = PersonV1("Bob Charlie")

    @GetMapping("/v2/person")
    fun getSecondVersionOfPerson() = PersonV2(Name("Bob", "Charlie"))

    @GetMapping(path = ["/person"], params = ["version=1"])
    fun getFirstVersionOfPersonRequestParameter()= PersonV1("Bob Charlie")

    @GetMapping(path = ["/person"], params = ["version=2"])
    fun getSecondVersionOfPersonRequestParameter()= PersonV2(Name("Bob", "Charlie"))

    @GetMapping(path = ["/person/header"], headers = ["X-API-VERSION=1"])
    fun getFirstVersionOfPersonRequestHeader() = PersonV1("Bob Charlie")

    @GetMapping(path = ["/person/header"], headers = ["X-API-VERSION=2"])
    fun getSecondVersionOfPersonRequestHeader() = PersonV2(Name("Bob", "Charlie"))

    @GetMapping(path = ["/person/accept"], produces = ["application/vnd.company.app-v1+json"])
    fun getFirstVersionOfPersonAcceptHeader() = PersonV1("Bob Charlie")

    @GetMapping(path = ["/person/accept"], produces = ["application/vnd.company.app-v2+json"])
    fun getSecondVersionOfPersonAcceptHeader() = PersonV2(Name("Bob", "Charlie"))

}