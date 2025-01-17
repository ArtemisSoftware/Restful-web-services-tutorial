package com.artemissoftware.restful_web_services.socialmedia

import com.artemissoftware.restful_web_services.socialmedia.exception.UserNotFoundException
import jakarta.validation.Valid
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*
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
    fun retrieveUser(@PathVariable id: Int): EntityModel<User> {
        userDaoService.findUserById(id)?.let {
            val link = linkTo(methodOn(this.javaClass).retrieveAllUsers())
            val entityModel = EntityModel.of<User>(it)
            entityModel.add(link.withRel("all-users"));

            return entityModel
        } ?: run {
            throw UserNotFoundException("id: $id")
        }
    }

    @PostMapping(path= ["/users"])
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<User>{
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