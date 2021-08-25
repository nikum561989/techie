package com.barclays.assignment.librarymManagementSystem.service.impl;

import com.barclays.assignment.librarymManagementSystem.exception.NotFoundException;
import com.barclays.assignment.librarymManagementSystem.model.Book;
import com.barclays.assignment.librarymManagementSystem.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    public static List<Book> bookList = Arrays.asList(new Book(1L, "tyyg234", "RS Agarwal", "RS Agrawal", "Quant"),
            new Book(11L, "egjhkh123", "Disha for IAS", "Disha for IAS", "Disha for IAS prepration"),
            new Book(21L, "ooewiuroi9898", "Goel for SSB", "Goel for SSB", "SSB prepration 2022"),
            new Book(13L, "DFHSA24", "RD Sharma Maths", "RD Sharma Maths", "RD Sharma Maths for CBSE 11 & 12 standard"),
            new Book(61L, "qeqwr2345", "HC Verma Physics", "HC Verma Physics", "HC Verma Physics CBSE Physics 12th standard"));

    @Override
    public List<Book> findAllBooks() {
        return bookList;
    }

    @Override
    public List<Book> searchBooks(String keyword) throws NotFoundException{
        List<Book> result = bookList.stream().filter(n -> n.getName().contains(keyword)).collect(Collectors.toList());
        if (result.isEmpty())
            throw new NotFoundException("No such books available..!!");
        return result;
    }

    @Override
    public void createBook(Book book) {
        bookList.add(book);
    }
}
