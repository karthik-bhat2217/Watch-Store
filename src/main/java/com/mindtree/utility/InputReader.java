package com.mindtree.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mindtree.entity.Type;
import com.mindtree.entity.Watch;
import com.mindtree.exceptionhandling.InputMissMatchException;

public class InputReader {
	Scanner s;

	public InputReader(Scanner s) {
		this.s = s;
	}

	public Byte readChoice() {

		byte input = -1;
		do {
			try {

				input = s.nextByte();
			} catch (InputMismatchException e) {
				System.out.println("Wrong input");
				s.next();
			}
		} while (input == -1);

		return input;

	}

	public Watch readWatchDetails() throws InputMissMatchException {
		Watch watch = new Watch();

		try {

			System.out.println("Enter the watch id");
			watch.setId(s.nextInt());
			System.out.println("Enter the watch name");
			watch.setModelName(s.next());
			System.out.println("Enter the watch price");
			watch.setPrice(s.nextFloat());
			System.out.println("Enter the type id");
			watch.setTypeID(s.nextInt());

		} catch (InputMismatchException e) {
			throw new InputMissMatchException("Invalid input");
		}

		return watch;
	}

	public Type readTypeDetatils() throws InputMissMatchException {
		Type type = new Type();
		try {
			System.out.println("Enter the type id");
			type.setId(s.nextInt());
			System.out.println("Enter the type name");
			type.setName(s.next());
		} catch (InputMismatchException e) {
			throw new InputMissMatchException("Invalid input");
		}
		return type;
	}

	public int readId() {
		int input = -1;
		do {
			try {
				System.out.println("Enter the id of the type");
				input = s.nextByte();
			} catch (InputMismatchException e) {
				System.out.println("Wrong input");
			}
		} while (input == -1);
		return input;
	}
}
