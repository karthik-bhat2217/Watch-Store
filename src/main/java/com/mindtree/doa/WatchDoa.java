package com.mindtree.doa;

import java.util.List;

import com.mindtree.entity.Watch;
import com.mindtree.exceptionhandling.DoaException;
import com.mindtree.exceptionhandling.TypeNotFoundException;

public interface WatchDoa {
	public boolean addWatch(Watch watch) throws DoaException, TypeNotFoundException ;
	public List<Watch> getWatchList() throws DoaException;

}
