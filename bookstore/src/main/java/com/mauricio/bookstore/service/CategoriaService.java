package com.mauricio.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mauricio.bookstore.domain.Categoria;
import com.mauricio.bookstore.execptions.ObjectNotFoundException;
import com.mauricio.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {

	/*
	 * Faz a injeção de dependencias 
	 */
	@Autowired
	private CategoriaRepository repository;
	/*
	 * Faz a conexão no repository para exibir os itens persistidos em banco de dados
	 */
	public Categoria findById( Long id) {
		Optional<Categoria> obj =  repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado !!! id "+id+" Tipo "+ Categoria.class.getName()));
	}
	/*
	 * Retorna todas as categorias cadastradas 
	 */
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}
}
