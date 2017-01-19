package se.coredev.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	private String username;
	@Column(nullable = false, unique = true)
	private String password;
	@Embedded
	private Address address;

	@ManyToOne
	private Computer computer;

	protected Employee() {
	}

	public Employee(String firstName, String lastName, String username, String password, Address address,
			Computer computer) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.computer = computer;
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

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Address getAddress() {
		return address;
	}

	public Computer getComputer() {
		return computer;
	}

	@Override
	public String toString() {
		return id + ", " + firstName + ", " + lastName + ", " + username;
	}
}
