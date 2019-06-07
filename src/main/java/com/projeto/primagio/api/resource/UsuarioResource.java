package com.projeto.primagio.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.primagio.api.event.RecursoCriadoEvent;
import com.projeto.primagio.api.model.Usuario;
import com.projeto.primagio.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		
		final String senhaEncriptada = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncriptada);
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
	
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}
	
	@GetMapping
	ResponseEntity<?> listar(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		return !usuarios.isEmpty() ? ResponseEntity.ok(usuarios) : ResponseEntity.noContent().build();
	}
	
}
