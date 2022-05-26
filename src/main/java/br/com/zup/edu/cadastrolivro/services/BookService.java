package br.com.zup.edu.cadastrolivro.services;

import br.com.zup.edu.cadastrolivro.dtos.BookRequest;
import br.com.zup.edu.cadastrolivro.entities.Book;
import br.com.zup.edu.cadastrolivro.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> addBook(BookRequest request, UriComponentsBuilder uri) {

        Book book = request.toModel();
        repository.save(book);

        URI uriLocation = uri.path("/books/{id}").buildAndExpand(book.getId()).toUri();

        return ResponseEntity.created(uriLocation).build();
    }
}
