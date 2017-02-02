package se.coredev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import se.coredev.model.Address;
import se.coredev.model.Employee;
import se.coredev.service.EmployeeService;
import se.coredev.service.ServiceException;

@SpringBootApplication
public class SpringDataDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			EmployeeService service = context.getBean(EmployeeService.class);
			try {
				service.addEmployee(new Employee("1000", "Luke1", "Skywalker", new Address("street1", "postal1", "zip1")));
				service.addEmployee(new Employee("1000", "Luke1", "Skywalker", new Address("street1", "postal1", "zip1")));
			} catch (ServiceException e) {
				System.out.println(e.getMessage());
			}
		};

	}

}
