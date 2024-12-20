package com.artemissoftware.restful_web_services.socialmedia.exception

import java.time.LocalDate
import java.time.LocalDateTime

data class ErrorDetails(
    var message: String? = "Unknown error",
    var details: String= "",
    var timeStamp: LocalDateTime = LocalDateTime.now()
)
