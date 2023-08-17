package com.ambula.service;

import java.util.List;

import com.ambula.exception.AdminException;
import com.ambula.exception.LoginException;
import com.ambula.model.Admin;
import com.ambula.model.AdminDTO;


public interface AdminService {
	public Admin registerAdmin(AdminDTO adminDTO) throws AdminException;

	/*
	public Admin updateAdmin(Admin admin, String key) throws LoginException, AdminException;

	public String deleteAdmin(Integer adminId, String key) throws LoginException, AdminException;

	
	public Admin getAdminById(Integer adminId, String key) throws LoginException, AdminException;
*/

}
