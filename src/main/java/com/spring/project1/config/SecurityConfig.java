package com.spring.project1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	 @Bean
	    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.formLogin().defaultSuccessUrl("/api/customers/",true);
	        http.authorizeHttpRequests().anyRequest().authenticated();
	        return http.build();
	    }
	    
	    @Bean
	    UserDetailsService userDetailsService() {
	        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
	        UserDetails user = User.withUsername("test@sunbasedata.com").password(passwordEncoder().encode("Test@123")).authorities("read").build();
	        userDetailsService.createUser(user);
	        return userDetailsService;
	    }
	    @Bean
	    BCryptPasswordEncoder passwordEncoder() {
	    	return new BCryptPasswordEncoder();
	    }

}
