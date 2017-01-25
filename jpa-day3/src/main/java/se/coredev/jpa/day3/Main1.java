package se.coredev.jpa.day3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main1 {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {

		EntityManager manager = FACTORY.createEntityManager();
		Role role;

		try {
			manager.getTransaction().begin();
			role = new Role("admin");
			manager.persist(role);
			manager.persist(new User("Luke", role));
			manager.persist(new User("Leia", role));
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}

		try {
			manager = FACTORY.createEntityManager();
			role = manager.createQuery("select r from Role r join fetch r.users where r.name = :roleName", Role.class)
						  .setParameter("roleName", "admin")
						  .getSingleResult();
		} finally {
			manager.close();
		}

		role.getUsers().forEach(u -> System.out.println(u));
	}

}
