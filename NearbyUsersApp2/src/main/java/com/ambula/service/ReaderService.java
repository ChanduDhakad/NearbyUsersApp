package com.ambula.service;

import com.ambula.exception.*;
import com.ambula.model.*;

public interface ReaderService {
	public Reader AddReader(ReaderDTO readerDTO) throws ReaderException;

	/*
	 * public Reader updateReader(String key,Reader reader)throws
	 * UserException,LoginException;
	 * 
	 * 
	 * public String deleteRe(Integer UserId, String key)throws
	 * UserException,LoginException;
	 * 
	 * 
	 */
}
