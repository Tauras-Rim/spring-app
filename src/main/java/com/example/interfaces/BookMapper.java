package com.example.interfaces;

import com.example.models.Book;
import com.example.models.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "customer.id", target = "customerId")
    BookDTO bookToBookDTO(Book book);
}
