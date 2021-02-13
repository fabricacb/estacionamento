package br.com.sistemaestacionamento.service;

import java.util.List;
import java.util.Optional;


import br.com.sistemaestacionamento.model.entity.Funcionario;

public interface FuncionarioService {

	Funcionario salvarFuncionario(Funcionario funcionario);
	
	void validarEmail(String email);
	
	Funcionario autenticar(String email, String senha);
	
	Funcionario atualizarFuncionario(Funcionario funcionario);
	
	void deletarFuncionario(Funcionario funcionario);
	
	Optional<Funcionario> obterPorID(Long id);
	
	List<Funcionario> buscarFuncionario();
}
