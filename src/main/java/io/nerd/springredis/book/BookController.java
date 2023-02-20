package io.nerd.springredis.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Book>>findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book>findById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Book>insert(@RequestBody Book book){
        var savedBook = bookService.insert(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedBook.getId()).toUri();
       return ResponseEntity.created(location).body(savedBook);
    }

    @PutMapping("/")
    public ResponseEntity<Book>update(@RequestBody Book book){
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(bookService.deleteById(id));
    }
}
