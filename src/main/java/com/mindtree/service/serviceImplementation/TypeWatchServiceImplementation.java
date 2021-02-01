package com.mindtree.service.serviceImplementation;

import com.mindtree.doa.TypeWatchDoa;
import com.mindtree.doa.doaimplemenatation.TypeWatchDoaImplementation;
import com.mindtree.exceptionhandling.DoaException;
import com.mindtree.exceptionhandling.ServiceLayerException;
import com.mindtree.service.TypeWatchService;

public class TypeWatchServiceImplementation implements TypeWatchService {
	TypeWatchDoa doa=new TypeWatchDoaImplementation();

	public boolean deleteType(int id) throws ServiceLayerException {
		// TODO Auto-generated method stub
		boolean deleted=false;
		try {
			deleted=doa.deleteType(id);
		} catch (DoaException e) {
			// TODO Auto-generated catch block
			throw new ServiceLayerException(e);
		} 
		return deleted;
		
	}

	
}
