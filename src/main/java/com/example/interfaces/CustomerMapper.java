package com.example.interfaces;

import com.example.models.Book;
import com.example.models.BookDTO;
import com.example.models.Customer;
import com.example.models.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = BookMapper.class)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);


    @Mapping(source = "customer.books", target = "books", qualifiedByName = "getBooks")
    CustomerDTO customerToCustomerDTO(Customer customer);

    @Named("getBooks")
    default List<BookDTO> getBooks(List<Book> books) {
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .toList();
    }
}
