package se.coredev.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import se.coredev.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	Page<Employee> findByFirstNameLike(String firstName, Pageable pageable);
	
	@Query("select e from Employee e where e.number = ?1")
	Employee getEmployeeByNo(String number);
	
	@Query("select e from #{#entityName} e where e.firstName like :fName and e.lastName like :lName")
	Collection<Employee> getEmployees(@Param("fName") String firstName, @Param("lName") String lastName);
}
