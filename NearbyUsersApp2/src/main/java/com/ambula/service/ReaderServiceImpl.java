package com.ambula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambula.exception.ReaderException;
import com.ambula.model.*;
import com.ambula.repository.*;

@Service
public class ReaderServiceImpl implements ReaderService {

	@Autowired
	CurrentUserRepository cur;

	@Autowired
	ReaderRepository readerRepository;

	@Autowired
	CurrentUserRepository currentUserRepository;

	@Override
	public Reader AddReader(ReaderDTO readerDTO) throws ReaderException {

		Reader newUser = null;
		Reader usr = readerRepository.findByEmail(readerDTO.getEmail());
		if (usr != null)
			throw new ReaderException("User with this Email already Exist");

		Reader reader = new Reader();

		reader.setReaderName(readerDTO.getReaderName());
		reader.setEmail(readerDTO.getEmail());
		reader.setPassword(readerDTO.getPassword());

		newUser = readerRepository.save(reader);
		return newUser;
	}

}
