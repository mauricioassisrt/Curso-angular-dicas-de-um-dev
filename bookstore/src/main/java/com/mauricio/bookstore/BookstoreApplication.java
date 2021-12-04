package com.mauricio.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import com.mauricio.bookstore.domain.Categoria;
import com.mauricio.bookstore.domain.Livro;
import com.mauricio.bookstore.repository.CategoriaRepository;
import com.mauricio.bookstore.repository.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
@Autowired
private CategoriaRepository reposiCat;
@Autowired
private LivroRepository reposLiv;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {

	    
		
		Categoria cat = new Categoria(null,"aaaaa", "DESCRICAO CAT");
		Livro lv = new Livro(null, "TITULO LI", "AUTOR", "TEXTO ", cat) ;
		
		cat.getLivros().addAll(Arrays.asList(lv));
		
		this.reposiCat.saveAll(Arrays.asList(cat));
		this.reposLiv.saveAll(Arrays.asList(lv));
		
		
		
	}

}