package com.artemissoftware.restful_web_services.socialmedia

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.annotation.Generated
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

@Entity(name = "user_details")
data class User(
    @Id
    @Generated
    var id: Int,
    @field:Size(min = 2, message = "Must have a minimum of 2 characters")
    @JsonProperty("user_name")
    var name: String ="",
    @field:Past(message = "Birthdate should be in the past")
    var birthDate: LocalDate = LocalDate.now()
)
