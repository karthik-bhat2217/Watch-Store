package com.mindtree.service;

import com.mindtree.entity.Watch;
import com.mindtree.exceptionhandling.ServiceLayerException;

public interface WatchService {
	
	public boolean addWatchType(Watch watch) throws ServiceLayerException;
	public void sortWatches() throws ServiceLayerException;;
}
