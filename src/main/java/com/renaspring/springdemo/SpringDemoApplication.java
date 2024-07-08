package com.renaspring.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@SpringBootApplication
@RestController
public class SpringDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	record GreetResponse(
			String greet,
			List<String> favLangs,
			Person person
	){}

	record Person(String name, int age, double savings){}

	@GetMapping("/greetme")
	private GreetResponse greet() {
		GreetResponse response = new GreetResponse(
				"Hello",
				List.of("Java", "Golang", "Javascript"),
				new Person("Rena", 19, 6000)
		);
		return response;
	}

	@GetMapping("/whoami")
	private Person whoiam() {
		GreetResponse response = new GreetResponse(
				"My name is",
				List.of("Python, Rust, Ruby, Spark"),
				new Person("Jed", 19, 30000)
		);

		return response.person();
	}
}
