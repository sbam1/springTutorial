package com.spring.tutorial.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.tutorial.dao.LogInDAO;
import com.spring.tutorial.model.LogIn;

@Repository
public class LogInDAOImpl implements LogInDAO{
	
	@Autowired
	private SessionFactory sessionFactory;


	public void add(LogIn login) {
		sessionFactory.getCurrentSession().save(login);
		
	}


	public void edit(LogIn login) {
		sessionFactory.getCurrentSession().update(login);
		
	}

	public void delete(int id) {
		LogIn login = getLogIn(id);
		sessionFactory.getCurrentSession().delete(login);
		
	}

	public LogIn getLogIn(int id) {
		return (LogIn)sessionFactory.getCurrentSession().get(LogIn.class, id);
	}


	public List<LogIn> getAllLogIn() {
	return sessionFactory.getCurrentSession().createQuery("from LogIn").list();
	}

}
