package com.ambula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ambula.exception.*;
import com.ambula.model.Admin;
import com.ambula.model.CurrentUserSession;
import com.ambula.model.UserLocation;
import com.ambula.model.UserLocationDTO;
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
				userLocation.setLatitude(userLocationDTO.getLongitude());
				userLocation.setLongitude(userLocationDTO.getLongitude());

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
				Admin admin = opt.get();
				UserLocation userLocation = userLocationRepository.findByName(userLocationDTO.getName());

				if (userLocation == null) {
					throw new UserLocationException(
							"Not  Location Present At " + userLocationDTO.getName());
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
