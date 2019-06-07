package com.projeto.primagio.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projeto.primagio.api.model.Empresa;
import com.projeto.primagio.api.repository.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa atualizar(Long codigo, Empresa empresa) {
		Empresa empresaSalva = buscarEmpresaPeloCodigo(codigo);
		BeanUtils.copyProperties(empresa, empresaSalva, "codigo");
		return empresaRepository.save(empresaSalva);
	
	}
	
	public Empresa buscarEmpresaPeloCodigo(Long codigo) {
		Empresa empresaSalva = empresaRepository.findOne(codigo);
		if(empresaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return empresaSalva;
	}
}
