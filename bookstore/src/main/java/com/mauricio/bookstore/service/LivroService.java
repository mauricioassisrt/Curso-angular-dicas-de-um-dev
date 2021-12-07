package com.mauricio.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricio.bookstore.domain.Categoria;
import com.mauricio.bookstore.domain.Livro;
import com.mauricio.bookstore.repository.LivroRepository;
import com.mauricio.bookstore.service.excepitons.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	@Autowired
	private CategoriaService categoriaService;
	public List<Livro> findAllLivros() {
		return repository.findAll();
	}
	public Livro findById(Long id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado " + id + ",Tipo " + Livro.class.getName()));
	}

	public List<Livro> findAll(Long id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
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

	public Livro create(Long id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);

		obj.setCategoria(cat);

		return repository.save(obj);
	}

	public void delete(Long id) {
		Livro obj = findById(id);

		repository.delete(obj);
	}
}
