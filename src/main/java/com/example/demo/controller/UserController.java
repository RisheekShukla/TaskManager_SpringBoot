package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository urep;
	@GetMapping("/login/{uname}/{pass}")
	public boolean CheckLogin(@PathVariable("uname")String username,@PathVariable("pass")String password)
	{
//		return urep.findByUsernameAndPassword(username,password);
		User old_user= urep.findByUsername(username);
		if(old_user.getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
