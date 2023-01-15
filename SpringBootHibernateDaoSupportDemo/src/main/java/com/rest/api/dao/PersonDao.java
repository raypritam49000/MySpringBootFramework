package com.rest.api.dao;

import java.util.List;

import com.rest.api.entity.Person;

public interface PersonDao {
	public abstract void savePerson(Person person);
	public abstract List<Person> getPersonDetails();
	public abstract Person getPersonById(int id);
}
