package se.coredev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import se.coredev.model.Address;
import se.coredev.model.Employee;
import se.coredev.repository.EmployeeRepository;
import se.coredev.service.EmployeeService;

@SpringBootApplication
public class SpringDataDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(ApplicationContext context){
		return args -> {
			EmployeeService service = context.getBean(EmployeeService.class);
			Employee employee = service.addEmpoloyee(new Employee("Luke", "Skywalker", new Address("street1", "postal", "zip")));
			System.out.println(employee);
			
//			EmployeeRepository repository = context.getBean(EmployeeRepository.class);
//
//			repository.save(new Employee("Luke", "Skywalker", new Address("street1", "postal", "zip")));
//			repository.save(new Employee("Leia", "Skywalker", new Address("street2", "postal", "zip")));
//			repository.save(new Employee("Rey", "Kenobi", new Address("street3", "postal", "zip")));
//			
//			repository.findByAddressStreet("street3").forEach(System.out::println);
		};
		
	}
	
}
