package com.Week5Pair.app;

public class ExceedsFraudSuspicionLimitException extends Exception {
	
	ExceedsFraudSuspicionLimitException(String errorMessage){
		super(errorMessage);
	}
	
}
