package de.homelabs.spring6webapp.bootstrap;

import de.homelabs.spring6webapp.domain.Author;
import de.homelabs.spring6webapp.domain.Book;
import de.homelabs.spring6webapp.domain.Publisher;
import de.homelabs.spring6webapp.repositories.AuthorRepository;
import de.homelabs.spring6webapp.repositories.BookRepository;
import de.homelabs.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("1234567");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("57638790223");

        Author ericSaved    = authorRepository.save(eric);
        Author rodSaved     = authorRepository.save(rod);

        Book dddSaved       = bookRepository.save(ddd);
        Book noEJBSaved     = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("kjdshfkljhdsf");
        publisher.setCity("sdfdsf");
        publisher.setAddress("kjhgfkhf");
        publisher.setZip("12345");
        publisher.setState("dfglkjdlkjg");

        Publisher publisherSaved = publisherRepository.save(publisher);

        dddSaved.setPublisher(publisherSaved);
        noEJBSaved.setPublisher(publisherSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count:" + authorRepository.count());
        System.out.println("Book count:" + bookRepository.count());
        System.out.println("Publisher count:" + publisherRepository.count());
    }
}
