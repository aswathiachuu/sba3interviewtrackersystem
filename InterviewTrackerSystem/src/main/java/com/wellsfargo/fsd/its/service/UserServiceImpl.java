package com.wellsfargo.fsd.its.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.its.dao.UserRepository;
import com.wellsfargo.fsd.its.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> displayAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		
		userRepository.save(user);
		return user;
	}

	@Override
	public String deleteUser(int userId) {
		
		String response = null;
		if(userRepository.existsById(userId)) {
		userRepository.deleteById(userId);
		response = "User Deleted";
		}
		else {
			response = "User not found";
		}
		return response;
	}

	@Override
	public User getUserbyId(int userId) {
		// TODO Auto-generated method stub
		return userRepository.getOne(userId);
	}
}
