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
import com.projeto.primagio.api.model.Empresa;
import com.projeto.primagio.api.repository.EmpresaRepository;
import com.projeto.primagio.api.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaResource {
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	//LISTA TODAS AS EMPRESAS CADASTRADOS
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Empresa> empresas = empresaRepository.findAll();
		return !empresas.isEmpty() ? ResponseEntity.ok(empresas) : ResponseEntity.noContent().build();
	}
	
	//GET EMPRESA POR CÓDIGO
	@GetMapping("/{codigo}")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long codigo) {
		Empresa empresaSalva = empresaService.buscarEmpresaPeloCodigo(codigo);
		
		return ResponseEntity.ok(empresaSalva);
	}
	
	//INSERIR EMPRESA
	@PostMapping
	public ResponseEntity<Empresa> criar(@Valid @RequestBody Empresa empresa, HttpServletResponse response) {
		Empresa empresaSalva = empresaRepository.save(empresa);
	
		publisher.publishEvent(new RecursoCriadoEvent(this, response, empresaSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
	}
	
	//DELETANDO EMPRESA PASSANDO O CÓDIGO
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		empresaRepository.delete(codigo);
	}
	
	//ATUALIZANDO EMPRESA PELO CÓDIGO
	@PutMapping("/{codigo}")
	public ResponseEntity<Empresa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Empresa empresa){
		Empresa empresaSalva = empresaService.atualizar(codigo, empresa);
		
		return ResponseEntity.ok(empresaSalva);
	}
}
