package com.rest.api.assembler;

import org.springframework.beans.BeanUtils;

import com.rest.api.dto.UserDto;
import com.rest.api.entity.User;

public class EntityToModel {

	public static UserDto entityToDto(User user) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}
}
