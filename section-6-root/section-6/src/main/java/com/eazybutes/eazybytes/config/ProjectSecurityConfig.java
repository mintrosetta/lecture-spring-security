package com.eazybutes.eazybytes.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.eazybutes.eazybytes.filter.CsrfCookieFilter;

import jakarta.servlet.http.HttpServletRequest;

@Configuration // tell spring boot, we configuration some data in this class
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
		requestHandler.setCsrfRequestAttributeName("_csrf"); // ระบุว่า csrf ที่ระบุมากับ header ชื่อว่าอะไร
		// csrf will block all post method
		http.securityContext(Customizer.withDefaults())
			.cors(cors -> cors.configurationSource(new CorsConfigurationSource() {

			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setMaxAge(3800L);

				return config;
			}
		})).csrf(csrfConfig -> {
			csrfConfig.ignoringRequestMatchers("/contacts", "/auths/register");
			csrfConfig.csrfTokenRequestHandler(requestHandler);
			csrfConfig.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		})
		.addFilterAt(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
		.authorizeHttpRequests(
				(auth) -> auth.requestMatchers("/accounts/**", "/balances/**", "/loans/**", "/cards/**").authenticated()
						.requestMatchers("/notices/**", "/contacts/**", "/auths/**").permitAll())
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
