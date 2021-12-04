package com.mauricio.bookstore.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauricio.bookstore.domain.Categoria;
import com.mauricio.bookstore.execptions.ObjectNotFoundException;
import com.mauricio.bookstore.repository.CategoriaRepository;
import com.mauricio.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value ="/v1/categorias")
public class CategoriaResource {
	
	@Autowired 
	private CategoriaRepository repository;
	@GetMapping(value="/{id}")
	public Categoria findById(@PathVariable Long id) {
		Optional<Categoria> obj =  repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado !!! id "+id+" Tipo "+ Categoria.class.getName()));
	}
	
}
