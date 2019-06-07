package com.projeto.primagio.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.projeto.primagio.api.model.Curriculo;
import com.projeto.primagio.api.repository.CurriculoRepository;

@Service
public class CurriculoService {
	
	@Autowired
	private CurriculoRepository curriculoRepository;
	
	
	public Curriculo buscarCurriculoPeloCodigo(Long codigo) {
		Curriculo curriculoSalvo = curriculoRepository.findOne(codigo);
		if(curriculoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return curriculoSalvo;
	}
	
}
