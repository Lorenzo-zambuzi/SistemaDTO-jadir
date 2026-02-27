package br.edu.fatecgru.sistemadto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.sistemadto.model.entity.Aluno;
import br.edu.fatecgru.sistemadto.repository.AlunoRepository;

@RestController
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping("/listar")
	public List<Aluno> listarTodos(){
		return alunoRepository.findAll();
	}

}
