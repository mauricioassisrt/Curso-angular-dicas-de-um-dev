package com.mauricio.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauricio.bookstore.domain.Livro;
import com.mauricio.bookstore.dtos.CategoriaDTO;
import com.mauricio.bookstore.dtos.LivroDTO;
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
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(){
		List<Livro> list = service.findAll();
		
		List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	

}
