package com.renaspring.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@EnableMongoRepositories
@RequestMapping("api/books")
public class MainApplication {

	private final BookRepository bookRepository;

    public MainApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	record NewBookRequest(
			String title,
			String author
	) {}

	@CrossOrigin
	@PostMapping("/new-book")
	public void addBook(@RequestBody NewBookRequest request) {
		Book book = new Book();
		book.setTitle(request.title);
		book.setAuthor(request.author);
		book.setStatus(BookStatus.BACKLOGGED); // decide what the 3 things will be

		bookRepository.save(book);
	}

	@CrossOrigin
	@GetMapping("/get-books")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
}
