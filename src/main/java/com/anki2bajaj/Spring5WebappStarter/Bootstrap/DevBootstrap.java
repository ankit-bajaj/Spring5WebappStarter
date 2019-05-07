package com.anki2bajaj.Spring5WebappStarter.Bootstrap;

import com.anki2bajaj.Spring5WebappStarter.model.Author;
import com.anki2bajaj.Spring5WebappStarter.model.Book;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;



public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author eric = new Author("Eric", "Evan") ;
        Book ddd = new Book("Domain Driven Design " ,"1234", "Harper collin" );

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rob = new Author("Rob" , "Johnas");
        Book noEJB = new Book("j2ee without ejb" , "1234", "Wrox");
        rob.getBooks().add(noEJB);

    }
}
