package com.ambula.service;

import com.ambula.exception.LoginException;
import com.ambula.model.*;

public interface LoginService {

	public CurrentUserSession readerLogin(Login login) throws LoginException;

	public String Logout(Integer id, String uuid) throws LoginException;

	public CurrentUserSession adminlogin(Login login) throws LoginException;
}
