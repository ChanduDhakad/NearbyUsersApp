package com.ambula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambula.exception.AdminException;
import com.ambula.model.*;
import com.ambula.repository.*;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin registerAdmin(AdminDTO adminDTO) throws AdminException {

		Admin newAdmin = null;
		Admin existingAdmin = adminRepository.findByEmail(adminDTO.getEmail());
		if (existingAdmin != null) {
			throw new AdminException("Admin already exist with EmailId " + adminDTO.getEmail());
		}
		Admin admin = new Admin();
		admin.setEmail(adminDTO.getEmail());
		admin.setPassword(adminDTO.getPassword());
		newAdmin = adminRepository.save(admin);
		return newAdmin;
	}
}
