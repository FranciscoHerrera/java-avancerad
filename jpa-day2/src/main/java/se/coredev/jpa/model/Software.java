package se.coredev.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "software")
public class Software {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	protected Software() {
	}

	public Software(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
