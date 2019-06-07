package com.projeto.primagio.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.projeto.primagio.api.event.RecursoCriadoEvent;
import com.projeto.primagio.api.model.Estudante;
import com.projeto.primagio.api.repository.EstudanteRepository;
import com.projeto.primagio.api.service.EstudanteService;


@RestController
@RequestMapping("/estudantes")
public class EstudanteResource {
	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@Autowired
	private EstudanteService estudanteService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	//LISTA TODAS OS ESTUDANTES CADASTRADOS
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Estudante> estudantes = estudanteRepository.findAll();
		return !estudantes.isEmpty() ? ResponseEntity.ok(estudantes) : ResponseEntity.noContent().build();
	}
	
	//GET ESTUDANTE POR CÓDIGO
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long codigo) {
		Estudante estudanteSalvo = estudanteService.buscarEstudantePeloCodigo(codigo);
		
		return ResponseEntity.ok(estudanteSalvo);
	}
	
	//INSERIR ESTUDANTE
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_ESTUDANTE')")
	public ResponseEntity<Estudante> criar(@Valid @RequestBody Estudante estudante, HttpServletResponse response) {
		Estudante estudanteSalvo = estudanteRepository.save(estudante);
	
		publisher.publishEvent(new RecursoCriadoEvent(this, response, estudanteSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(estudante);
	}
	
	//DELETANDO ESTUDANTE PASSANDO O CÓDIGO
	@DeleteMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_ESTUDANTE')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		estudanteRepository.delete(codigo);
	}
	
	//ATUALIZANDO ESTUDANTE PELO CÓDIGO
	@PutMapping("/{codigo}")
	public ResponseEntity<Estudante> atualizar(@PathVariable Long codigo, @Valid @RequestBody Estudante estudante){
		Estudante estudanteSalvo = estudanteService.atualizar(codigo, estudante);
		
		return ResponseEntity.ok(estudanteSalvo);
	}
}
