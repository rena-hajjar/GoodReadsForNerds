package com.renaspring.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class SpringDemoApplication {

	private final CustomerRespository customerRepository;

    public SpringDemoApplication(CustomerRespository customerRepository) {
        this.customerRepository = customerRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@GetMapping
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	record NewCustomerRequest(
			String name,
			String email,
			Integer age
	) {}

	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest request) {
		Customer customer = new Customer();
		customer.setAge(request.age);
		customer.setEmail(request.email);
		customer.setName(request.name);

		customerRepository.save(customer);
	}

	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer id) {
		customerRepository.deleteById(id);
	}

	record ChangeCustomerRequest(
			Optional<String> name,
			Optional<Integer> age,
			Optional<String> email
	) {}

	@PutMapping("{customerId}")
	public void updateCustomer(ChangeCustomerRequest changeRequest, @PathVariable("customerId") Integer id) {
		Customer customer = customerRepository.getReferenceById(id);
		changeRequest.age.ifPresent(customer::setAge);
        changeRequest.name.ifPresent(customer::setName);
		changeRequest.email.ifPresent(customer::setEmail);

		customerRepository.save(customer);
	}
}
