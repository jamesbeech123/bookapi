package com.example.bookapi.service;

import com.example.bookapi.dto.BookRequest;
import com.example.bookapi.dto.BookResponse;
import com.example.bookapi.dto.PaginatedResponse;
import com.example.bookapi.entity.Book;
import com.example.bookapi.exception.BookNotFoundException;
import com.example.bookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    // Get all books
    public PaginatedResponse<BookResponse> getAllBooks(Pageable pageable) {
        Page<Book> page = repo.findAll(pageable);
        List<BookResponse> content = page.getContent().stream().map(this::toResponse).toList();

        return new PaginatedResponse<>(content, page.getNumber(), page.getSize(), page.getTotalElements(), page.getTotalPages());
    }


    // Get book by ID, throwing a custom exception if not found
    public Book getBookById(Long id) {
        return repo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    // Create a new book
    @Transactional
    public BookResponse save(BookRequest request) {
        Book book = toEntity(request);
        return toResponse(repo.save(book));
    }

    @Transactional
    public BookResponse updateBook(Long id, BookRequest request) {
        Book book = repo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setGenre(request.getGenre());
        book.setPublicationYear(request.getPublishedDate());
        return toResponse(repo.save(book));
    }


    // Delete a book by ID
    public void deleteBook(Long id) {
        repo.deleteById(id);
    }

    // Search books by title or author
    public PaginatedResponse<BookResponse> searchByTitleOrAuthor(String query, Pageable pageable) {
        Page<Book> page = repo.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(query, query, pageable);
        List<BookResponse> content = page.getContent().stream().map(this::toResponse).toList();

        return new PaginatedResponse<>(content, page.getNumber(), page.getSize(), page.getTotalElements(), page.getTotalPages());
    }


    public Book toEntity(BookRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setGenre(request.getGenre());
        book.setPublicationYear(request.getPublishedDate());
        return book;
    }

    public BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getPublicationYear()
        );
    }

}
