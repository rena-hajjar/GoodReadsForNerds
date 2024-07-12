package com.renaspring.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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

	record NewBookRequest(
			String title,
			String author,
			Date dateStarted
	) {}

	@PostMapping
	public void addBook(@RequestBody NewBookRequest request) {
		Book book = new Book();
		book.setTitle(request.title);
		book.setAuthor(request.author);
		book.setStatus(BookStatus.BACKLOGGED); // decide what the 3 things will be
		book.setDateStarted(request.dateStarted);

		bookRepository.save(book);
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

	// boi this does not work
	@PutMapping("{customerId}")
	public void updateCustomer(ChangeCustomerRequest changeRequest, @PathVariable("customerId") Integer id) {
		Book book = bookRepository.getReferenceById(id);
        changeRequest.name.ifPresent(book::setTitle);

		bookRepository.save(book);
	}
}
