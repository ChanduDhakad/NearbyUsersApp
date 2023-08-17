package com.ambula.service;

import java.util.List;

import com.ambula.exception.*;
import com.ambula.model.*;

public interface UserLocationService {

	public UserLocation createUserLocation(UserLocationDTO userLocationDTO, String adminKey)
			throws AdminException, LoginException;

	public UserLocation updateUserLocation(UserLocationDTO userLocationDTO, String adminKey)
			throws AdminException, LoginException, UserLocationException;

	public List<UserLocation> getNearestUsers(Integer count, String readerKey)
			throws UserLocationException, ReaderException, LoginException;
}
