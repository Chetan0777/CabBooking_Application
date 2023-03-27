package com.masai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vehicleId;
	private String name;
	private String seattingSitter;
	@Column(unique = true)
	private String plateNo;
	private Integer[] cordinates=new Integer[2];
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeattingSitter() {
		return seattingSitter;
	}
	public void setSeattingSitter(String seattingSitter) {
		this.seattingSitter = seattingSitter;
	}
	public String getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
	public Integer[] getCordinates() {
		return cordinates;
	}
	public void setCordinates(Integer[] cordinates) {
		this.cordinates = cordinates;
	}
	
	
	
	
	
	

}
