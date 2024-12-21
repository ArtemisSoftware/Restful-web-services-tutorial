package com.artemissoftware.restful_web_services.socialmedia

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {
}