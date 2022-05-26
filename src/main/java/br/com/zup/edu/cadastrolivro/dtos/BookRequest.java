package br.com.zup.edu.cadastrolivro.dtos;

import br.com.zup.edu.cadastrolivro.entities.Book;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class BookRequest {

    @NotBlank @Size(max = 200)
    private String title;

    @NotBlank @Size(max = 4000)
    private String description;

    @NotNull @Past
    private Date publicationDate;

    @ISBN
    private String isbn;

    @Deprecated
    public BookRequest() {
    }

    public BookRequest(String title, String description, Date publicationDate, String isbn) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book toModel() {
        return new Book(title, description, publicationDate, isbn);
    }
}
