package com.artemissoftware.restful_web_services.socialmedia

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*


@Entity
data class Post (
    @Id
    @GeneratedValue
    var id: Int = 0,
    var description: String = "",

    @ManyToOne(targetEntity = User::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    var user: User? = null

)
