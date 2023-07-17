package com.example.services;

import com.example.repositories.BookRepository;
import com.example.interfaces.BookMapper;
import com.example.interfaces.IBookService;
import com.example.models.Book;
import com.example.models.BookDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public void deleteBook(Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Book with id " + id + " not found");
        }
    }

    public List<BookDTO> getBooks() {
        List<Book> books = bookRepository.findAll();
        return  books.stream()
                .map(bookMapper::toDTO)
                .toList();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        if (bookRepository.existsById(book.getId())) {
            book.setId(book.getId());
            bookRepository.save(book);
        } else {
            throw new EntityNotFoundException("Book with id " + book.getId() + " not found");
        }
    }
}
