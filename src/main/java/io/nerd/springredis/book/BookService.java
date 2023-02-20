package io.nerd.springredis.book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    Book findById(final Long id);
    Book insert(final Book book);
    Book update(final Book book);
    String deleteById(final Long id);
}
