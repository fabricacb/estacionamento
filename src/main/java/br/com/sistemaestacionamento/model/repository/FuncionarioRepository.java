package br.com.sistemaestacionamento.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistemaestacionamento.model.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	boolean existsByEmail(String email);
	
	Optional<Funcionario> findByEmail(String email);
}
