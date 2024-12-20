package com.artemissoftware.restful_web_services.socialmedia

import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class User(
    var id: Int,
    @field:Size(min = 2, message = "Must have a minimum of 2 characters")
    val name: String,
    @field:Past(message = "Birthdate should be in the past")
    val birthDate: LocalDate
)
