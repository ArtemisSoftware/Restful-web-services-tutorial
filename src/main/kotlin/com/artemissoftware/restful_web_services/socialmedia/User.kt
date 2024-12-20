package com.artemissoftware.restful_web_services.socialmedia

import java.time.LocalDate

data class User(
    var id: Int,
    val name: String,
    val birthDate: LocalDate
)
