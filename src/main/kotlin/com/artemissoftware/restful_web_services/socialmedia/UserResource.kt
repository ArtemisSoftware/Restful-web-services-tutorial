package com.artemissoftware.restful_web_services.socialmedia

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserResource(
    private val userDaoService: UserDaoService
) {

    @GetMapping(path= ["/users"])
    fun retrieveAllUsers() = userDaoService.getUsers()

    @GetMapping(path= ["/users/{id}"])
    fun retrieveUser(@PathVariable id: Int) = userDaoService.findUserById(id)
}