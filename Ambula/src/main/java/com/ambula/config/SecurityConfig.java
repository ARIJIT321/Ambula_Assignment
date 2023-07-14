package com.ambula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;


@Configuration
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain appSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth ->
		  auth.requestMatchers(HttpMethod.GET,"/get_users/**").hasAnyRole("ADMIN","Reader")
		      .requestMatchers(HttpMethod.POST,"/**").hasRole("ADMIN")
		      .requestMatchers(HttpMethod.PUT,"/**").hasRole("ADMIN")
		      .anyRequest().authenticated()
		).csrf(csfr -> csfr.disable())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
		
	}
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		
		UserDetails admin=User.withUsername("Arijit").password(passwordEncoder.encode("1234")).roles("ADMIN").build();
	    UserDetails reader=User.withUsername("Ankush").password(passwordEncoder.encode("12345")).roles("READER").build();
	    
		return new InMemoryUserDetailsManager(admin,reader);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
}
