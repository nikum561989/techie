package com.barclays.assignment.librarymManagementSystem.controller;

import com.barclays.assignment.librarymManagementSystem.exception.NotFoundException;
import com.barclays.assignment.librarymManagementSystem.model.Book;
import com.barclays.assignment.librarymManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> findAllBooks() {
        final List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @GetMapping("/searchBook/{keyword}")
    public ResponseEntity<List<Book>> searchBook(@PathVariable("keyword") String keyword) throws NotFoundException {

        final List<Book> books = bookService.searchBooks(keyword);
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }


    @PostMapping("/add-book")
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);
    }


}
