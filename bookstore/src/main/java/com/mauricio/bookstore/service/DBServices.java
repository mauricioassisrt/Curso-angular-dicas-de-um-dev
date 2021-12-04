package com.mauricio.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauricio.bookstore.domain.Categoria;
import com.mauricio.bookstore.domain.Livro;
import com.mauricio.bookstore.repository.CategoriaRepository;
import com.mauricio.bookstore.repository.LivroRepository;

@Service
public class DBServices {
	@Autowired
	private CategoriaRepository reposiCat;
	@Autowired
	private LivroRepository reposLiv;

	public void instanciaBasedeDados() {

		Categoria cat = new Categoria(null, "aaaaaa", "DESCRICAO CAT");
		Livro lv = new Livro(null, "TITULO LI", "AUTOR", "TEXTO ", cat);

		cat.getLivros().addAll(Arrays.asList(lv));

		this.reposiCat.saveAll(Arrays.asList(cat));
		this.reposLiv.saveAll(Arrays.asList(lv));

	}
}
