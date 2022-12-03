package com.apex.services;

import java.util.List;

import com.apex.jpa.User;

public interface UserService {
	User findByEmail(String email);
	User findById(long id);
	User add(User user);
	User update(User user);
	boolean delete(long id);
	List<User> findAll();
	

}
