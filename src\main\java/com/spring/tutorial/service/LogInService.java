package com.spring.tutorial.service;

import java.util.List;

import com.spring.tutorial.model.LogIn;

public interface LogInService {
	
	public void add(LogIn login);
	public void edit(LogIn login);
	public void delete(int id);
	public LogIn getLogIn(int id);
	public List<LogIn> getAllLogIn();
}
