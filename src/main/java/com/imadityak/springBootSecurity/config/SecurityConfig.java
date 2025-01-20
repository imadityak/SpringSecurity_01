package com.imadityak.springBootSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//by this we can change security filter chain works. It will say don't go for the default config.
//Use the configuration that i am telling here.
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //creating a bean of Security filter chain what every you write here will be applied if you haven't written anything
    //then it will add nothing -> no security


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
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    //we want multiple username and passwords. We want them to be fetched from the database.
    // when we make this it will not pick the username and password from application.properties file but the object that we are creating is not having any values boi.
    //we are hard coding the values here we want it to be fetched from database
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder() // depricated don't use it in product encode your password
//                .username("Kiran")
//                .password("kumari")
//                .roles("USER")
//                .build(); // will return obj of userDetails
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder() // depricated don't use it in product encode your password
//                .username("aditya")
//                .password("kumar")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2); // this class indirectly implements the userDetailService interface. Why use this class -> easy for obj. creation
//    }
}