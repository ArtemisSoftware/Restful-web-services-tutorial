package com.artemissoftware.restful_web_services.socialmedia

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.Size


@Entity
data class Post (
    @Id
    @GeneratedValue
    var id: Int = 0,

    @field:Size(min = 10, message = "Must have a minimum of 10 characters")
    var description: String = "",

    @ManyToOne(targetEntity = User::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    var user: User? = null

)
