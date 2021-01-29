package com.MeritAmericaBank.app;

public class SavingsAccount extends BankAccount {
 
		private static final double INTEREST_RATE = 0.01;
		
		public SavingsAccount(double openingBalance) {
			super(openingBalance, INTEREST_RATE);
		}

		
}
