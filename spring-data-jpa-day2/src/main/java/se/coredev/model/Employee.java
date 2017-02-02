package se.coredev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String number;
	private String firstName;
	private String lastName;

	@ManyToOne
	private Address address;

	protected Employee() {
	}

	public Employee(String number, String firstName, String lastName, Address address) {
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public Long getId() {
		return id;
	}
	
	public String getNumber() {
		return number;
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
		return id + ", " + number + ", " + firstName + ", " + lastName + " : " + address;
	}

}
