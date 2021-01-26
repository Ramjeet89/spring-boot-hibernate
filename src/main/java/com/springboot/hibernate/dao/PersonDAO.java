package com.springboot.hibernate.dao;

import com.springboot.hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void savePerson(Person person) {
        getSession().save(person);
    }

    public List<Person> getPersons() {
        return getSession().createCriteria(Person.class).list();
    }

    private Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;

    }

}
