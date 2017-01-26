package se.coredev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Main {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {

		EntityManager manager = FACTORY.createEntityManager();

		try {
			manager.getTransaction().begin();
			manager.persist(new Employee("Luke", "Skywalker").addNote("test1").addNote("test2"));
			manager.persist(new Employee("Leia", "Skywalker"));
			manager.persist(new Employee("Anakin", "Skywalker"));
			manager.persist(new Employee("Rey", "Kenobi"));
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}

		try {
			manager = FACTORY.createEntityManager();
//			manager.createNamedQuery("Employee.GetAll", Employee.class).getResultList().forEach(System.out::println);
			manager.createNamedQuery("Employee.GetByFirstName", Employee.class)
				   .setParameter("firstName", "Luke")
				   .getResultList().forEach(System.out::println);
		} finally {
			manager.close();
		}
	}

	public static void main1(String[] args) {

		EntityManager manager = FACTORY.createEntityManager();
		Employee employee;
		ParkingSpot parkingSpot;

		try {
			employee = new Employee("firstName", "lastName");
			parkingSpot = new ParkingSpot("A-54");
			employee.setParkingSpot(parkingSpot);
			manager.getTransaction().begin();
			manager.persist(employee);
			manager.persist(parkingSpot);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}

		manager = FACTORY.createEntityManager();
		try {
			manager.getTransaction().begin();
			parkingSpot = manager.merge(parkingSpot);
			employee = manager.merge(employee);
			employee.setParkingSpot(null);
			manager.remove(parkingSpot);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
}
