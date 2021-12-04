package com.mauricio.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricio.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
