package com.rest.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.api.assembler.EntityToModel;
import com.rest.api.dto.UserDto;
import com.rest.api.entity.User;

@SpringBootApplication
public class SpringBootRestApiWithJpaDtoDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiWithJpaDtoDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User(1,"Pritam Ray","Ropar","34000");
		UserDto userDto = EntityToModel.entityToDto(user);
		System.out.println(userDto);
		
	}

}
