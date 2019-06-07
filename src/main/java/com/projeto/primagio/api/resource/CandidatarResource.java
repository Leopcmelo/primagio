package com.projeto.primagio.api.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.primagio.api.event.RecursoCriadoEvent;
import com.projeto.primagio.api.exceptionhandler.PrimagioExceptionHandler.Erro;
import com.projeto.primagio.api.model.Candidatar;
import com.projeto.primagio.api.repository.CandidatarRepository;
import com.projeto.primagio.api.repository.filter.CandidaturaFilter;
import com.projeto.primagio.api.service.CandidatarService;
import com.projeto.primagio.api.service.exception.VagaJaCandidatadaException;

@RestController
@RequestMapping("/candidatar")
public class CandidatarResource {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private CandidatarRepository candidatarRepository;
	
	@Autowired
	private CandidatarService candidatarService;
	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Candidatar> pesquisar(CandidaturaFilter candidaturaFilter){
		return candidatarRepository.filtrar(candidaturaFilter);
	}
	
	@PostMapping
	public ResponseEntity<Candidatar> criar(@Valid @RequestBody Candidatar candidatar, HttpServletResponse response) {
		Candidatar candidaturaSalva = candidatarService.salvar(candidatar);
	
		publisher.publishEvent(new RecursoCriadoEvent(this, response, candidaturaSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(candidatar);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Candidatar> atualizar(@PathVariable Long codigo, @Valid @RequestBody Candidatar candidatar){
		Candidatar candidaturaSalva = candidatarService.atualizar(codigo, candidatar);
		
		return ResponseEntity.ok(candidaturaSalva);
	}
	
	@PutMapping("/{codigo}/status")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarStatus(@PathVariable Long codigo, @Valid @RequestBody String status){
		candidatarService.atualizarStatus(codigo, status);
	}
	
	@ExceptionHandler({ com.projeto.primagio.api.service.exception.VagaInexistenteOuInativaException.class })
	public ResponseEntity<Object> handleVagaInexistenteOuInativaException(com.projeto.primagio.api.service.exception.VagaInexistenteOuInativaException ex){
		String mensagemUsuario = messageSource.getMessage("vaga.inexistente-ou-desativada", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros); 
	}
	
	@ExceptionHandler({VagaJaCandidatadaException.class})
	public ResponseEntity<Object> handleVagaJaCandidatadaException(VagaJaCandidatadaException ex){
		String mensagemUsuario = messageSource.getMessage("vaga.candidatura-existente", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros); 
	}
}
