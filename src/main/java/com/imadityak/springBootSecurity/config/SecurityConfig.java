package com.imadityak.springBootSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//by this we can change security filter chain works.
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //creating a bean of Security filter chain what every you write here will be applied if you haven't written anything
    //then it will add nothing no security


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //let's implement the security by ourselves

        return httpSecurity
                .csrf(customizer -> customizer.disable())

        //this will enable authentication it won't let you to see the content until authenticated
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())

        // login form for browser(disable this to access it from browser)(stateless)
                .formLogin(Customizer.withDefaults())

        //enable sending login credentials from rest client(Postman)
                .httpBasic(Customizer.withDefaults())

        //make http stateless
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
    }
}