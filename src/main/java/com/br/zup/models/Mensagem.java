package com.br.zup.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Mensagem implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Campo conteudo precisa ser preenchido")
	private String conteudo;
	
	public Mensagem() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}
