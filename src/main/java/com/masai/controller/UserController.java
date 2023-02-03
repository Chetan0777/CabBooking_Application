package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.LoginDto;
import com.masai.exception.UserException;
import com.masai.model.Driver;
import com.masai.model.User;
import com.masai.model.UserLogin;
import com.masai.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/masaicab/user/register")
	public ResponseEntity<User> ragisterUser(@Valid @RequestBody User user) throws UserException{
		return new ResponseEntity<User>(userService.registerUser(user),HttpStatus.CREATED);
	}
	@PostMapping("masaicab/user/findride")
	public ResponseEntity<UserLogin> loginUser(@RequestBody LoginDto loginDto) throws UserException{
		return new ResponseEntity<UserLogin>(userService.loginUser(loginDto), HttpStatus.OK);
		
	}
	@GetMapping("/masaicab/user/findride")
	public ResponseEntity<List<Driver>> getAllAvalableList(@RequestParam("key") String key) throws UserException{
		return new ResponseEntity<List<Driver>>(userService.getAllAvaibleList(key),HttpStatus.OK);
		
	}
	@PutMapping("/masaicab/user/book/{driverId}/{x}/{y}")
	public ResponseEntity<Driver> bookDriver(@PathVariable("driverId") Integer driverId,@PathVariable("x") Integer x,@PathVariable("y") Integer y) throws UserException{
		return new ResponseEntity<Driver>(userService.bookedDriver(driverId, x, y), HttpStatus.CREATED);
	}

}
