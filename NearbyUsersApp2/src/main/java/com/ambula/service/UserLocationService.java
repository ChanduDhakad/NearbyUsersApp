package com.ambula.service;

import java.util.List;

import com.ambula.exception.AdminException;
import com.ambula.exception.LoginException;
import com.ambula.exception.UserLocationException;
import com.ambula.model.UserLocation;
import com.ambula.model.UserLocationDTO;

public interface UserLocationService {

	public UserLocation createUserLocation(UserLocationDTO userLocationDTO,String adminKey) throws AdminException,LoginException;

	public UserLocation updateUserLocation(UserLocationDTO userLocationDTO,String adminKey)throws AdminException,LoginException, UserLocationException;

	//public List<UserLocation> getNearestUsers(int n);
}
