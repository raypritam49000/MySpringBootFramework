package com.rest.api.services;

import java.util.List;

import com.rest.api.entity.User;

public interface UserService {
	public abstract List<User> getAllUsers();
	public abstract User createUser(User user);
	public abstract User getUserById(int id);
	public abstract Boolean updateUserById(int id,User user);
	public abstract Boolean deleteUserById(int id);
}
