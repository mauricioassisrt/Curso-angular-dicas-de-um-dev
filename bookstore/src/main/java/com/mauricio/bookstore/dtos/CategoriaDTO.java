package com.mauricio.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.mauricio.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	@NotEmpty(message = "Campo nome é requerido")
	@Length(min=3, max=100, message = "O Campo tem um tamanho minimo exigido ")
	private String nome;
	@NotEmpty(message = "Campo descricao é requerido")
	@Length(min=3, max=100, message = "O Campo tem um tamanho minimo exigido ")
	private String descricao;

	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaDTO(Categoria obje) {
		super();
		this.id = obje.getId();
		this.nome = obje.getNome();
		this.descricao = obje.getDescricao();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
