package com.projeto.camadas.controllers.exceptionhandler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projeto.camadas.services.exceptions.EntidadeNaoEncontrada;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(EntidadeNaoEncontrada.class)
	public ResponseEntity<ErroPadrao> entidadeNaoEncontrada(EntidadeNaoEncontrada e, HttpServletRequest request) {
		ErroPadrao err = new ErroPadrao();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setErro("Entidade não encontrada");
		err.setMensagem(e.getMessage());
		err.setCaminho(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);
	}
}
