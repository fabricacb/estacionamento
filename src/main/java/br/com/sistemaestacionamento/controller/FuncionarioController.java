package br.com.sistemaestacionamento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaestacionamento.api.dto.FuncionarioDTO;
import br.com.sistemaestacionamento.model.entity.Funcionario;
import br.com.sistemaestacionamento.service.FuncionarioService;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
	
	private FuncionarioService service;
	
	public FuncionarioController(FuncionarioService service) {
		this.service = service;
	}

	public ResponseEntity salvarFuncionario(@RequestBody FuncionarioDTO dto) {
		
		Funcionario funcionario = Funcionario.builder()
				.nome(dto.getNome())
				.email(dto.getEmail())
				.senha(dto.getSenha());
				
	}
	
}
