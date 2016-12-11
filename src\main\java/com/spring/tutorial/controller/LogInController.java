package com.spring.tutorial.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.tutorial.model.LogIn;
import com.spring.tutorial.service.LogInService;


@Controller
public class LogInController {
	
	@Autowired
	private LogInService logInService;
	
	@RequestMapping("/index")
	public String setUpForm(Map<String, Object> map){
		LogIn login = new LogIn();
		map.put("logIn", login);
		map.put("logInList", logInService.getAllLogIn());
		
		return "logIn";
		
	}
	
	@RequestMapping(value = "/logIn.do", method = RequestMethod.POST)
	public String doAction(@ModelAttribute LogIn login, BindingResult result, @RequestParam String action, Map<String, Object> map) {
		
		LogIn logInRequest = new LogIn();
		switch(action.toLowerCase()){
		case "add":
			logInService.add(login);
			logInRequest = login;
			break;
		case "edit":
			logInService.edit(login);
			logInRequest = login;
			break;
		case "delete":
			logInService.delete(login.getId());
			logInRequest = new LogIn();
			break;
		case "search":
			logInRequest = logInService.getLogIn(login.getId()) != null ? logInService.getLogIn(login.getId()) :  new LogIn();
			break;
		
		}
		
		map.put("logIn", logInRequest);
		map.put("logInList", logInService.getAllLogIn());
		
		
		return "logIn";
	}

}
