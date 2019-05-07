package com.anki2bajaj.Spring5WebappStarter.Repository;

import com.anki2bajaj.Spring5WebappStarter.model.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author,Long > {

}
