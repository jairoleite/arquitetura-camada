package com.projeto.camadas.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

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

	@Transactional
	public PessoaDTO inserePessoa(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setIdade(pessoaDTO.getIdade());
		pessoa = pessoaRepository.save(pessoa);
		return new PessoaDTO(pessoa);
	}

	@Transactional
	public PessoaDTO alteraPessoa(Long id, PessoaDTO pessoaDTO) {
		try {
			Pessoa entidade = pessoaRepository.getOne(id);
			entidade.setNome(pessoaDTO.getNome());
			entidade.setIdade(pessoaDTO.getIdade());
			entidade = pessoaRepository.save(entidade);
			return new PessoaDTO(entidade);
		} catch (EntityNotFoundException e) {
		   throw new EntidadeNaoEncontrada("Pessoa do id("+id+") não foi encontrada");	
		}
	}

	public void deletaPessoa(Long id) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
