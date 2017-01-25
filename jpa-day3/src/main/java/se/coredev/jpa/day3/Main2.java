package se.coredev.jpa.day3;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {
		
		User user = createUser("Luke", new Role("admin"));
//		user = getUser(1L);
		user.setUsername("Leia");
		updateUser(user);
	}

	public static User createUser(String username, Role role){
		EntityManager manager = FACTORY.createEntityManager();
		User user;
		try {
			manager.getTransaction().begin();
			user = new User(username, role);
			manager.persist(user);
			manager.getTransaction().commit();
			return user;
		} finally {
			manager.close();
		}
	}
	
	public static User getUser(Long id) {
		EntityManager manager = FACTORY.createEntityManager();
		try {
			return manager.find(User.class, id);
		} finally {
			manager.close();
		}
	}
	
	public static User updateUser(User user){
		EntityManager manager = FACTORY.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			user = manager.merge(user);
			user.setMetadata("Last update timestamp: " + new Date());
			manager.getTransaction().commit();
			return user;
		} finally {
			manager.close();
		}
	}
	
	


}
