package se.coredev.jpa.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@OneToOne
	@JoinColumn(unique = true)
	private Computer computer;

	@OneToMany
	private Collection<Role> roles;

	protected Employee() {
	}

	public Employee(String firstName, String lastName, String username, String password, Address address,
			Computer computer, Collection<Role> roles) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.computer = computer;
		this.roles = roles;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	@Override
	public String toString() {
		return id + ", " + firstName + ", " + lastName + ", " + username;
	}
}
