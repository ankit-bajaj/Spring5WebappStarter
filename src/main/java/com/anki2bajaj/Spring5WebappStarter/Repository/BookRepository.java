package com.anki2bajaj.Spring5WebappStarter.Repository;

import com.anki2bajaj.Spring5WebappStarter.model.Book;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book ,Long> {
// public interface BookRepository extends JpaRepository<Book ,Long>
}

