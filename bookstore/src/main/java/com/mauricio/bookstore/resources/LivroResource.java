package com.mauricio.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mauricio.bookstore.domain.Livro;
import com.mauricio.bookstore.dtos.CategoriaDTO;
import com.mauricio.bookstore.dtos.LivroDTO;
import com.mauricio.bookstore.service.LivroService;
@CrossOrigin("*")
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
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value="categoria", defaultValue="0") Long id_cat){
		List<Livro> list = service.findAll(id_cat);
		
		List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Livro> update( @PathVariable Long id,@Valid @RequestBody Livro obj){
		Livro newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PatchMapping(value="/{id}")
	public ResponseEntity<Livro> updatePath( @PathVariable Long id, @Valid @RequestBody Livro obj){
		Livro newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value="categoria", defaultValue = "0") Long id_cat, @Valid @RequestBody Livro obj){
		Livro newObj = service.create(id_cat, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
