package com.alura.literatura_challenge.repository;

import com.alura.literatura_challenge.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
    Optional<Books> findByTitle(String title);
    List<Books> findByLanguage(String language);
}
