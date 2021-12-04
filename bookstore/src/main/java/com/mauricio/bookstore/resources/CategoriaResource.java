package com.mauricio.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauricio.bookstore.domain.Categoria;
import com.mauricio.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value ="/v1/categorias")
public class CategoriaResource {
	
	@Autowired 
	private CategoriaService service;
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
