package de.homelabs.spring6webapp.services;

import de.homelabs.spring6webapp.domain.Author;
import de.homelabs.spring6webapp.domain.Book;
import de.homelabs.spring6webapp.repositories.AuthorRepository;
import de.homelabs.spring6webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findall() {
        return authorRepository.findAll();
    }
}
