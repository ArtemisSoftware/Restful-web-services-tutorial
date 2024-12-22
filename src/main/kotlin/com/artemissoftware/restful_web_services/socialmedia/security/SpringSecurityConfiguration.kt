package com.artemissoftware.restful_web_services.socialmedia.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.web.SecurityFilterChain


@Configuration
class SpringSecurityConfiguration {

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        // 1) All requests should be authenticated
        http.authorizeHttpRequests { auth -> auth.anyRequest().authenticated() }

        // 2) If a request is not authenticated, a web page is shown
        http.httpBasic(withDefaults())


        // 3) CSRF -> POST, PUT
        // http.csrf().disable(); // Deprecated in SB 3.1.x
        http.csrf { csrf: CsrfConfigurer<HttpSecurity> -> csrf.disable() } // Starting from SB 3.1.x Using Lambda DSL


        // OR
        // http.csrf(AbstractHttpConfigurer::disable); // Starting from SB 3.1.x Using Method Reference
        return http.build()
    }
}