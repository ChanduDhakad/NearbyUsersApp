package com.ambula.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.ambula.exception.*;
import com.ambula.model.*;
import com.ambula.service.AdminService;

@RestController
@RequestMapping("/ambula")
public class AdminController {

	@Autowired
	private AdminService aservice;

	@PostMapping("/admin")
	public ResponseEntity<Admin> addAdminHandler(@Valid @RequestBody AdminDTO adminDTO) throws AdminException {

		Admin savedAdmin = aservice.registerAdmin(adminDTO);

		return new ResponseEntity<Admin>(savedAdmin, HttpStatus.ACCEPTED);
	}

}