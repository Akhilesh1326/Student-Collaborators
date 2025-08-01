package com.example.user_management_service.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class APISecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests() // ✅ Modern method
                .requestMatchers("/public/**").permitAll() // Public endpoints (optional)
                .anyRequest().authenticated()             // Everything else needs auth
                .and()
                .httpBasic(); // Basic Auth

        return http.build();
    }
}
