package net.homelib.springboot.service;

import net.homelib.springboot.UI.model.dto.BookDto;

import java.util.Collection;
import java.util.UUID;

public interface BookService {
    Collection<BookDto> getAllBooks();

    BookDto getBookDtoByUUID(UUID uuid);

    BookDto saveBook(BookDto bookDto);

    BookDto updateBook(BookDto bookDto);

    void deleteBookById(UUID uuid);


}
