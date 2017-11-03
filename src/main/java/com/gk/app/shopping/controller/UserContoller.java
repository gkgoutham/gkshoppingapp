package com.gk.app.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gk.app.shopping.bean.Users;
import com.gk.app.shopping.service.UserService;

@RestController
public class UserContoller {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addUser(@RequestBody Users user) {
		userService.createUser(user);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, headers = "Accept=application/json")
	public Users getUser(@RequestParam String emailId) {
		return userService.get(emailId);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Users> getAllUsersByUserType(@RequestBody Users user) {
		return userService.getAllUsers(user.getUserType());
	}
	
	@RequestMapping(value = "/approveUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public void approveUser(@RequestBody Users user) {
		userService.approveUser(user);
	}
}
