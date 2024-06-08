package com.eazybutes.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // tell spring boot, we configuration some data in this class
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // http.authorizeHttpRequests((auth) -> 
        //     auth.requestMatchers("/accounts", "/balances", "/loans", "/cards").authenticated()
        //         .requestMatchers("/notices", "/contacts").permitAll())
        //     .formLogin(Customizer.withDefaults())
        //     .httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests((auth) -> auth.anyRequest().denyAll());
        
        return http.build();
    }

}
