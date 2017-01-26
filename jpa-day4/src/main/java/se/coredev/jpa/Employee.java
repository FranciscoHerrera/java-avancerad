package se.coredev.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name = "Employee.GetAll", query = "select e from Employee e"), 
		@NamedQuery(name = "Employee.GetByFirstName", query = "select e from Employee e where e.firstName = :firstName") 
})
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;

	@OneToOne
	@JoinColumn(unique = true)
	private ParkingSpot parkingSpot;

	@ElementCollection
//	private Map<Integer, String> notes;
	private List<String> notes;
	
	protected Employee() {
	}

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.notes = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	
	public Employee addNote(String note){
//		public Employee addNote(Integer priority, String note){
//		notes.put(priority, note);
		notes.add(note);
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

}
