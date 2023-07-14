package com.ambula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambula.exception.LocationException;
import com.ambula.model.UserLocation;
import com.ambula.repository.UserLocationRepo;

@Service
public class UserLocationServiceImpl implements UserLocationService{

	@Autowired
	private UserLocationRepo locationRepo;
	
	@Override
	public UserLocation createData(UserLocation userLocation) {
		UserLocation savedLocation  = locationRepo.save(userLocation);
		return savedLocation;
	}

	@Override
	public UserLocation updateData(Long id, UserLocation userLocation) throws LocationException {
		UserLocation updatedUserLocation = locationRepo.findById(id)
				.orElseThrow(() -> new LocationException("User not found with id " + id));

		updatedUserLocation.setName(userLocation.getName());
		updatedUserLocation.setLatitude(userLocation.getLatitude());
		updatedUserLocation.setLongitude(userLocation.getLongitude());
		
		return locationRepo.save(updatedUserLocation);
	}

	@Override
	public List<UserLocation> getUsers(int n) throws LocationException {
		List<UserLocation> userLocations=locationRepo.findNearestUsers(n);
		if(userLocations.isEmpty()) {
			throw new LocationException("There are no user locations");
		}
		return userLocations;
	}

}
