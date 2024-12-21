package com.artemissoftware.restful_web_services.socialmedia

import com.artemissoftware.restful_web_services.socialmedia.exception.UserNotFoundException
import jakarta.validation.Valid
import org.springframework.data.jpa.domain.AbstractPersistable_
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI


@RestController
class UserJpaResource(
    private val userRepository: UserRepository
) {

    @GetMapping(path= ["/jpa/users"])
    fun retrieveAllUsers() = userRepository.findAll().toList()

    @GetMapping(path= ["/jpa/users/{id}"])
    fun retrieveUser(@PathVariable id: Int): EntityModel<User> {
        try {
            userRepository.findById(id).get().let {
                val link = linkTo(methodOn(this.javaClass).retrieveAllUsers())
                val entityModel = EntityModel.of<User>(it)
                return entityModel.add(link.withRel("all-users"));
            }
        } catch (ex: NoSuchElementException){
            throw UserNotFoundException("id: $id")
        }
    }

    @PostMapping(path= ["/jpa/users"])
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<User>{
        val id = userRepository.save(user)

        val location: URI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(id)
            .toUri()

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path= ["/jpa/users/{id}"])
    fun deleteUser(@PathVariable id: Int) = userRepository.deleteById(id)


}