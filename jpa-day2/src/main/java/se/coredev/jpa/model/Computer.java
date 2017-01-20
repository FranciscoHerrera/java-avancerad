package se.coredev.jpa.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToOne(mappedBy = "computer")
	private Employee owner;
	
	@OneToMany
	private Collection<Software> softwares;

	protected Computer() {
	}

	public Computer(String brand, String model, Collection<Software> softwares) {
		this.brand = brand;
		this.model = model;
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
	
	public Employee getOwner() {
		return owner;
	}
	
//	public Collection<Employee> getEmployees() {
//		return employees;
//	}
	
	public Collection<Software> getSoftwares() {
		return softwares;
	}
}
