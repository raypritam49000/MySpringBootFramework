package com.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.entity.User;
import com.rest.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User createUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User getUserById(int id) {
		return this.userRepository.findById(id).get();
	}

	@Override
	public Boolean updateUserById(int id, User user) {
		User existUser = this.userRepository.findById(id).get();
		if (existUser != null) {
			existUser.setCity(user.getCity());
			existUser.setName(user.getName());
			existUser.setSalary(user.getSalary());
			this.userRepository.save(existUser);
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteUserById(int id) {
		this.userRepository.deleteById(id);
		return true;
	}

}
