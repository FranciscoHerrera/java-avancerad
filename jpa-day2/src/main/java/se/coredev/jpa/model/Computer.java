package se.coredev.jpa.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "computers")
public class Computer {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String brand;
	@Column(nullable = false)
	private String model;
	
	@OneToMany(mappedBy = "computer")
	private Collection<Employee> employees;
	
	@OneToMany
	private Collection<Software> softwares;

	protected Computer() {
	}

	public Computer(String brand, String model, Collection<Software> softwares) {
		this.brand = brand;
		this.model = model;
		this.employees = new HashSet<>();
		this.softwares = softwares;
	}

	public Long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}
	
	public Collection<Employee> getEmployees() {
		return employees;
	}
	
	public Collection<Software> getSoftwares() {
		return softwares;
	}
}
