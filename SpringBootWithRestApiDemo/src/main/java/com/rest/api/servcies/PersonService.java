package com.rest.api.servcies;

import java.util.List;

import com.rest.api.model.PersonVO;

public interface PersonService {
	public abstract PersonVO findById(int id);
	public abstract PersonVO createPerson(PersonVO personVo);
	public abstract List<PersonVO> getAllPersons();
	public abstract Boolean updatePerson(PersonVO personVO);
}
