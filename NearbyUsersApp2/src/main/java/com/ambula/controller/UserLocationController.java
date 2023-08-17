package com.ambula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.ambula.exception.*;
import com.ambula.model.*;
import com.ambula.service.UserLocationService;

@RestController
@RequestMapping("/ambula")
public class UserLocationController {

	@Autowired
	private UserLocationService userLocationService;

	@PostMapping("/create_data")
	public ResponseEntity<UserLocation> createUserLocationHandler(@RequestBody UserLocationDTO userLocationDTO,
			@RequestParam String adminKey) throws AdminException, LoginException {
		UserLocation ul = userLocationService.createUserLocation(userLocationDTO, adminKey);

		return new ResponseEntity<UserLocation>(ul, HttpStatus.CREATED);
	}

	@PatchMapping("/update_data")
	public ResponseEntity<UserLocation> updateUserLocationHandler(@RequestBody UserLocationDTO userLocationDTO,
			@RequestParam String adminKey) throws AdminException, LoginException, UserLocationException {
		UserLocation ul = userLocationService.updateUserLocation(userLocationDTO, adminKey);
		return new ResponseEntity<UserLocation>(ul, HttpStatus.OK);
	}

	@GetMapping("/get_users/{n}")
	public ResponseEntity<List<UserLocation>> getNearestUsersHandler(@PathVariable Integer n, @RequestParam String key)
			throws UserLocationException, ReaderException, LoginException {
		List<UserLocation> list = userLocationService.getNearestUsers(n, key);
		return new ResponseEntity<List<UserLocation>>(list, HttpStatus.OK);
	}
}
