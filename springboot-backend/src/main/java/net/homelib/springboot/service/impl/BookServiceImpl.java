package net.homelib.springboot.service.impl;

import net.homelib.springboot.UI.model.dto.BookDto;
import net.homelib.springboot.model.Book;
import net.homelib.springboot.repository.BookRepository;
import net.homelib.springboot.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Collection<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(book -> this.modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBookDtoByUUID(UUID uuid) {
        return modelMapper.map(bookRepository.findBookByUuid(uuid),BookDto.class) ;
    }

    @Override
    public BookDto saveBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto,Book.class);
        book.setUuid(UUID.randomUUID());
        return modelMapper.map(bookRepository.save(book),BookDto.class);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto,Book.class);
        return modelMapper.map(bookRepository.save(book),BookDto.class);
    }

    @Override
    public void deleteBookById(UUID uuid) {
        bookRepository.deleteBookByUuid(uuid);
    }
}
