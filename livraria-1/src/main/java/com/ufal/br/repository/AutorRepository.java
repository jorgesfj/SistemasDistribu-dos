package com.ufal.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufal.br.model.Autor;
import com.ufal.br.model.Livro;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	Autor findByNome(String nome);

}
