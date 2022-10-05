package com.eugene.userlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
