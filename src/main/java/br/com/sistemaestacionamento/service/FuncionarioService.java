package br.com.sistemaestacionamento.service;

import br.com.sistemaestacionamento.model.entity.Funcionario;

public interface FuncionarioService {

	Funcionario salvarFuncionario(String email, String senha);
	
	void validarEmail(String email);
	
	
}
