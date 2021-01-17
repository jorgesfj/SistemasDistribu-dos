package com.ufal.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufal.br.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
