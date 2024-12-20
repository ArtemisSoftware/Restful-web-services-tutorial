package com.artemissoftware.restful_web_services.socialmedia

import com.artemissoftware.restful_web_services.socialmedia.exception.UserNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI


@RestController
class UserResource(
    private val userDaoService: UserDaoService
) {

    @GetMapping(path= ["/users"])
    fun retrieveAllUsers() = userDaoService.getUsers()

    @GetMapping(path= ["/users/{id}"])
    fun retrieveUser(@PathVariable id: Int): User {
        userDaoService.findUserById(id)?.let {
            return it
        } ?: run {
            throw UserNotFoundException("id: $id")
        }
    }

    @PostMapping(path= ["/users"])
    fun createUser(@RequestBody user: User): ResponseEntity<User>{
        val id = userDaoService.save(user)

        val location: URI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(id)
            .toUri()

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path= ["/users/{id}"])
    fun deleteUser(@PathVariable id: Int) = userDaoService.delete(id)


}