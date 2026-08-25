/*
 * package com.example.demo.security;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configurers.
 * AbstractHttpConfigurer; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class ConfigSecurity {
 * 
 * @SuppressWarnings("removal")
 * 
 * @Bean SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
 * throws Exception { http.authorizeHttpRequests((requests) ->
 * requests.anyRequest().authenticated());
 * http.csrf(AbstractHttpConfigurer::disable); //http.formLogin(withDefaults());
 * http.httpBasic(org.springframework.security.config.Customizer.withDefaults())
 * ; return http.build(); }
 * 
 * @Bean public UserDetailsService getUserDetailsService() {
 * InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(); if
 * (!manager.userExists("user1")) {
 * manager.createUser(User.withUsername("user1").password("{noop}password1").
 * roles("USER").build()); } if (!manager.userExists("admin")) {
 * manager.createUser(User.withUsername("admin").password("{noop}sat@123").roles
 * ("ADMIN").build()); } return manager; } }
 */