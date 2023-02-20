package io.nerd.springredis.book;

import io.nerd.springredis.exception.RecordNotFoundExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Cacheable(value = "bookCache",key = "#root.methodName")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    @Cacheable(value = "bookCache",key = "#root.methodName")
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RecordNotFoundExecution("This Record ID " + id + " Not Found"));
    }

    @Override
    public Book insert(final Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        var existingBook = bookRepository
                .findById(book.getId())
                .orElseThrow(() -> new RecordNotFoundExecution("This Record Id " + book.getId() + " Not found"));
        existingBook.setName(book.getName());
        existingBook.setSalary(book.getSalary());
        return bookRepository.save(existingBook);
    }

    @Override
    public String deleteById(Long id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return "Customer with id " + id + " has been deleted";
        }
        throw new RecordNotFoundExecution("Book not found with id: " + id);
    }
}
