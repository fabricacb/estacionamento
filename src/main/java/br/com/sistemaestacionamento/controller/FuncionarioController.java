package br.com.sistemaestacionamento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaestacionamento.api.dto.FuncionarioDTO;
import br.com.sistemaestacionamento.exception.RegraNegocioException;
import br.com.sistemaestacionamento.model.entity.Funcionario;
import br.com.sistemaestacionamento.model.entity.Funcionario.FuncionarioBuilder;
import br.com.sistemaestacionamento.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
	
	private FuncionarioService service;
	
	public FuncionarioController(FuncionarioService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity salvarFuncionario(@RequestBody FuncionarioDTO dto) {
		
		Funcionario funcionario = Funcionario.builder()
				.nome(dto.getNome())
				.email(dto.getEmail())
				.senha(dto.getSenha())
				.build();
		
		try {
			Funcionario funcionarioSalvo = service.salvarFuncionario(funcionario);
			return new ResponseEntity(funcionarioSalvo, HttpStatus.ACCEPTED);	
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
				
	}
	
}
