package com.artemissoftware.restful_web_services.socialmedia

import java.time.LocalDate

data class User(
    val id: Int,
    val name: String,
    val birthDate: LocalDate
)
