package com.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Book {

    @Id
    @SequenceGenerator(name = "book_id_sequence", sequenceName = "book_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_sequence")
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private Integer pageCount;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Customer customer;

    public Book() {
    }

    public Book(String title, String author, Integer pageCount, Customer customer) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
