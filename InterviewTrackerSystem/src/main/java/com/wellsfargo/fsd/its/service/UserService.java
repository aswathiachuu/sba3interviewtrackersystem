package com.wellsfargo.fsd.its.service;

import java.util.List;

import com.wellsfargo.fsd.its.entity.User;

public interface UserService {

	public List<User> displayAllUsers();
	public User addUser(User user);
	public String deleteUser(int userId);
	public User getUserbyId(int userId);
	
}
