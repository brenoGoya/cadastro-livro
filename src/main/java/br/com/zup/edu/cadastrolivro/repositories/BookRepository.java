package br.com.zup.edu.cadastrolivro.repositories;

import br.com.zup.edu.cadastrolivro.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
