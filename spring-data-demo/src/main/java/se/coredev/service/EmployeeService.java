package se.coredev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import se.coredev.model.Employee;
import se.coredev.repository.AddressRepository;
import se.coredev.repository.EmployeeRepository;

@Component
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final AddressRepository addressRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
		this.employeeRepository = employeeRepository;
		this.addressRepository = addressRepository;
	}

	public Employee addEmpoloyee(Employee employee) {
		// Add business logic here 
		return employeeRepository.save(employee);
	}

}
