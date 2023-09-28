package com.oauth2.connect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BasicConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
               .authorizeHttpRequests(authorizeRequests -> {
                authorizeRequests.requestMatchers("/", "/favicon.ico", "/error").permitAll() // Publicly accessible endpoints
                    .anyRequest().authenticated(); // All other endpoints require authentication
            })
            .formLogin(formLogin -> {
                formLogin
                    .loginPage("/custom-login") // Specify the custom login page URL
                    .permitAll(); // Allow access to the custom login page without authentication
            })
            .oauth2Login(withDefaults()) // OAuth2 login with default settings
            .csrf().disable(); // Disable CSRF for simplicity, enable it in production

        return http.build();
    }
}
