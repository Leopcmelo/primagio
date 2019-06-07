package com.projeto.primagio.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.projeto.primagio.api.model.Academico;
import com.projeto.primagio.api.repository.AcademicoRepository;
import com.projeto.primagio.api.service.AcademicoService;

@RestController
@RequestMapping("/academico")
public class AcademicoResource {
	@Autowired
	private AcademicoRepository academicoRepository;
	
	@Autowired
	private AcademicoService academicoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public ResponseEntity<?> Listar(){
		List<Academico> academicos = academicoRepository.findAll();
		return !academicos.isEmpty() ? ResponseEntity.ok(academicos) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?>buscarPeloId(@PathVariable Long codigo){
		Academico academicos = academicoService.buscarAcademicoPeloID(codigo);
		return ResponseEntity.ok(academicos);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarAcademico(@PathVariable Long codigo){
		academicoRepository.delete(codigo);
	}
	
	@PostMapping
	public ResponseEntity<Academico> criar(@Valid @RequestBody Academico academico, HttpServletResponse response) {
		Academico academicoSalvo = academicoRepository.save(academico);
	
		publisher.publishEvent(new RecursoCriadoEvent(this, response, academicoSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(academico);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Academico> atualizar(@PathVariable Long codigo, @Valid @RequestBody Academico academico){
		Academico academicoSalvo = academicoService.atualizar(codigo, academico);
		
		return ResponseEntity.ok(academicoSalvo);
	}
	
}
