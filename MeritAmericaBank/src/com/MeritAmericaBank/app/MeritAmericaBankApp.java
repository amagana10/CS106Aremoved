package com.MeritAmericaBank.app;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		CDOffering [] offers = generateOffers(); 
		
		MeritBank.setCDOfferings(offers);  
		
		AccountHolder ah1 = getAccountHolder();  
		
		ah1.addCheckingAccount(1000.0);
		ah1.addSavingsAccount(10000.00);
	
		
		CheckingAccount checkingAccountOne = new CheckingAccount(5000.0); 
		SavingsAccount savingsAccountOne = new SavingsAccount(50000.0);
		
		ah1.addCheckingAccount(checkingAccountOne);
		ah1.addSavingsAccount(savingsAccountOne);
		
		// to test the out put
		System.out.println("Total checking account balance = "+ah1.getCheckingBalance());
		System.out.println("Total saving account balance = "+ah1.getSavingsBalance());
		System.out.println("Total checking and saving account balance = "+ah1.getCombinedBalance());
		
		ah1.addCheckingAccount(50000.0);
		ah1.addSavingsAccount(500000.00);
		ah1.addCheckingAccount(5000.0);
		ah1.addSavingsAccount(50000.00);
		System.out.println("Total checking account balance = "+ah1.getCheckingBalance()+ "  and Total saving account balance = " +ah1.getSavingsBalance());
	
	
	
	}
	
	private static CDOffering []  generateOffers() {
		
		return new CDOffering [] { 
				new CDOffering(1, 1.8),
				new CDOffering(2, 1.9),
				new CDOffering(3, 2.0),
				new CDOffering(5, 2.5),
				new CDOffering(10, 2.2)};
	}
	
	private static AccountHolder getAccountHolder() {
		return new AccountHolder(
				"Gebremedhin",
				"Tadesse",
				"Mengesha",
				"722-22-2227");
	}

}
