package com.eugene.userlist.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eugene.userlist.domain.User;
import com.eugene.userlist.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("")
	public List<User> getUserList(@RequestParam(name="dateFrom", required= false) String dateFrom, @RequestParam(name="dateTo", required= false) String dateTo, @RequestParam(name="email", required= false) String email) {
		return service.getUserList(dateFrom, dateTo, email);
	}
	
	@PostMapping("")
	public User createUser(@Valid @RequestBody User user) {
		return service.save(user);
	}
	
	@GetMapping("/{id}")
	public User getUserbyId(@PathVariable String id) {
		return service.getUserById(id);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@Valid @RequestBody User user, @PathVariable String id) {
		return service.updateUser(user, id);
	}
}
