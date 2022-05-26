package br.com.zup.edu.cadastrolivro.controllers;

import br.com.zup.edu.cadastrolivro.dtos.BookRequest;
import br.com.zup.edu.cadastrolivro.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {


    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> bookRegistration(@RequestBody @Valid BookRequest request, UriComponentsBuilder uri) {
        return service.addBook(request, uri);
    }
}
