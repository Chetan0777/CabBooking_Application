package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.DriverException;
import com.masai.model.Driver;
import com.masai.service.DriverService;

@RestController
public class DriverController {
	@Autowired
	private DriverService driverService;

	@PostMapping("/masaicab/driver/register")
	public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) throws DriverException{
		return new ResponseEntity<Driver>(driverService.registerDriver(driver),HttpStatus.CREATED);
	}
}
