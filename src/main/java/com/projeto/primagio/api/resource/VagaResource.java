package com.projeto.primagio.api.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.projeto.primagio.api.model.Vaga;
import com.projeto.primagio.api.repository.VagaRepository;
import com.projeto.primagio.api.repository.filter.VagaFilter;
import com.projeto.primagio.api.service.VagaService;

@RestController
@RequestMapping("/vagas")
public class VagaResource {
	@Autowired
	private VagaRepository vagaRepository;
	
	@Autowired
	private VagaService vagaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public Page<Vaga> pesquisar(VagaFilter vagaFilter, Pageable pageable){
		return vagaRepository.filtrar(vagaFilter, pageable);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?>buscarPeloId(@PathVariable Long codigo){
		Vaga vagas = vagaService.buscarVagaPeloID(codigo);
		return ResponseEntity.ok(vagas);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarVaga(@PathVariable Long codigo){
		vagaRepository.delete(codigo);
	}
	
	@PostMapping
	public ResponseEntity<Vaga> criar(@Valid @RequestBody Vaga vaga, HttpServletResponse response) {
		Vaga vagaSalva = vagaRepository.save(vaga);
	
		publisher.publishEvent(new RecursoCriadoEvent(this, response, vagaSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vaga);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Vaga> atualizar(@PathVariable Long codigo, @Valid @RequestBody Vaga vaga){
		Vaga vagaSalva = vagaService.atualizar(codigo, vaga);
		
		return ResponseEntity.ok(vagaSalva);
	}
	
	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarAtivo(@PathVariable Long codigo, @Valid @RequestBody Boolean ativo){
		vagaService.atualizarAtivo(codigo, ativo);
		
	}
	
	
	
}
