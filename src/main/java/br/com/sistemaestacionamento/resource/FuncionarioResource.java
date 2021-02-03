package br.com.sistemaestacionamento.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.sistemaestacionamento.model.Funcionario;
import br.com.sistemaestacionamento.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping
	public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario, HttpServletResponse response) {
		return funcionarioService.criar(funcionario, response);
	}
}
