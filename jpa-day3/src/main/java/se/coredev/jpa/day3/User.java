package se.coredev.jpa.day3;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;

	private String username;
	private String metadata;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Role role;
	
	protected User(){}
	
	public User(String username, Role role){
		this.username = username;
		this.role = role;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getMetadata() {
		return metadata;
	}
	
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Role getRole() {
		return role;
	}
	
	@Override
	public String toString() {
		return id + ", " + username + ", role:" + role;
	}
	
}
