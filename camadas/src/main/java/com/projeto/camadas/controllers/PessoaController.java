package com.projeto.camadas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.camadas.dto.PessoaDTO;
import com.projeto.camadas.services.PessoaService;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService; 

	@GetMapping
	public List<PessoaDTO> listarTodos() {
		return pessoaService.listarTodos();
	}
}
