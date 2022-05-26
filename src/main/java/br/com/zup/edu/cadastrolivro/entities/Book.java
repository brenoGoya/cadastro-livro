package br.com.zup.edu.cadastrolivro.entities;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Book {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 4000)
    private String description;

    @Column(nullable = false)
    private Date publicationDate;

    private String isbn;

    @Deprecated
    public Book() {
    }

    public Book(String title, String description, Date publicationDate, String isbn) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }
}
