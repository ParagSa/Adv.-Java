package com.digirojgar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digirojgar.model.User;
import com.digirojgar.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value= {"/user"})
	public String addUser(@RequestBody User user) {
		userService.add(user);
		return "success";
	}
	
	@GetMapping(value= {"/user"})
	public List<User> getUser() {
		return userService.getAll();		
	}
	
	@GetMapping(value= {"/user/byemail/{email}"})
	public User getUserInfo(@PathVariable String email) {
		return userService.getByEmail(email);
	}
	
	@DeleteMapping(value= {"/user/{id}"})
		public String delUser(@PathVariable int id) {
		 userService.removeById(id);
		 return "success";
	}
	
	
}
