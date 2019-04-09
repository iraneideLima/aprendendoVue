package com.pessoa.agenda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pessoa.agenda.model.Pessoa;
import com.pessoa.agenda.repository.PessoaRepository;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	PessoaRepository repository;

	@GetMapping("/All")
	private List<Pessoa> lista() {
		return repository.findAll();
	}

	@PostMapping("/adicionar")
	public Pessoa postPessoa(@RequestBody Pessoa pessoa){
		Pessoa _pessoa = repository.save(pessoa);
		return _pessoa;
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> deletePessoa(@PathVariable("id") long id) {
		repository.deleteById(id);
		return new ResponseEntity<>("Contato deletado", HttpStatus.OK);
	}

	//Alterar Pessoa
	@PutMapping("/editar/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable("id") long id, @RequestBody Pessoa pessoa) {
		Optional<Pessoa> pessoaDados = repository.findById(id);

		if (pessoaDados.isPresent()) {
			Pessoa p = pessoaDados.get();
			p.setNome(pessoa.getNome());
			p.settelefone(pessoa.gettelefone());
			p.setEmail(pessoa.getEmail());
			return new ResponseEntity<>(repository.save(p), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
