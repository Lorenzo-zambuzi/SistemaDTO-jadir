package br.edu.fatecgru.sistemadto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.sistemadto.model.entity.Aluno;
import br.edu.fatecgru.sistemadto.repository.AlunoRepository;
import br.edu.fatecgru.sistemadto.service.AlunoService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	private AlunoRepository alunoRepository;
	
	// Get
	
	@GetMapping
	public List<Aluno> listarTodos(){
		return alunoService.listarTodos();
	}
	
	@GetMapping ("/{ra}")
	public Aluno buscarPorId(@PathVariable int ra){
		Aluno aluno = alunoService.buscarPorId(ra);
		return aluno;
	}
	
	@GetMapping ("/nome/{nome}")
	public Aluno buscarPorNome(@PathVariable String nome){
		Aluno aluno = alunoService.getByNome(nome);
		return aluno;
	}
	
	@GetMapping ("/primeiro-nome/{nome}")
	public List<Aluno> buscarPorPrimeiroNome(@PathVariable String nome){
		return alunoService.getByPrimeiroNome(nome);
	}
	
	@GetMapping ("/contem-nome/{nome}")
	public List<Aluno> buscarPorContemNome(@PathVariable String nome){
		return alunoService.getByContemNome(nome);
	}
	
	@GetMapping ("/ultimo-nome/{nome}")
	public List<Aluno> buscarPorUltimoNome(@PathVariable String nome){
		return alunoService.getByUltimoNome(nome);
	}
	
	
	// Delete
	@DeleteMapping("/{ra}")
	public String delete(@PathVariable int ra) {
		alunoService.deleteAluno(ra);
		return "Aluno deletado com sucesso!";
	}
	
	// criar
	@PostMapping
	public Aluno insert(@RequestBody Aluno aluno) {
		alunoService.saveAluno(aluno);
		return aluno;
	}
	
	// post para criar, put para alterar
	
	// atualizar
	@PutMapping("/{id}")
	public Aluno update(@RequestBody Aluno aluno, 
			@PathVariable Integer id) {
		Aluno alunoUpdate = alunoService.buscarPorId(id);
		alunoUpdate.setNome(aluno.getNome());
		alunoUpdate.setEmail(aluno.getEmail());
		alunoUpdate.setEndereco(aluno.getEndereco());
		alunoUpdate.setDataNascimento(aluno.getDataNascimento());
		alunoUpdate.setPeriodo(aluno.getPeriodo());
		return alunoService.saveAluno(alunoUpdate);
	}
}
