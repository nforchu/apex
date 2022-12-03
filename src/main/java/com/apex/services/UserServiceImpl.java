package com.apex.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apex.jpa.ActiveOrInactive;
import com.apex.jpa.User;
import com.apex.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	UserRepository userRepo;

	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public User findById(long id) {
		return userRepo.findById(id).orElseThrow();
	}

	@Override
	public User add(User user) {
		user.setStatus(ActiveOrInactive.ACTIVE);
		return userRepo.save(user);
	}

	@Override
	public User update(User user) {
		User mergedUser = userRepo.findById(user.getId()).orElseThrow();
		mergedUser.setEmail(user.getEmail())
				  .setName(user.getName());
		if(user.getPassword() != null && !user.getPassword().isBlank()) {
			mergedUser.setPassword(user.getPassword());
		}		
		return userRepo.save(mergedUser);
	}

	@Override
	public boolean delete(long id) {
		User user = userRepo.findById(id).orElseThrow();
		userRepo.delete(user);
		return true;
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User findByEmail(String email) {
		return this.userRepo.findByEmail(email);
	}

}
