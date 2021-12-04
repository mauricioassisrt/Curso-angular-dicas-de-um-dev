package com.mauricio.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mauricio.bookstore.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria , Long>{

}
