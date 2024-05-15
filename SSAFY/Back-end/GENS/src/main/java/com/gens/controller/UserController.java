package com.gens.controller;

import com.gens.service.user.UserService;

public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
}
