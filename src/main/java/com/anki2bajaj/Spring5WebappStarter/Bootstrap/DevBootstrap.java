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

        publisherRepository.save(publisher);
        // this is also necessary becoz if not done then error will be thrown
        /*
        * org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is org.hibernate.MappingException: Could not determine type for: com.anki2bajaj.Spring5WebappStarter.model.Publisher, at table: book, for columns: [org.hibernate.mapping.Column(publisher)]
	     at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1782) ~[spring-beans-5.2.0.M1.jar:5.2.0.M1]
        * */

        //        therefore for every repository there should be comit ie for every ##entity corresponding JPARepository shouldbe commited
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
        // line 64 was missing so compilation error , my fault ,,, concerntrate
        bookRepository.save(noEJB);

    }
}
