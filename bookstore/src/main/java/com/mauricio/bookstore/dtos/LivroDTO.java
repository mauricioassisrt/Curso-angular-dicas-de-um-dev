package com.mauricio.bookstore.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.mauricio.bookstore.domain.Livro;

public class LivroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String titulo;

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNomeAutor();
		this.titulo = obj.getTitulo();
	}

	public LivroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
