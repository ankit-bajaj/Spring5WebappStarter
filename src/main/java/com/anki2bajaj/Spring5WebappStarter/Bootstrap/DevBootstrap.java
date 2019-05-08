package com.anki2bajaj.Spring5WebappStarter.Bootstrap;

import com.anki2bajaj.Spring5WebappStarter.Repository.AuthorRepository;
import com.anki2bajaj.Spring5WebappStarter.Repository.BookRepository;
import com.anki2bajaj.Spring5WebappStarter.Repository.PublisherRepository;
import com.anki2bajaj.Spring5WebappStarter.model.Author;
import com.anki2bajaj.Spring5WebappStarter.model.Book;

import com.anki2bajaj.Spring5WebappStarter.model.Publisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component   // for making this as a component work and intialising in spring container
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    // injecting repository to the component

    private AuthorRepository authorRepository;
    private BookRepository bookRepository ;
    private PublisherRepository publisherRepository; // adding this new repository

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("Foo");
        Author eric = new Author("Eric", "Evan") ;
        Book ddd = new Book("Domain Driven Design " ,"1234",publisher );

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);  // calling JPA repository save method , will create new element
        bookRepository.save(ddd);

        Author rob = new Author("Rob" , "Johnas");
        Book noEJB = new Book("j2ee without ejb" , "1234", publisher);
        rob.getBooks().add(noEJB);

        authorRepository.save(rob);
    }
}
