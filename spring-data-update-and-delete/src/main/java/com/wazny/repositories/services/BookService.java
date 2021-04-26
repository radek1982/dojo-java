package com.wazny.repositories.services;

import com.wazny.models.Book;
import com.wazny.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {

        Book b = this.findBook(id);
        b.setTitle(title);
        b.setDescription(desc);
        b.setLanguage(lang);
        b.setNumberOfPages(numOfPages);

        return bookRepository.save(b);

    }

    public void deleteBook(Long id) {

        bookRepository.deleteById(id);
    }
}