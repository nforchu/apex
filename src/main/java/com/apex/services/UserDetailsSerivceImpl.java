package com.apex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apex.dto.CustomUserDetails;
import com.apex.jpa.User;


public class UserDetailsSerivceImpl { // implements UserDetailsService{
	
	/*@Autowired
	UserService userService;


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
				
		User user = userService.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("username not found : " + email);
		}
		return new CustomUserDetails(user);
	}*/
	

}
