package com.ridex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridex.dto.UserResponseDTO;
import com.ridex.entity.User;
import com.ridex.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController 
{
	@Autowired
	private UserService userService;
	



	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> registerUser(@RequestBody User user) 
	{
		
		User savedUser = userService.registerUser(user);

		UserResponseDTO response = new UserResponseDTO(
				savedUser.getUserId(),
				savedUser.getEmail(),
				savedUser.getRole().name()
				);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	

	@PostMapping("/login")
	public ResponseEntity<UserResponseDTO> loginUser(@RequestBody User user)
	{
		UserResponseDTO response = userService.loginUser(
				user.getEmail(),
				user.getPassword()
				);

		return ResponseEntity.ok(response);
	}

}
