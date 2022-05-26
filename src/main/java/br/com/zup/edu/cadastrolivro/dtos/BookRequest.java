package br.com.zup.edu.cadastrolivro.dtos;

import br.com.zup.edu.cadastrolivro.entities.Book;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import static org.hibernate.validator.constraints.ISBN.Type;

public class BookRequest {

    @NotBlank @Size(max = 200)
    private String title;

    @NotBlank @Size(max = 4000)
    private String description;

    @NotNull @Past @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publicationDate;

    @ISBN(type = Type.ANY)
    private String isbn;

    @Deprecated
    public BookRequest() {
    }

    public BookRequest(String title, String description, LocalDate publicationDate, String isbn) {
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

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book toModel() {
        return new Book(title, description, publicationDate, isbn);
    }
}
