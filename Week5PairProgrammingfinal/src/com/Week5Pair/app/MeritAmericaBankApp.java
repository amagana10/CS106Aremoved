package com.Week5Pair.app;

import java.text.ParseException;

public class MeritAmericaBankApp {

	public static void main(String[] args) throws NumberFormatException, ParseException {
		try {
			MeritBank.readFromFile("PairProgrammingData.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
