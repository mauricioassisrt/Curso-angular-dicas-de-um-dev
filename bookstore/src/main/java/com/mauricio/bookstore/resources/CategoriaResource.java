package com.mauricio.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mauricio.bookstore.domain.Categoria;
import com.mauricio.bookstore.dtos.CategoriaDTO;
import com.mauricio.bookstore.execptions.ObjectNotFoundException;
import com.mauricio.bookstore.repository.CategoriaRepository;
import com.mauricio.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/v1/categorias")
public class CategoriaResource {

	/*
	 * @Autowired é destinado para realizar a injeção de dependencias
	 */
	@Autowired
	private CategoriaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		// passa o ID para o service para realizar a busca do ID
		Categoria obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		// busca no service todos os resultados
		List<Categoria> list = service.findAll();
		/*
		 * A função do DTO é obter uma lista e adicionar só os atributos desejado, neste
		 * caso vamos eliminar a lista de livros para não sobrecarregar o cliente
		 */
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria obj) {
		obj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();

	}
}
