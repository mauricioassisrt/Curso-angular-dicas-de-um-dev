package com.mauricio.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricio.bookstore.domain.Categoria;
import com.mauricio.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		
		return obj.orElse(null);
	}
}
