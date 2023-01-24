package com.masai.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.DriverException;
import com.masai.model.Driver;
import com.masai.repository.DriverRepo;
import com.masai.service.DriverService;
@Service
public class DriverServiceImpl  implements DriverService{
	@Autowired
	private DriverRepo driverRepo;

	@Override
	public Driver registerDriver(Driver driver) throws DriverException {
		return driverRepo.save(driver);
	}

}
