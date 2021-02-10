package br.com.sistemaestacionamento.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistemaestacionamento.model.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	boolean existsByEmail(String email);
}
