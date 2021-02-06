package br.com.sistemaestacionamento.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.sistemaestacionamento.model.Funcionario;
import br.com.sistemaestacionamento.repository.FuncionarioRepository;
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
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> index(){
		return ResponseEntity.ok(funcionarioService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> show(@PathVariable Long id){
		return ResponseEntity.ok(funcionarioService.buscar(id));
	}
}
