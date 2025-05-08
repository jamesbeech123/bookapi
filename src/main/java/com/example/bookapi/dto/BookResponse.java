package com.example.bookapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private String genre;
    private int publishedDate;

    public BookResponse(Long id, String title, String author, String genre,
                        @Min(value = 1450, message = "Publication year must be greater than 1450")
                        @Max(value = 2025, message = "Publication year must be less than or equal to 2025")
                        int publishedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishedDate = publishedDate;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getPublishedDate() { return publishedDate; }
}
