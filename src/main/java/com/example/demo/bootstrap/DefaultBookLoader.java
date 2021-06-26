package com.example.demo.bootstrap;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.model.Book;
import com.example.demo.service.BookService;
import com.github.javafaker.Faker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
 
// Causes Lombok to generate a logger field.
@Slf4j
// Causes Lombok to generate a constructor with 1 parameter for each field that requires special handling.
@RequiredArgsConstructor
@Component
public class DefaultBookLoader implements CommandLineRunner {
 
    @Autowired
	private BookService bookService;
    
 
    @Override
    public void run(String... args) {
        loadBooksData();
    }
 
    private void loadBooksData() {
        if (bookService.getBooksCount() == 0) {
            log.info("Saving the default books into the database.");
            for (int x = 0; x < 5; x++) {
                bookService.save(createNewBook());
            }
        } else {
            log.info("Default books are already present in the database.");
        }
    }
 
    private Book createNewBook() {
        final int randomNumber = new Random().nextInt(10 - 5 + 1) + 5;
        Faker faker = new Faker();
        return Book.builder()
                .author(faker.book().author())
                .title(faker.book().title())
                .publisher(faker.book().publisher())
                .genre(faker.book().genre())
                .quantity(faker.number().numberBetween(50, 100))
                .publishedOn(LocalDateTime.now().minusHours(randomNumber)
                        .minus(Period.ofWeeks(randomNumber)))
                .build();
    }
}

