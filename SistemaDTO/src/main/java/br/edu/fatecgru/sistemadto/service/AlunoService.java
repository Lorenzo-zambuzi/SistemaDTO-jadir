package br.edu.fatecgru.sistemadto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecgru.sistemadto.model.entity.Aluno;
import br.edu.fatecgru.sistemadto.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	// Consultar Todos
	public List<Aluno> listarTodos(){
	return alunoRepository.findAll();
	}
	
	// Consultar por ra
	public Aluno buscarPorId(int id) {
		return alunoRepository.findById(id).get();
	}
	
	// Consultar por nome
	public Aluno getByNome(String nome) {
		return alunoRepository.findByNome(nome);
	}
	
	// Consultar por nome Começa por
	public List<Aluno> getByPrimeiroNome(String nome) {
		return alunoRepository.findByNomeStartsWith(nome);
	}
	
	// Consultar por nome Contém
	public List<Aluno> getByContemNome(String nome) {
		return alunoRepository.findByNomeContains(nome);
	}
	
	// Consultar por nome Termina por
	public List<Aluno> getByUltimoNome(String nome) {
		return alunoRepository.findByNomeEndsWith(nome);
	}
	
	
	// Deletar aluno
	public void deleteAluno(int ra) {
		alunoRepository.deleteById(ra);
	}

}
