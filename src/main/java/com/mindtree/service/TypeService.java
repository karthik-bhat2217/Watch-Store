package com.mindtree.service;

import com.mindtree.entity.Type;
import com.mindtree.exceptionhandling.ServiceLayerException;

public interface TypeService {
	public boolean addType(Type type) throws ServiceLayerException;
}
