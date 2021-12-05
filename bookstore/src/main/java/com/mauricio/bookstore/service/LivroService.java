package com.mauricio.bookstore.service;

import java.util.List;
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
	public List<Livro> findAll() {
		
		return repository.findAll();
	}
	public Livro update(Long id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		
		return repository.save(newObj);
	}
	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNomeAutor(obj.getNomeAutor());
		newObj.setTexto(obj.getTexto());
		
	}
}
