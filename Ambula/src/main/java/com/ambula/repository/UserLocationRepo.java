package com.ambula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambula.model.UserLocation;

public interface UserLocationRepo extends JpaRepository<UserLocation, Long>{

}
