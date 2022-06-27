package com.rest.api.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.api.entity.Person;

@Repository
@Transactional(readOnly = false)
public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {

	public PersonDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public List<Person> getPersonDetails() {
		return getHibernateTemplate().loadAll(Person.class);
	}

	@Override
	public void savePerson(Person person) {
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setCheckWriteOperations(false);
		hibernateTemplate.save(person);
	}

	@Override
	public Person getPersonById(int id) {
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setCheckWriteOperations(false);
		return hibernateTemplate.get(Person.class, id);
	}

}
