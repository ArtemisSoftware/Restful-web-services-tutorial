package com.artemissoftware.restful_web_services.socialmedia

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class UserDaoService {

    companion object {
        val USERS = listOf(
            User(1, "Milo", LocalDate.now().minusYears(100)),
            User(2, "Shun", LocalDate.now().minusYears(1000)),
        )
    }
}