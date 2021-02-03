package br.com.sistemaestacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistemaestacionamento.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
