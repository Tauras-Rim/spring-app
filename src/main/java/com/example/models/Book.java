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
    private int pageCount;

    @ManyToOne
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
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

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
