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
	
	public PessoaDTO() {
	}
	
	public PessoaDTO(Pessoa entidade) {
		this.id = entidade.getId();
		this.nome = entidade.getNome();
		this.idade = entidade.getIdade();
	} 
	
}
