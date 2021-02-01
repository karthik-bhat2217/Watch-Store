package com.mindtree.WatchStore;

import java.util.Scanner;
import com.mindtree.exceptionhandling.WatchStoreException;
import com.mindtree.service.TypeService;
import com.mindtree.service.TypeWatchService;
import com.mindtree.service.WatchService;
import com.mindtree.service.serviceImplementation.TypeServiceImplementation;
import com.mindtree.service.serviceImplementation.TypeWatchServiceImplementation;
import com.mindtree.service.serviceImplementation.WatchServiceImplementation;
import com.mindtree.utility.InputReader;

public class WatchStoreDriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WatchStoreDriverClass obj = new WatchStoreDriverClass();
		Scanner in = new Scanner(System.in);
		InputReader reader = new InputReader(in);
		WatchService wservice = new WatchServiceImplementation();
		TypeService tservice = new TypeServiceImplementation();
		TypeWatchService twservice = new TypeWatchServiceImplementation();
		boolean exit = false;
		do {
			obj.displayMenu();
			byte choice = reader.readChoice();
			switch (choice) {
			case 1:
				boolean added = false;
				try {
					added = tservice.addType(reader.readTypeDetatils());
				} catch (WatchStoreException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				if (added) {
					System.out.println("Type sucessfully added");
				}

				break;
			case 2:
				added = false;
				try {
					added = wservice.addWatchType(reader.readWatchDetails());
				}

				catch (WatchStoreException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				if (added) {
					System.out.println("Watch sucessfully added");
				}
				break;
			case 3:
				try {
					wservice.sortWatches();
				} catch (WatchStoreException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				boolean deleted = false;
				try {
					deleted = twservice.deleteType(reader.readId());
				} catch (WatchStoreException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				if (deleted) {
					System.out.println("Type Successfull deleted");
				}
				break;
			case 5:
				System.out.println("thank you!!");
				exit = true;
				break;
			default:
				System.out.println("Invalid input");
			}

		} while (!exit);

	}

	private void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("1:Add Type\n2:Add Watch\n3:Sort All Watches based on Price\n4:Delete Type\n5:Exit");

	}

}
