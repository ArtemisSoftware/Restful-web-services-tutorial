package com.artemissoftware.restful_web_services.socialmedia

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class UserDaoService {

    fun getUsers() = USERS

    fun findUserById(id: Int) = USERS.find { it.id == id }

    fun save(user: User): Int {
        user.id = USERS.last().id + 1
        USERS.add(user)
        return user.id
    }

    private companion object {
        val USERS = mutableListOf(
            User(1, "Milo", LocalDate.now().minusYears(100)),
            User(2, "Shun", LocalDate.now().minusYears(1000)),
        )
    }
}