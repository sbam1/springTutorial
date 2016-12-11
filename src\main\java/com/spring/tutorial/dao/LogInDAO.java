package com.spring.tutorial.dao;

import java.util.List;

import com.spring.tutorial.model.LogIn;

public interface LogInDAO {
	
	public void add(LogIn login);
	public void edit(LogIn login);
	public void delete(int id);
	public LogIn getLogIn(int id);
	public List<LogIn> getAllLogIn();

}
