
public class AccountHolder {
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	private double checkingAccountOpeningBalance;
	private double savingsAccountOpeningBalance;
	
	public AccountHolder() {
	
}
	public AccountHolder(String firstName, String middleName, String lastName, String ssn, 
			double checkingAccountOpeningBalance, double savingsAccountOpeningBalance) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.checkingAccountOpeningBalance = checkingAccountOpeningBalance;
		this.savingsAccountOpeningBalance = savingsAccountOpeningBalance;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	
	public String getMiddleName() {
		return middleName;
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getlastName() {
		return lastName;
	}
	
	
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	
	
	public String getSSN() {
		return ssn;
	}
	
	
	public CheckingAccount getCheckingAccount() {
		return CheckingAccount(checkingAccountOpeningBalance);
	}
	
	
	private CheckingAccount CheckingAccount(double checkingAccountOpeningBalance2) {
		
		return null;
	}
	public SavingsAccount getSavingAccount() {
		return SavingAccount(savingsAccountOpeningBalance);
	}
	
	
	private SavingsAccount SavingAccount(double savingsAccountOpeningBalance2) {
		
		return null;
	}
	private String toString() {
		
		
	}
	
	
}
