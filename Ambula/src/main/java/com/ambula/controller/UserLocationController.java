package com.ambula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ambula.exception.LocationException;
import com.ambula.model.UserLocation;
import com.ambula.service.UserLocationService;

@RestController
@RequestMapping("/location")
public class UserLocationController {

	@Autowired
	private UserLocationService userLocationService;
	
	@PostMapping("/create_data")
	public ResponseEntity<UserLocation> createData(@RequestBody UserLocation userLocation){
		return new ResponseEntity<UserLocation>(userLocationService.createData(userLocation),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update_data/{id}")
	public ResponseEntity<UserLocation> updateData(@PathVariable Long id, @RequestBody UserLocation userLocation) throws LocationException{
		return new ResponseEntity<UserLocation>(userLocationService.updateData(id, userLocation),HttpStatus.OK);
	}
	
	@GetMapping("/get_users/{N}")
	public ResponseEntity<List<UserLocation>> getUsers(@PathVariable int N) throws LocationException{
		return new ResponseEntity<>(userLocationService.getUsers(N),HttpStatus.OK);
	}
	
}
