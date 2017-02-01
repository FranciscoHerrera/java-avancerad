package se.coredev.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	
	@ManyToOne(cascade = CascadeType.PERSIST)	
	private Address address;

	protected Employee() {
	}

	public Employee(String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return id + ", " + firstName + ", " + lastName + " : " + address;
	}

}
