package com.mindtree.service.serviceImplementation;



import com.mindtree.doa.TypeDoa;
import com.mindtree.doa.doaimplemenatation.TypeDoaImplemenatation;
import com.mindtree.entity.Type;
import com.mindtree.exceptionhandling.DoaException;
import com.mindtree.exceptionhandling.ServiceLayerException;
import com.mindtree.service.TypeService;



public class TypeServiceImplementation implements TypeService {
	TypeDoa tdoa=new TypeDoaImplemenatation();
	public boolean addType(Type type) throws ServiceLayerException {
		// TODO Auto-generated method stub
		boolean added=false;
		try {
			added=tdoa.addType(type);
		} catch (DoaException e) {
			// TODO Auto-generated catch block
			throw new ServiceLayerException("error in service Layer");
		}
		return added;
		
	}

}
