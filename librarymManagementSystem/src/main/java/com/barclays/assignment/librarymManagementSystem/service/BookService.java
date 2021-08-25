package com.barclays.assignment.librarymManagementSystem.service;

import com.barclays.assignment.librarymManagementSystem.exception.NotFoundException;
import com.barclays.assignment.librarymManagementSystem.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAllBooks();

    public List<Book> searchBooks(String keyword) throws NotFoundException;

    public void createBook(Book book);


}
