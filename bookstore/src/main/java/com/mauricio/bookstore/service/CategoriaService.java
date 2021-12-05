package com.mauricio.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mauricio.bookstore.domain.Categoria;
import com.mauricio.bookstore.dtos.CategoriaDTO;
import com.mauricio.bookstore.repository.CategoriaRepository;
import com.mauricio.bookstore.service.excepitons.ObjectNotFoundException;

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
	public Categoria update(Long id, CategoriaDTO objDTO) {
		Categoria obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		
		return repository.save(obj);
	}
	public void delete(Long id) {
		
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.mauricio.bookstore.service.excepitons.ObjectNotFoundException("O item não pode ser deletado, possui itens associados a consulta");
		}
		
	}
} 
