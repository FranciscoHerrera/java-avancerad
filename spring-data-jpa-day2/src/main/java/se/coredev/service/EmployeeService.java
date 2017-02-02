package se.coredev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import se.coredev.model.Employee;
import se.coredev.repository.AddressRepository;
import se.coredev.repository.EmployeeRepository;

@Component
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final AddressRepository addressRepository;
	private final ServiceTransaction executor;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository, AddressRepository addressRepository, ServiceTransaction executor) {
		this.employeeRepository = employeeRepository;
		this.addressRepository = addressRepository;
		this.executor = executor;
	}

	public Employee addEmployee(Employee employee) throws ServiceException {
		try {
			return executor.execute(() -> {
				addressRepository.save(employee.getAddress());
				return employeeRepository.save(employee);
			});
		} catch (DataAccessException e) {
			throw new ServiceException("Could not add Employee", e);
		}
	}

}
