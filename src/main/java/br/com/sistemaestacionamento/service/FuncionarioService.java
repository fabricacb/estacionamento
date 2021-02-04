package br.com.sistemaestacionamento.service;

import java.net.URI;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sistemaestacionamento.model.Funcionario;
import br.com.sistemaestacionamento.repository.FuncionarioRepository;

@ManagedBean
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario, HttpServletResponse response) {
		Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(funcionarioSalvo.getId()).toUri();
		response.setHeader("location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(funcionarioSalvo);
	}
	
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	
	public List<Funcionario> listar(){
		return funcionarioRepository.findAll();
	}
}
