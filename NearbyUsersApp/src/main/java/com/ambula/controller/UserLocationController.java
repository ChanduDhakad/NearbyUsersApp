package com.ambula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ambula.exception.AdminException;
import com.ambula.exception.LoginException;
import com.ambula.exception.UserLocationException;
import com.ambula.model.UserLocation;
import com.ambula.model.UserLocationDTO;
import com.ambula.service.UserLocationService;

@RestController
@RequestMapping("/ambula")
public class UserLocationController {

	@Autowired
	private UserLocationService userLocationService;

	@PostMapping("/create_data")
	public UserLocation createUserLocation(@RequestBody UserLocationDTO userLocationDTO,@RequestParam String adminKey) throws AdminException, LoginException {
		return userLocationService.createUserLocation(userLocationDTO,adminKey);
	}

	@PatchMapping("/update_data")
	public UserLocation updateUserLocation( @RequestBody UserLocationDTO userLocationDTO,@RequestParam String adminKey) throws AdminException, LoginException, UserLocationException {
		return userLocationService.updateUserLocation(userLocationDTO,adminKey);
	}

//	@GetMapping("/get_users/{n}")
//	public List<UserLocation> getNearestUsers(@PathVariable int n) {
//		return userLocationService.getNearestUsers(n);
//	}
}
