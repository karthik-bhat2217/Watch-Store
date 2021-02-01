package com.mindtree.doa;

import java.util.Map;

import com.mindtree.entity.Type;
import com.mindtree.exceptionhandling.DoaException;

public interface TypeDoa {
	public boolean addType(Type type) throws DoaException;

	public Map<Integer, Type> getType() throws DoaException;

}
