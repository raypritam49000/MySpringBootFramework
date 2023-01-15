package com.rest.api.assembler;

import org.springframework.beans.BeanUtils;

import com.rest.api.dto.UserDto;
import com.rest.api.entity.User;

public class ModelToEntity {

	public static User entityToDto(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		return user;
	}
}
