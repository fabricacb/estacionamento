package br.com.sistemaestacionamento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemaestacionamento.exception.RegraNegocioException;
import br.com.sistemaestacionamento.model.entity.Funcionario;
import br.com.sistemaestacionamento.model.repository.FuncionarioRepository;
import br.com.sistemaestacionamento.service.FuncionarioService;

@Service
public class FuncionarioServiceimpl implements FuncionarioService{

	private FuncionarioRepository repository;
	
	@Autowired
	public FuncionarioServiceimpl(FuncionarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Funcionario salvarFuncionario(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já foi cadastrado um usuário utilizando este email");
		}
	}

}
