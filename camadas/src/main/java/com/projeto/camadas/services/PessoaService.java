package com.projeto.camadas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.camadas.dto.PessoaDTO;
import com.projeto.camadas.entities.Pessoa;
import com.projeto.camadas.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional(readOnly = true)
	public List<PessoaDTO> listarTodos() {
		List<Pessoa> findAll = pessoaRepository.findAll();
        return findAll.stream().map(p -> new PessoaDTO(p)).collect(Collectors.toList());		
	}
}
