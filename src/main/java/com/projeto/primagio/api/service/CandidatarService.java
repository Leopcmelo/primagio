package com.projeto.primagio.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projeto.primagio.api.model.Candidatar;
import com.projeto.primagio.api.model.Vaga;
import com.projeto.primagio.api.repository.CandidatarRepository;
import com.projeto.primagio.api.repository.VagaRepository;
import com.projeto.primagio.api.service.exception.VagaInexistenteOuInativaException;
//import com.projeto.primagio.api.service.exception.VagaJaCandidatadaException;

@Service
public class CandidatarService {
	@Autowired
	private CandidatarRepository candidatarRepository;
	
	@Autowired
	private VagaRepository vagaRepository;
	
	public Candidatar salvar(Candidatar candidatar) {
		Vaga vaga = vagaRepository.findOne(candidatar.getVaga_codigo().getCodigo());
		//Candidatar candidatos = candidatarRepository.findOne(candidatar.getEstudante().getCodigo());
		if(vaga == null || vaga.isInativo()) {
			throw new VagaInexistenteOuInativaException();
		}
		
		//if(candidatos != null) {
		//	throw new VagaJaCandidatadaException();
		//}
		
		return candidatarRepository.save(candidatar);
	}
	
	public Candidatar buscarCandidaturaPeloID(Long codigo) {
		Candidatar candidatos = candidatarRepository.findOne(codigo);
		if(candidatos == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return candidatos;
	}

	public Candidatar atualizar(Long codigo, Candidatar candidatar) {
		Candidatar candidaturaSalva = buscarCandidaturaPeloID(codigo);
		BeanUtils.copyProperties(candidatar, candidaturaSalva, "codigo");
		return candidatarRepository.save(candidaturaSalva);
	}

	public void atualizarStatus(Long codigo, String status) {
		Candidatar candidaturaSalva = buscarCandidaturaPeloID(codigo);
		candidaturaSalva.setStatus(status);
		candidatarRepository.save(candidaturaSalva);
		
	}
		
}
