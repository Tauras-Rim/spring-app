package com.example.interfaces;

import com.example.models.Book;
import com.example.models.BookDTO;

import java.util.List;

public interface IBookService {

    void deleteBook(Integer id);

    List<BookDTO> getBooks();

    void addBook(Book book);

    void updateBook(Book book);
}
