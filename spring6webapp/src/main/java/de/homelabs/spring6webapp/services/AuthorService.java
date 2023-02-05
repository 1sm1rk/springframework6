package de.homelabs.spring6webapp.services;

import de.homelabs.spring6webapp.domain.Author;
import de.homelabs.spring6webapp.domain.Book;

public interface AuthorService {

    Iterable<Author> findall();
}
