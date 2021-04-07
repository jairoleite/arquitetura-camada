package com.projeto.camadas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public ResponseEntity<PessoaDTO> inserirPessoa(@RequestBody PessoaDTO pessoaDTO) {
		PessoaDTO dto = pessoaService.inserePessoa(pessoaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PessoaDTO> alterarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
		PessoaDTO dto = pessoaService.alteraPessoa(id, pessoaDTO);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
		pessoaService.deletaPessoa(id);
		return ResponseEntity.noContent().build();
	}
	
}
