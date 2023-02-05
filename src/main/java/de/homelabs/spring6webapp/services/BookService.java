package de.homelabs.spring6webapp.services;

import de.homelabs.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findall();
}
