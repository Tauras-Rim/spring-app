package com.example.interfaces;

import com.example.models.Book;

import java.util.List;

public interface IBookService {

    void deleteBook(Integer id);

    List<Book> getBooks();

    void addBook(Book book);

    void updateBook(Integer id, Book book);
}
