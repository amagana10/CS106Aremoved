
public class SavingsAccount {
 
	//All constants needed in class
		private static final double INTEREST_RATE = .01;
		private double openingBalance;
		
		//Default constructor
		public SavingsAccount(double openingBalance) {
			this.openingBalance = openingBalance;
		}
		
		//returns balance
		public double getBalance() {
			return openingBalance;
		}
		
		//returns interest rate
		public double getInterestRate() {
				return INTEREST_RATE;
		}
			
		//checks to see if amount is too much to be withdrawn or negative
		public boolean withdraw(double amount) {
			return ((amount <= openingBalance) && (amount >= 0));
		}
		
		
		public boolean deposit(double amount) {
			return (amount > 0);
		}
		
		
		public double futureValue(int years) {
			return (openingBalance*(Math.pow((1+INTEREST_RATE),years)));
		}
		
		private String toString(){

			
		}
		
	
}
