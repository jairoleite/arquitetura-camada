package com.projeto.camadas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.camadas.dto.PessoaDTO;
import com.projeto.camadas.services.PessoaService;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService; 

	@GetMapping
	public ResponseEntity<List<PessoaDTO>> listarTodos() {
		List<PessoaDTO> listarTodos = pessoaService.listarTodos();
		return ResponseEntity.ok().body(listarTodos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> buscarPorId(@PathVariable Long id) {
		PessoaDTO dto = pessoaService.pegaPessoaPorId(id);
		return ResponseEntity.ok().body(dto);
	}
}
