
public class SavingsAccount {
 
	
		private static final double INTEREST_RATE = .01;
		private double openingBalance;
		
		
		public SavingsAccount(double openingBalance) {
			this.openingBalance = openingBalance;
		}
		
	
		public double getBalance() {
			return openingBalance;
		}
		
		
		public double getInterestRate() {
				return INTEREST_RATE;
		}
			
	
		public boolean withdraw(double amount) {
			return ((amount <= openingBalance) && (amount >= 0));
		}
		
		
		public boolean deposit(double amount) {
			return (amount > 0);
		}
		
		
		public double futureValue(int years) {
			return (openingBalance*(Math.pow((1+INTEREST_RATE),years)));
		}
		
		public String toString(){
			return null;

			
		}
		
	
}
