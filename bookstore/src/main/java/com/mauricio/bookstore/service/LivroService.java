package com.mauricio.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricio.bookstore.domain.Livro;
import com.mauricio.bookstore.repository.LivroRepository;
import com.mauricio.bookstore.service.excepitons.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	public Livro findById(Long id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado "+id+",Tipo "+Livro.class.getName()));
	}
}
