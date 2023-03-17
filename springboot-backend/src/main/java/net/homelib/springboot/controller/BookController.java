package net.homelib.springboot.controller;

import java.util.Collection;
import java.util.UUID;


import net.homelib.springboot.UI.model.dto.BookDto;
import net.homelib.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<Collection<BookDto>> getBookList() {
		return ResponseEntity.ok(bookService.getAllBooks());
	}

	@GetMapping("/books/{uuid}")
	public ResponseEntity<BookDto> getBookByUUID(@PathVariable(name = "uuid") UUID uuid) {
		return ResponseEntity.ok(bookService.getBookDtoByUUID(uuid));
	}


	@PostMapping("/books")
	public ResponseEntity<BookDto> addNewBook(@RequestBody BookDto bookDto) {
		return ResponseEntity.ok(bookService.saveBook(bookDto));
	}

	//change it to restful best practice - no verb
	@PutMapping("/books/update")
	public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) {
		return ResponseEntity.ok(bookService.updateBook(bookDto));
	}

	@DeleteMapping("/books/{uuid}")
	public ResponseEntity<Void> deleteBook(@PathVariable(name = "uuid") String uuid) {
		bookService.deleteBookById(UUID.fromString(uuid));
		return ResponseEntity.ok().build();
	}
}
