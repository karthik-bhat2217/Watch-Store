package com.mindtree.service.serviceImplementation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.mindtree.doa.TypeDoa;
import com.mindtree.doa.WatchDoa;
import com.mindtree.doa.doaimplemenatation.TypeDoaImplemenatation;
import com.mindtree.doa.doaimplemenatation.WatchDoaImplementation;
import com.mindtree.entity.Type;
import com.mindtree.entity.Watch;
import com.mindtree.exceptionhandling.DoaException;
import com.mindtree.exceptionhandling.ServiceLayerException;
import com.mindtree.exceptionhandling.TypeNotFoundException;

public class WatchServiceImplementation implements com.mindtree.service.WatchService {
	WatchDoa wdoa = new WatchDoaImplementation();
	TypeDoa tdoa = new TypeDoaImplemenatation();

	public boolean addWatchType(Watch watch) throws ServiceLayerException {

		boolean added = false;
		try {
			Map<Integer, Type> types = tdoa.getType();

			boolean found = false;
			for (int i : types.keySet()) {
				Type type = types.get(i);
				if (watch.getTypeID() == type.getId()) {
					found = true;
					added = wdoa.addWatch(watch);

				}

			}
			if (found == false) {

				throw new TypeNotFoundException("Type not found");

			}

		} catch (DoaException e) {

			throw new ServiceLayerException(e);
		}
		return added;

	}

	public void sortWatches() throws ServiceLayerException {

		List<Watch> watches;

		watches = getWatchList();

		Collections.sort(watches);
		if (watches.size() > 0) {
			displayWatches(watches);
		} else {
			System.out.println("No watches to sort");
		}

	}

	private void displayWatches(List<Watch> watches) {

		for (Watch watch : watches) {
			System.out.println("Watch id " + watch.getId());
			System.out.println("Watch name " + watch.getModelName());
			System.out.println("Watch price " + watch.getPrice());
			System.out.println("Type id " + watch.getTypeID());
			System.out.println("------------------------------------");
		}

	}

	private List<Watch> getWatchList() throws ServiceLayerException {

		List<Watch> watches;
		try {
			watches = wdoa.getWatchList();
		} catch (DoaException e) {

			throw new ServiceLayerException("Error in service layer");
		}
		return watches;

	}

}
