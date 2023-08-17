package com.ambula.service;

import com.ambula.exception.AdminException;
import com.ambula.model.*;

public interface AdminService {
	
	public Admin registerAdmin(AdminDTO adminDTO) throws AdminException;
}
