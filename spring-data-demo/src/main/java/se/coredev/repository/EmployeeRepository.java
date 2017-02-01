package se.coredev.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import se.coredev.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	// select e from Employee e where e.lastName = :lastName
	Collection<Employee> findByLastName(String lastName);
	Collection<Employee> findByAddressStreet(String street);
	
}
