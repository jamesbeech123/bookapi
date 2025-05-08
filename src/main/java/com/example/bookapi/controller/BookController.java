package com.example.bookapi.controller;

import com.example.bookapi.dto.BookRequest;
import com.example.bookapi.dto.BookResponse;
import com.example.bookapi.dto.PaginatedResponse;
import com.example.bookapi.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @Operation(summary = "Get all books")
    @GetMapping
    public PaginatedResponse<BookResponse> getAllBooks(@PageableDefault(size = 10) Pageable pageable) {
        return service.getAllBooks(pageable);
    }

    @Operation(summary = "Get book by ID")
    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable Long id) {
        return service.toResponse(service.getBookById(id));
    }

    @Operation(summary = "Create a new book")
    @PostMapping
    public ResponseEntity<BookResponse> create(@Valid @RequestBody BookRequest bookRequest) {
        BookResponse saved = service.save(bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @Operation(summary = "Update an existing book")
    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id, @Valid @RequestBody BookRequest bookRequest) {
        return service.updateBook(id, bookRequest);
    }

    @Operation(summary = "Delete a book by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Search for books by title or author")
    @GetMapping("/search")
    public PaginatedResponse<BookResponse> search(@RequestParam String query, @PageableDefault(size = 10) Pageable pageable) {
        return service.searchByTitleOrAuthor(query, pageable);
    }
}
