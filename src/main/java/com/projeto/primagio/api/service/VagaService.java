package com.projeto.primagio.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projeto.primagio.api.model.Vaga;
import com.projeto.primagio.api.repository.VagaRepository;

@Service
public class VagaService {
	@Autowired
	private VagaRepository vagaRepository;
	
	
	public Vaga atualizar(Long codigo, Vaga vaga) {
		Vaga vagaSalva = buscarVagaPeloID(codigo);
		BeanUtils.copyProperties(vaga, vagaSalva, "codigo");
		return vagaRepository.save(vagaSalva);
	}
	
	public Vaga buscarVagaPeloID(Long codigo) {
		Vaga vagas = vagaRepository.findOne(codigo);
		if(vagas == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return vagas;
	}

	public void atualizarAtivo(Long codigo, Boolean ativo) {
		Vaga vagaSalva = buscarVagaPeloID(codigo);
		vagaSalva.setAtivo(ativo);
		vagaRepository.save(vagaSalva);
	}
}
