package com.projeto.primagio.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projeto.primagio.api.model.Academico;
import com.projeto.primagio.api.repository.AcademicoRepository;

@Service
public class AcademicoService {
	@Autowired
	private AcademicoRepository academicoRepository;
	
	public Academico atualizar(Long codigo, Academico academico) {
		Academico academicoSalvo = buscarAcademicoPeloID(codigo);
		BeanUtils.copyProperties(academico, academicoSalvo, "codigo");
		return academicoRepository.save(academicoSalvo);
	}
	
	public Academico buscarAcademicoPeloID(Long codigo) {
		Academico academicos = academicoRepository.findOne(codigo);
		if(academicos == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return academicos;
	}
}
