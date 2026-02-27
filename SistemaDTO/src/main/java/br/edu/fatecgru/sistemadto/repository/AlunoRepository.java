package br.edu.fatecgru.sistemadto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecgru.sistemadto.model.entity.Aluno;

// essa classe é um repositório, tudo está aqui dentro
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
	
	

}
