package com.mauricio.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauricio.bookstore.domain.Livro;
import com.mauricio.bookstore.service.LivroService;

@RestController
@RequestMapping(value="/v1/livros")
public class LivroResource {
	
	@Autowired 
	private LivroService service;
	@GetMapping(value= "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id){
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
