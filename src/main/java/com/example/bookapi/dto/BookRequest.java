package com.example.bookapi.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

public class BookRequest {

    @Getter
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @NotBlank(message = "Genre is required")
    private String genre;

    @Max(value = 2025,message = "Published date cannot be in the future")
    private int publishedDate;


    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public @Min(value = 1450, message = "Publication year must be greater than 1450") @Max(value = 2025, message = "Publication year must be less than or equal to 2025") int getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }
}
