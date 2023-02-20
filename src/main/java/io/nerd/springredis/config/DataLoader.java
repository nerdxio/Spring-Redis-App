package io.nerd.springredis.config;

import io.nerd.springredis.book.Book;
import io.nerd.springredis.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{
    final
    BookService bookService;

    public DataLoader(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

//        bookService.insert(new Book("Spring 5 recipes",150.3));
//        bookService.insert(new Book("Spring Boot 3",450.3));
//        bookService.insert(new Book("Head First Design Patterns",750.3));
//        bookService.insert(new Book("Clean Code",150.3));
//        bookService.insert(new Book("Databases Fundamentals",350.3));
    }
}
