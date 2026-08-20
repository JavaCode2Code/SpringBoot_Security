package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

	@SuppressWarnings("removal")
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.

				requestMatchers("/admin").denyAll().requestMatchers("/admin/**").denyAll().requestMatchers("/public/**")
				.permitAll().requestMatchers("/contact").permitAll().anyRequest().authenticated());
		// http.formLogin();

		http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.httpBasic();
		return http.build();
	}

}
