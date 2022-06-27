package com.rest.api.user.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.user.entity.UserAddress;
import com.rest.api.user.entity.UserData;
import com.rest.api.user.repositories.UserAddressRepository;
import com.rest.api.user.repositories.UserDataRepository;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserDataRepository userDataRepository;
	
	@Autowired
	private UserAddressRepository userAddressRepository;

	@Override
	public List<UserData> findBySearchTerm(Long id) {
		return userDataRepository.findBySearchTerm(id);
	}

	@Override
	public String findCityByUserId(Long userId) {
		return userDataRepository.findCityByUserId(userId);
	}

	@Override
	public Map<String, UserData> createUserData(UserData userData) {
		UserData createUser = this.userDataRepository.save(userData);
		return Map.of("Create UserData Successfully", createUser);
	}

	@Override
	public Map<String, UserAddress> createUserAddress(UserAddress userAddress) {
		UserAddress createUserAddress = this.userAddressRepository.save(userAddress);
		return Map.of("Create UserAddress Successfully", createUserAddress);
	}

}
