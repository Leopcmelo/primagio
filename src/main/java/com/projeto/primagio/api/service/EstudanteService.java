package com.projeto.primagio.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projeto.primagio.api.model.Estudante;
import com.projeto.primagio.api.repository.EstudanteRepository;

@Service
public class EstudanteService {
	
	@Autowired
	private EstudanteRepository estudanteRepository;
	
	public Estudante atualizar(Long codigo, Estudante estudante) {
		Estudante estudanteSalvo = buscarEstudantePeloCodigo(codigo);
		BeanUtils.copyProperties(estudante, estudanteSalvo, "codigo");
		return estudanteRepository.save(estudanteSalvo);
	
	}
	
	public Estudante buscarEstudantePeloCodigo(Long codigo) {
		Estudante estudanteSalvo = estudanteRepository.findOne(codigo);
		if(estudanteSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return estudanteSalvo;
	}

}

