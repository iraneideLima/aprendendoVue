package com.pessoa.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pessoa.agenda.model.Pessoa;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
