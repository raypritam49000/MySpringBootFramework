package com.rest.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.assembler.EntityToModel;
import com.rest.api.assembler.ModelToEntity;
import com.rest.api.common.Constants;
import com.rest.api.common.Response;
import com.rest.api.dto.UserDto;
import com.rest.api.entity.User;
import com.rest.api.services.UserService;

@RestController
@RequestMapping("/rest/api")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	public Response createPerson(@RequestBody UserDto userDto) {

		try {
			User user = ModelToEntity.entityToDto(userDto);
			User userDb = this.userService.createUser(user);

			if (null != userDb && userDb.getId() != null) {
				return new Response(HttpStatus.CREATED, Constants.HTTP_STATUS_CODE_CREATED, new ArrayList<>(),
						"User created", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);
			} else {
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"User is not create", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

	@GetMapping("/getAllUsers")
	public Response getAllUsers() {
		try {
			List<User> users = this.userService.getAllUsers();
			if (null != users && !users.isEmpty()) {
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, users, "User list",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

			} else {
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, users,
						"Data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (Exception e) {
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(), "",
					Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}
	
	
	@GetMapping("/getUser/{id}")
	public Response getUserById(@PathVariable("id") Integer id) {
		try {
			List<UserDto> userDtos = new ArrayList<UserDto>();
			
			if (null != id) {
				User user = this.userService.getUserById(id);
				userDtos.add(EntityToModel.entityToDto(user));
			}

			if (null != userDtos  && !userDtos.isEmpty()) {
				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, userDtos, "User list",
						Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

			} else {
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, userDtos,
						"Data not found", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}
		} catch (Exception e) {
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(), "",
					Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}

	
	@PutMapping("/updateUser/{id}")
	public Response updatePlanPriority(@PathVariable("id") Integer id,@RequestBody UserDto userDto) {

		try {
			Boolean isUpdatePerson = this.userService.updateUserById(id,ModelToEntity.entityToDto(userDto));

			if (isUpdatePerson) {

				return new Response(HttpStatus.OK, Constants.HTTP_STATUS_CODE_SCCUESS, new ArrayList<>(),
						"User Priority Updated", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

			} else {
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"User is not updated", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (Exception exception) {
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public Response deleteByPackId(@PathVariable(name = "id") Integer id) {

		try {

			if (null != id) {
				Boolean isUserDeleted=this.userService.deleteUserById(id);
				if (isUserDeleted) {
					return new Response(HttpStatus.NO_CONTENT, Constants.HTTP_STATUS_CODE_NO_CONTACT, new ArrayList<>(),
							"User deleted", Constants.STATUS_SUCCESS, Constants.STATUS_SUCCESS_MESSAGE);

				} else {
					return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST,
							new ArrayList<>(), "Plan is not deleted", Constants.STATUS_FAILURE,
							Constants.STATUS_FAILURE_MESSAGE);
				}

			} else {
				return new Response(HttpStatus.BAD_GATEWAY, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
						"User is not deleted", Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
			}

		} catch (

		Exception exception) {
			return new Response(HttpStatus.BAD_REQUEST, Constants.HTTP_STATUS_CODE_BAD_REQUEST, new ArrayList<>(),
					exception.toString(), Constants.STATUS_FAILURE, Constants.STATUS_FAILURE_MESSAGE);
		}

	}
}
