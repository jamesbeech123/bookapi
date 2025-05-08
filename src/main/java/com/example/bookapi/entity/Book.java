package com.example.bookapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Book {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    @JsonIgnore
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    private String author;

    private String genre;

    @Min(value = 1450, message = "Publication year must be greater than 1450")
    @Max(value = 2025, message = "Publication year must be less than or equal to 2025")
    private int publicationYear;

    @Version
    @JsonIgnore
    private Integer version;

    // Constructors
    public Book() {}

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

}

