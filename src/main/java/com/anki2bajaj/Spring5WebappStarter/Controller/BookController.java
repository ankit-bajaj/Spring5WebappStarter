package com.anki2bajaj.Spring5WebappStarter.Controller;


import com.anki2bajaj.Spring5WebappStarter.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @RequestMapping("/books")
    public String getBooks(Model model){ // passing a model attribute which act as a transportor to view

        model.addAttribute("books_model" , bookRepository.findAll()); // here typo mistake here initially written book but in view template we were using books , so make books here

        return "books" ; // its just returning to view page named books       ie. books.html in view folder in resources
                                // name can be any thing but that should be same in view folder
    }
}
