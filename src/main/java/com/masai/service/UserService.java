package com.masai.service;

import java.util.List;

import com.masai.dto.LoginDto;
import com.masai.exception.UserException;
import com.masai.model.Driver;
import com.masai.model.User;
import com.masai.model.UserLogin;

public interface UserService {
	
	public User registerUser(User user) throws UserException;
	public UserLogin loginUser(LoginDto loginDto) throws UserException;
	public List<Driver> getAllAvaibleList(String key) throws UserException;
	public Driver bookedDriver(Integer driverId,Integer x,Integer y) throws UserException;
	
}
