package com.rest.api.assembler;

import java.util.Optional;

import com.rest.api.entity.Person;
import com.rest.api.model.PersonVO;

public class EntityToModelAssembler {

	public static PersonVO convertPersonToPersonVo(Person person) {
		PersonVO personVO = new PersonVO();
		Optional.ofNullable(person.getId()).ifPresent(personVO::setId);
		Optional.ofNullable(person.getName()).ifPresent(personVO::setName);
		Optional.ofNullable(person.getCity()).ifPresent(personVO::setCity);
		Optional.ofNullable(person.getSalary()).ifPresent(personVO::setSalary);
		return personVO;
	}

}
