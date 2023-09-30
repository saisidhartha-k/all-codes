package com.oauth2.connect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class BasicConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
               .authorizeHttpRequests(authorizeRequests -> {
                authorizeRequests.requestMatchers("/", "/favicon.ico", "/error").permitAll() // Publicly accessible endpoints
                    .anyRequest().authenticated(); 
            })
            .formLogin(formLogin -> {
                formLogin
                    .loginPage("/") 
                    .permitAll(); 
            })
            .oauth2Login(withDefaults()) 
            .csrf().disable();

        return http.build();
    }
}
