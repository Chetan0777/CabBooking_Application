package com.masai.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dto.LoginDto;
import com.masai.exception.UserException;
import com.masai.model.Driver;
import com.masai.model.User;
import com.masai.model.UserLogin;
import com.masai.repository.DriverRepo;
import com.masai.repository.UserLoginRepo;
import com.masai.repository.UserRepo;
import com.masai.service.UserService;

import net.bytebuddy.utility.RandomString;
@Service
public class UserSeriviceImpl  implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private DriverRepo driverRepo;
	@Autowired
	private UserLoginRepo userLoginRepo;
	

	@Override
	public User registerUser(User user) throws UserException {
		if(user!=null) {
			return userRepo.save(user);
		}
	throw new UserException("something is wrong");
	}

	@Override
	public UserLogin loginUser(LoginDto loginDto) throws UserException {
		User user= userRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
		if(user!=null) {
			UserLogin userLogin=new UserLogin();
			userLogin.setUserId(user.getId());
			userLogin.setKey(RandomString.make(6));
			userLogin.setLocalDateTime(LocalDateTime.now());
			return userLoginRepo.save(userLogin);
		}
		throw new UserException("details Not Matched");
	}
	
	@Override
	public List<Driver> getAllAvaibleList(String key) throws UserException {
		UserLogin userLogin= userLoginRepo.findByKey(key);
		if(userLogin!=null) {
			Optional<User> user= userRepo.findById(userLogin.getUserId());
			Integer x=user.get().getCurrentPosition()[0];
			Integer y=user.get().getCurrentPosition()[0];
			if(x==0 || y==0) {
				throw new UserException("first set your location");
			}
			List<Driver> drivers=new ArrayList<>();
			
			List<Driver> dirversDrivers= driverRepo.findAll();
			for(Driver i:dirversDrivers) {
				Integer dx=i.getVehicle().getCordinates()[0];
				Integer dy=i.getVehicle().getCordinates()[1];
				Integer value=(int) Math.sqrt(Math.pow((x-dx), 2)+Math.pow((y-dy), 2));
				if(value<=5) {
					drivers.add(i);
				}
			}
			return drivers;
		}
		
		
		throw new UserException("U are not the valid user");
	}

	@Override
	public Driver bookedDriver(Integer driverId, Integer x, Integer y) throws UserException {
		Optional<Driver> drivOptional= driverRepo.findById(driverId);
		if(drivOptional.isPresent()) {
			drivOptional.get().getVehicle().getCordinates()[0]=x;
			drivOptional.get().getVehicle().getCordinates()[1]=y;
			return driverRepo.save(drivOptional.get());

		}
		throw new UserException("Driver Not found");
	}


	
}
