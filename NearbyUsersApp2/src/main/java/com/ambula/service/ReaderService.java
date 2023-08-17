package com.ambula.service;

import com.ambula.exception.*;
import com.ambula.model.*;

public interface ReaderService {
	public Reader AddReader(ReaderDTO readerDTO) throws ReaderException;

}
