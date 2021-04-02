package com.projeto.camadas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.camadas.dto.PessoaDTO;
import com.projeto.camadas.entities.Pessoa;
import com.projeto.camadas.repositories.PessoaRepository;
import com.projeto.camadas.services.exceptions.EntidadeNaoEncontrada;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional(readOnly = true)
	public List<PessoaDTO> listarTodos() {
		List<Pessoa> buscarTodasPessoas = pessoaRepository.findAll();
        return buscarTodasPessoas.stream().map(p -> new PessoaDTO(p)).collect(Collectors.toList());		
	}

	@Transactional(readOnly = true)
	public PessoaDTO pegaPessoaPorId(Long id) {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		Pessoa pessoa = obj.orElseThrow(() -> new EntidadeNaoEncontrada("A pessoa com a identificação "+id+" não foi encontrada!"));
		return new PessoaDTO(pessoa);
	}
}
