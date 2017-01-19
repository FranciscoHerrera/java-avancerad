package se.coredev.jpa;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.coredev.jpa.model.Address;
import se.coredev.jpa.model.Computer;
import se.coredev.jpa.model.Employee;
import se.coredev.jpa.model.Software;

public final class Main {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {

		EntityManager manager = FACTORY.createEntityManager();

//		Computer computer = manager.find(Computer.class, 2L);
//		computer.getEmployees().forEach(System.out::println);
		
		Address address = new Address("street", "postal", "zip");
		Software software = new Software("XCode");
		Collection<Software> softwares = new HashSet<>();
		softwares.add(software);
		
		Computer computer = new Computer("apple", "MacBook Pro, late 2016", softwares);
		Employee employee = new Employee("firstName", "lastName", "username", "password", address, computer);
		
		manager.getTransaction().begin();
		manager.persist(software);
		manager.persist(employee);
		manager.persist(computer);
		manager.getTransaction().commit();
		
	}

}
