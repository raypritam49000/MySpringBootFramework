package com.rest.api.assembler;

import java.util.Optional;

import com.rest.api.entity.Person;
import com.rest.api.model.PersonVO;

public class ModelToEntityAssembler {

	public static Person convertPersonVoToPerson(PersonVO personVO) {
		Person person = new Person();
		Optional.ofNullable(personVO.getId()).ifPresent(person::setId);
		Optional.ofNullable(personVO.getName()).ifPresent(person::setName);
		Optional.ofNullable(personVO.getCity()).ifPresent(person::setCity);
		Optional.ofNullable(personVO.getSalary()).ifPresent(person::setSalary);
		return person;
	}

}
