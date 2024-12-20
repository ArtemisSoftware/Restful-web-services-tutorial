package com.artemissoftware.restful_web_services.socialmedia

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class UserNotFoundException(message: String? = null) : RuntimeException(message)