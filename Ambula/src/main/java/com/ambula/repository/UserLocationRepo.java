package com.ambula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ambula.model.UserLocation;

@Repository
public interface UserLocationRepo extends JpaRepository<UserLocation, Long>{

	@Query(value = "SELECT * FROM user_location " + "ORDER BY SQRT(POWER(latitude - 0, 2) + POWER(longitude - 0, 2)) "
			+ "LIMIT :n", nativeQuery = true)
	List<UserLocation> findNearestUsers(@Param("n") int n);
	
	
}
