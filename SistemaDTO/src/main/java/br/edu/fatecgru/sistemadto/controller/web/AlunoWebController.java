package br.edu.fatecgru.sistemadto.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.fatecgru.sistemadto.model.entity.Aluno;
import br.edu.fatecgru.sistemadto.service.AlunoService;

@Controller
@RequestMapping("/alunos")
public class AlunoWebController {
	
	@Autowired
	private AlunoService alunoService;
	  
	@GetMapping("/list")
	public String listarTodos(Model model) {
		List<Aluno> alunos = alunoService.listarTodos();
		model.addAttribute("alunos", alunos);
		return "lista";
	}
	
	@GetMapping("/new")
	public String newAluno(Model model) {
		model
			.addAttribute("aluno", new Aluno())
			.addAttribute("novo", true);
		return "form";
	}
}
