package com.ambula.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ambula.exception.*;
import com.ambula.model.*;
import com.ambula.repository.*;

@Service
public class UserLocationServiceImpl implements UserLocationService {

	@Autowired
	private UserLocationRepository userLocationRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CurrentUserRepository currentUserRepository;

	@Override
	public List<UserLocation> getNearestUsers(Integer count, String readerKey)
			throws UserLocationException, ReaderException, LoginException {

		CurrentUserSession cus = currentUserRepository.findByUuid(readerKey);
		if (cus == null) {
			throw new LoginException("InValid Key");
		}
		List<UserLocation> allUsers = userLocationRepository.findAll();
		List<UserLocation> nearestUsers = allUsers.stream().filter(userLocation -> !userLocation.isExcluded())
				.sorted((user1, user2) -> Double.compare(calculateDistance(user1.getLatitude(), user1.getLongitude()),
						calculateDistance(user2.getLatitude(), user2.getLongitude())))
				.limit(count).collect(Collectors.toList());

		if (allUsers.size() == 0) {
			throw new UserLocationException("No User Present Near You");
		}
		return nearestUsers;
	}

	// method to calculate the distance from (0,0)
	private double calculateDistance(double latitude, double longitude) {
		return Math.sqrt(Math.pow(latitude, 2) + Math.pow(longitude, 2));
	}

	@Override
	public UserLocation createUserLocation(UserLocationDTO userLocationDTO, String adminKey)
			throws AdminException, LoginException {
		System.out.println(userLocationDTO);
		UserLocation newUserLocation = null;
		CurrentUserSession currentUser = currentUserRepository.findByUuid(adminKey);
		if (currentUser == null) {
			throw new LoginException("InValid Key");
		} else {
			Optional<Admin> opt = adminRepository.findById(currentUser.getUserId());
			if (opt.isEmpty()) {
				throw new AdminException("Admin Not Present With AdminId " + currentUser.getUserId());
			} else {

				UserLocation userLocation = new UserLocation();

				userLocation.setName(userLocationDTO.getName());
				userLocation.setLatitude(userLocationDTO.getLatitude());
				userLocation.setLongitude(userLocationDTO.getLongitude());
				userLocation.setExcluded(false);

				newUserLocation = userLocationRepository.save(userLocation);
			}
		}
		return newUserLocation;
	}

	@Override
	public UserLocation updateUserLocation(UserLocationDTO userLocationDTO, String adminKey)
			throws AdminException, LoginException, UserLocationException {
		UserLocation newUserLocation = null;
		CurrentUserSession currentUser = currentUserRepository.findByUuid(adminKey);
		if (currentUser == null) {
			throw new LoginException("InValid Key");
		} else {
			Optional<Admin> opt = adminRepository.findById(currentUser.getUserId());
			if (opt.isEmpty()) {
				throw new AdminException("Admin Not Present With AdminId " + currentUser.getUserId());
			} else {
				UserLocation userLocation = userLocationRepository.findByName(userLocationDTO.getName());

				if (userLocation == null) {
					throw new UserLocationException("Not  Location Present At " + userLocationDTO.getName());
				} else {

					userLocation.setName(userLocationDTO.getName());
					userLocation.setLatitude(userLocationDTO.getLongitude());
					userLocation.setLongitude(userLocationDTO.getLongitude());

					newUserLocation = userLocationRepository.save(userLocation);
				}
			}
		}
		return newUserLocation;
	}

}
