package se.coredev;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.coredev.model.Employee;

public final class Main {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");
	
	public static void main(String[] args) {
		
		EntityManager manager = FACTORY.createEntityManager();
		
		// Find by primary key
//		Employee employee = manager.find(Employee.class, 1L);

		
		// Query
//		manager.createQuery("FROM Employee e WHERE e.firstName = :firstName", Employee.class)
//			   .setParameter("firstName", "Luke")
//			   .getResultList()
//			   .forEach(System.out::println);
								   
		
		// Create
//		Employee employee = new Employee("Rey", "Skywalker");
//		manager.getTransaction().begin();
//		manager.persist(new Employee("Luke", "Skywalker"));
//		manager.persist(new Employee("Leia", "Skywalker"));
//		manager.persist(new Employee("Rey", "Skywalker"));
//		manager.getTransaction().commit();
		
		// Update
		manager.getTransaction().begin();
		Employee employee = manager.find(Employee.class, 3L);
		employee.setLastName("Kenobi");
		manager.getTransaction().commit();
		
		
//		System.out.println(employee);
		
	}
	
}
