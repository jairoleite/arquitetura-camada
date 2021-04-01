package com.projeto.camadas.dto;

import com.projeto.camadas.entities.Pessoa;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaDTO {

	private Long id;
	private String nome;
	private Integer idade;
	
	public PessoaDTO(Pessoa entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.idade = entity.getIdade();
	} 
	
}
