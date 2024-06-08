package com.eazybutes.eazybytes.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // tell spring boot, we configuration some data in this class
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> 
            auth.requestMatchers("/accounts", "/balances", "/loans", "/cards").authenticated()
                .requestMatchers("/notices", "/contacts").permitAll())
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());
        
        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // {noop} - NoOpPasswordEncoder store password with plain text
    // @Bean
    // public InMemoryUserDetailsManager userDetailsService() {
    //     UserDetails admin = User.withUsername("admin")
    //         .password("{noop}admin")
    //         .authorities("ADMIN")
    //         .build();

    //     UserDetails user = User.withUsername("user")
    //         .password("{noop}user")
    //         .authorities("USER")
    //         .build();

    //     return new InMemoryUserDetailsManager(admin, user);
    // }

}
