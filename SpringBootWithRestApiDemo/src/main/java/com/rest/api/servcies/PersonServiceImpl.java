package com.rest.api.servcies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.assembler.EntityToModelAssembler;
import com.rest.api.assembler.ModelToEntityAssembler;
import com.rest.api.entity.Person;
import com.rest.api.model.PersonVO;
import com.rest.api.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public PersonVO findById(int id) {
		Optional<Person> person = this.personRepository.findById(id);
		if (person.isPresent()) {
			return EntityToModelAssembler.convertPersonToPersonVo(person.get());
		} else {
			return new PersonVO();
		}
	}

	@Override
	public PersonVO createPerson(PersonVO personVO) {
		Person persondb = null;
		Person person = ModelToEntityAssembler.convertPersonVoToPerson(personVO);

		try {
			persondb = this.personRepository.save(person);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return EntityToModelAssembler.convertPersonToPersonVo(persondb);
	}

	@Override
	public List<PersonVO> getAllPersons() {
		List<Person> personList = this.personRepository.findAll();
		List<PersonVO> personVoList = new ArrayList<PersonVO>();

		for (Person person : personList) {
			PersonVO personVO = EntityToModelAssembler.convertPersonToPersonVo(person);
			personVoList.add(personVO);
		}

		return personVoList;
	}

	@Override
	public Boolean updatePerson(PersonVO personVO) {
		Person person = ModelToEntityAssembler.convertPersonVoToPerson(personVO);
		Optional<Person> persondb = this.personRepository.findById(person.getId());
		Person updatePerson = null;
		try 
		{	
			if(persondb.isPresent()) {
				persondb.get().setCity(personVO.getCity());
				persondb.get().setName(personVO.getName());
				persondb.get().setSalary(personVO.getSalary());
				updatePerson = this.personRepository.save(persondb.get());
			}
			
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}

}
