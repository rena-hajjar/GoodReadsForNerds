package com.renaspring.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/books")
public class MainApplication {

	private final BookRepository bookRepository;

    public MainApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@GetMapping
	public List<Book> getCustomers() {
		return bookRepository.findAll();
	}

	record NewBookRequest(
			String title,
			String author,
			String dateStarted
	) {}

	@PostMapping
	public void addBook(@RequestBody NewBookRequest request) {
		Book book = new Book();
		book.setTitle(request.title);
		book.setAuthor(request.author);
		book.setStatus(BookStatus.BACKLOGGED); // decide what the 3 things will be

		bookRepository.save(book);
	}

//	@DeleteMapping("{customerId}")
//	public void deleteCustomer(@PathVariable("customerId") Integer id) {
//		bookRepository.deleteById(id);
//	}
//
//	record ChangeCustomerRequest(
//			Optional<String> name,
//			Optional<Integer> age,
//			Optional<String> email
//	) {}
//
//	// boi this does not work
//	@PutMapping("{customerId}")
//	public void updateCustomer(ChangeCustomerRequest changeRequest, @PathVariable("customerId") Integer id) {
//		Book book = bookRepository.getReferenceById(id);
//        changeRequest.name.ifPresent(book::setTitle);
//
//		bookRepository.save(book);
//	}
}
