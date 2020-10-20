
public class Employee {
	private String lastName;
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    public String toString() {
    	return  firstName + " " + lastName + " " +id;
    }

	private String firstName;
	private String id;
	
	public Employee() {} //default constructor
	
	public Employee(String lastName, String firstName, String id) {
		this.lastName =lastName;
		this.firstName =firstName;
		this.id = id;
	}

}
