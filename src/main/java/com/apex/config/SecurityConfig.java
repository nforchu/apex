package com.apex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.apex.services.UserDetailsSerivceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	
	//@Autowired
	//UserDetailsService userDetailsService;

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/images/**", "/css/**", "/webjars/**", "/api/**", "/login")
			.permitAll().anyRequest().authenticated()
			//.antMatchers("/console/**")
			//.hasAnyAuthority("ROLE_USER") 
			//.anyRequest()
			//.authenticated()
			.and()
			.formLogin()
			//.permitAll()
			.loginPage("/login")
			.permitAll()
			.usernameParameter("email")
			.passwordParameter("password")
			.loginProcessingUrl("/doLogin")
		    .defaultSuccessUrl("/console/product/list",true)
		    .and().logout().permitAll();
		
		   // .and()
		   // .logout().permitAll()
		   // .and()
		   // .exceptionHandling().accessDeniedPage("/403");
		return http.build();
	}
 
	/*@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }*/
}
