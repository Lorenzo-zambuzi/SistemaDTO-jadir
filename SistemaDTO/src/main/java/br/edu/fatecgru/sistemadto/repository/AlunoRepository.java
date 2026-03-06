package br.edu.fatecgru.sistemadto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecgru.sistemadto.model.entity.Aluno;

// essa classe é um repositório, tudo está aqui dentro
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
	
	// ele segue um padrão, por isso, é só colocar com o padrão do findById, mas trocando pelo campo desejado
	// ele faz, por padrão, pesquisa de todos, ou por id, então usamos o padrão do id para procurar o nome, se trocarmos a escrita, não funciona
	
	public Aluno findByNome(String nome);
	
	public List<Aluno> findByNomeStartsWith(String nome);
	public List<Aluno> findByNomeContains(String nome);
	public List<Aluno> findByNomeEndsWith(String nome);

}
