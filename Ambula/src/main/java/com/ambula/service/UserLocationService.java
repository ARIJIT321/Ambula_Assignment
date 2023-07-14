package com.ambula.service;

import java.util.List;

import com.ambula.exception.LocationException;
import com.ambula.model.UserLocation;

public interface UserLocationService {

	
	public UserLocation createData(UserLocation userLocation);
	
	public UserLocation updateData(Long id,UserLocation userLocation)throws LocationException;
	
	public List<UserLocation> getUsers(int n) throws LocationException;
}
