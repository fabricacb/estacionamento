package br.com.sistemaestacionamento.service;

import br.com.sistemaestacionamento.model.entity.Funcionario;

public interface FuncionarioService {

	Funcionario salvarFuncionario(Funcionario funcionario);
	
	void validarEmail(String email);
	
	Funcionario autenticar(String email, String senha);
	
}
