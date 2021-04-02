package com.projeto.camadas.services.exceptions;

/**
 * Classe de exceção para busca de entidade não encontrada 
 */
public class EntidadeNaoEncontrada extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontrada(String mensagem) {
		super(mensagem);
	}

}
