package de.homelabs.spring6webapp.repositories;

import de.homelabs.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
