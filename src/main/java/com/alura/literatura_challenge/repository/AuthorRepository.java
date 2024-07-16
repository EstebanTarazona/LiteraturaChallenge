package com.alura.literatura_challenge.repository;

import com.alura.literatura_challenge.entities.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Authors, Long> {
    Optional<Authors> findByName(String name);
}
