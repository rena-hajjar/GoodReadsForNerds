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

	private final BookRepository bookRepository;

	public SpringDemoApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@GetMapping
	public List<Book> getCustomers() {
		return bookRepository.findAll();
	}

	record NewCustomerRequest(
			String name,
			String email,
			Integer age
	) {}

	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest request) {
		Book customer = new Book();
		customer.setName(request.name);

		bookRepository.save(customer);
	}

	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer id) {
		bookRepository.deleteById(id);
	}

	record ChangeCustomerRequest(
			Optional<String> name,
			Optional<Integer> age,
			Optional<String> email
	) {}

	@PutMapping("{customerId}")
	public void updateCustomer(ChangeCustomerRequest changeRequest, @PathVariable("customerId") Integer id) {
		Book book = bookRepository.getReferenceById(id);
        changeRequest.name.ifPresent(book::setName);

		bookRepository.save(book);
	}
}
