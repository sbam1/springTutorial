package com.spring.tutorial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.tutorial.dao.LogInDAO;
import com.spring.tutorial.dao.impl.LogInDAOImpl;
import com.spring.tutorial.model.LogIn;
import com.spring.tutorial.service.LogInService;

@Service
public class LogInServiceImpl implements LogInService {

	
	@Autowired
	private LogInDAOImpl logInDao;

	@Transactional
	public void add(LogIn login) {
		logInDao.add(login);

	}

	@Transactional
	public void edit(LogIn login) {
		logInDao.edit(login);

	}

	@Transactional
	public void delete(int id) {
		logInDao.delete(id);

	}

	@Transactional
	public LogIn getLogIn(int id) {
		return logInDao.getLogIn(id);
	}

	@Transactional
	public List<LogIn> getAllLogIn() {
		return logInDao.getAllLogIn();
	}

}
