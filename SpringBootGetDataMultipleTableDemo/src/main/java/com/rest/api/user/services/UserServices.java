package com.rest.api.user.services;

import java.util.List;
import java.util.Map;

import com.rest.api.user.entity.UserAddress;
import com.rest.api.user.entity.UserData;

public interface UserServices {
	public List<UserData> findBySearchTerm(Long id);
	public String findCityByUserId(Long userId);
	public Map<String,UserData> createUserData(UserData userData);
	public Map<String,UserAddress> createUserAddress(UserAddress userAddress);
}
