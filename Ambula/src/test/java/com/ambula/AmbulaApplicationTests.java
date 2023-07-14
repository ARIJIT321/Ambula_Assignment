package com.ambula;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ambula.exception.LocationException;
import com.ambula.model.UserLocation;
import com.ambula.repository.UserLocationRepo;
import com.ambula.service.UserLocationServiceImpl;

@SpringBootTest
class AmbulaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
    private UserLocationRepo locationRepo;

    @InjectMocks
    private UserLocationServiceImpl userLocationService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateData() {
        UserLocation userLocation = new UserLocation();
        userLocation.setId(1L);
        userLocation.setName("Location 1");
        userLocation.setLatitude(40.7128);
        userLocation.setLongitude(-74.0060);

        when(locationRepo.save(any(UserLocation.class))).thenReturn(userLocation);

        UserLocation savedLocation = userLocationService.createData(userLocation);

        assertEquals(userLocation.getId(), savedLocation.getId());
        assertEquals(userLocation.getName(), savedLocation.getName());
        assertEquals(userLocation.getLatitude(), savedLocation.getLatitude());
        assertEquals(userLocation.getLongitude(), savedLocation.getLongitude());
    }

    @Test
    public void testUpdateData() throws LocationException {
        Long id = 1L;
        UserLocation existingLocation = new UserLocation();
        existingLocation.setId(id);
        existingLocation.setName("Location 1");
        existingLocation.setLatitude(40.7128);
        existingLocation.setLongitude(-74.0060);

        UserLocation updatedLocation = new UserLocation();
        updatedLocation.setName("Updated Location");
        updatedLocation.setLatitude(41.8781);
        updatedLocation.setLongitude(-87.6298);

        when(locationRepo.findById(id)).thenReturn(Optional.of(existingLocation));
        when(locationRepo.save(any(UserLocation.class))).thenReturn(updatedLocation);

        UserLocation result = userLocationService.updateData(id, updatedLocation);

        assertEquals(updatedLocation.getName(), result.getName());
        assertEquals(updatedLocation.getLatitude(), result.getLatitude());
        assertEquals(updatedLocation.getLongitude(), result.getLongitude());
    }

    @Test
    public void testUpdateData_LocationNotFound() {
        Long id = 1L;
        UserLocation updatedLocation = new UserLocation();
        updatedLocation.setName("Updated Location");
        updatedLocation.setLatitude(41.8781);
        updatedLocation.setLongitude(-87.6298);

        when(locationRepo.findById(id)).thenReturn(Optional.empty());

        assertThrows(LocationException.class, () -> {
            userLocationService.updateData(id, updatedLocation);
        });
    }

    @Test
    public void testGetUsers() throws LocationException {
        int n = 5;
        List<UserLocation> userLocations = new ArrayList<>();
        userLocations.add(new UserLocation(1L, "Location 1", 40.7128, -74.0060));
        userLocations.add(new UserLocation(2L, "Location 2", 41.8781, -87.6298));
        userLocations.add(new UserLocation(3L, "Location 3", 34.0522, -118.2437));

        when(locationRepo.findNearestUsers(n)).thenReturn(userLocations);

        List<UserLocation> result = userLocationService.getUsers(n);

        assertEquals(userLocations.size(), result.size());
        assertEquals(userLocations.get(0).getName(), result.get(0).getName());
        assertEquals(userLocations.get(1).getLatitude(), result.get(1).getLatitude());
        assertEquals(userLocations.get(2).getLongitude(), result.get(2).getLongitude());
    }

    @Test
    public void testGetUsers_NoLocationsFound() {
        int n = 5;
        List<UserLocation> userLocations = new ArrayList<>();

        when(locationRepo.findNearestUsers(n)).thenReturn(userLocations);

        assertThrows(LocationException.class, () -> {
            userLocationService.getUsers(n);
        });
    }
}
