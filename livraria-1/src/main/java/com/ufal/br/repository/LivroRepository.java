package com.ufal.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufal.br.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, String>{

	Livro findByNome(String nome);
	
}