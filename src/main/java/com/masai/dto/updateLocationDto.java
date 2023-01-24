package com.masai.dto;

import lombok.Data;

@Data
public class updateLocationDto {
	private String xCordinate;
	private String yCordinate;
	public String getxCordinate() {
		return xCordinate;
	}
	public void setxCordinate(String xCordinate) {
		this.xCordinate = xCordinate;
	}
	public String getyCordinate() {
		return yCordinate;
	}
	public void setyCordinate(String yCordinate) {
		this.yCordinate = yCordinate;
	}
	

}
