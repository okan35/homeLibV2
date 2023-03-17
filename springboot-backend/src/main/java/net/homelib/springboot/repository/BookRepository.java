package net.homelib.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.homelib.springboot.model.Book;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Optional<Book> findBookByUuid(UUID uuid);

    Optional<Book> deleteBookByUuid(UUID uuid);

}
