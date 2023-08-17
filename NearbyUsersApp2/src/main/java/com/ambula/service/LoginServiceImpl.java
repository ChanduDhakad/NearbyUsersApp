package com.ambula.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambula.exception.*;
import com.ambula.model.*;
import com.ambula.repository.*;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CurrentUserRepository currentUserRepository;

	@Autowired
	private ReaderRepository readerRepository;

	@Override
	public CurrentUserSession readerLogin(Login login) throws LoginException {

		CurrentUserSession activeUser = null;
		Reader user = readerRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
		if (user == null) {
			throw new LoginException("Invalid Credentials");
		} else {
			Optional<CurrentUserSession> opt = currentUserRepository.findById(user.getReaderId());
			if (opt.isPresent()) {
				throw new LoginException("Reader Already Logged In....");
			} else {
				String uuid = RandomString.make(6);
				CurrentUserSession cus = new CurrentUserSession(user.getReaderId(), LocalDateTime.now(), uuid);
				activeUser = currentUserRepository.save(cus);
			}
		}
		return activeUser;

	}

	@Override
	public String Logout(Integer id, String uuid) throws LoginException {

		CurrentUserSession cus = currentUserRepository.findByUuid(uuid);
		if (cus == null)
			throw new LoginException("Invalid Key....");

		if (id != cus.getUserId())
			throw new LoginException("Invalid Credentials");

		currentUserRepository.delete(cus);
		return "Logged Out";
	}

	@Override
	public CurrentUserSession adminlogin(Login login) throws LoginException {
		CurrentUserSession activeAdmin = null;
		Admin admin = adminRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
		if (admin == null) {
			throw new LoginException("Invalid Credentials");
		} else {
			Optional<CurrentUserSession> opt = currentUserRepository.findById(admin.getAdminId());
			if (opt.isPresent()) {
				throw new LoginException("Admin Already Logged In....");
			} else {
				new RandomString();
				String uuid = RandomString.make(6);
				CurrentUserSession cus = new CurrentUserSession(admin.getAdminId(), LocalDateTime.now(), uuid);
				activeAdmin = currentUserRepository.save(cus);
			}
		}
		return activeAdmin;
	}

}
