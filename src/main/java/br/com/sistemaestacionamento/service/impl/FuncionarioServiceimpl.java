package br.com.sistemaestacionamento.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.sistemaestacionamento.exception.ErroAutenticacao;
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
	@Transactional
	public Funcionario salvarFuncionario(Funcionario func) {
		validarEmail(func.getEmail());
		return repository.save(func);
	}
	
	@Override
	@Transactional
	public void deletarFuncionario(Funcionario func) {
		repository.delete(func);
	}
	
	@Override
	@Transactional
	public Funcionario atualizarFuncionario(Funcionario func) {
		Objects.requireNonNull(func.getId());
		return repository.save(func);
	}
	
	@Override
	public Funcionario autenticar(String email, String senha) {
		Optional<Funcionario> funcionario = repository.findByEmail(email);
		
		if(!funcionario.isPresent()) {
			throw new ErroAutenticacao("Usuario não encontrado para o e-mail informado!");
		}
		
		if(!funcionario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha inválida!");
		}
		
		return null;
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já foi cadastrado um usuário utilizando este email");
		}
	}
	
	@Override
	public Optional<Funcionario> obterPorID(Long id){
		return repository.findById(id);
	}
	
	@Override
	public List<Funcionario> buscarFuncionario(){
		return repository.findAll();
	}



}
