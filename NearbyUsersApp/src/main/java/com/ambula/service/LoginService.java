package com.ambula.service;

import com.ambula.exception.LoginException;
import com.ambula.model.CurrentUserSession;
import com.ambula.model.Login;


public interface LoginService {
	
    public CurrentUserSession readerLogin(Login login) throws LoginException;

	public String Logout(Integer id , String uuid) throws LoginException;
	
	public CurrentUserSession adminlogin(Login login) throws LoginException;
}
