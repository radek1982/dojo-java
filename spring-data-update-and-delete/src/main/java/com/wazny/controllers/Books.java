package com.wazny.controllers;

import com.wazny.models.Book;
import com.wazny.repositories.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Books {

    private BookService bookService;
    Books(BookService bookServ) {
        this.bookService = bookServ;


    }
    @GetMapping("/books/{id}")
    public ModelAndView show(@PathVariable("id") Long id) {

        ModelMap model = new ModelMap();
        Book b = bookService.findBook(id);

        model.addAttribute("book", b);

        return new ModelAndView("show", model);

    }
}
