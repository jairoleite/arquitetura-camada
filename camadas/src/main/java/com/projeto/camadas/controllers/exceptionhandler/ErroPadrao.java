package com.projeto.camadas.controllers.exceptionhandler;

import java.time.Instant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ErroPadrao {

	private Instant timestamp;
	private Integer status;
	private String erro;
	private String mensagem;
	private String caminho;
}
