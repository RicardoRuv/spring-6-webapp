package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setIsbn("123456");
        ddd.setTitle("Domain Driven Design");

        Author ricardo = new Author();
        ricardo.setFirstName("Ricardo");
        ricardo.setLastName("Mendoza");

        Book ddd2 = new Book();
        ddd2.setIsbn("123456");
        ddd2.setTitle("Hello world expert");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisher.setZip("33701");
        publisher.setAddress("1234 Main St");

        Publisher publisherSaved = publisherRepository.save(publisher);


        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author ricardoSaved = authorRepository.save(ricardo);
        Book ddd2Saved = bookRepository.save(ddd2);

        ericSaved.getBooks().add(dddSaved);
        ricardoSaved.getBooks().add(ddd2Saved);

        authorRepository.save(ericSaved);
        authorRepository.save(ricardoSaved);
        publisherRepository.save(publisherSaved);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());

        
    }
}




