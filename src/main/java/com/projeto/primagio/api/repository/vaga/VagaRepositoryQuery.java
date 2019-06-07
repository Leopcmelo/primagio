package com.projeto.primagio.api.repository.vaga;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projeto.primagio.api.model.Vaga;
import com.projeto.primagio.api.repository.filter.VagaFilter;

public interface VagaRepositoryQuery {

	public Page<Vaga> filtrar(VagaFilter vagaFilter, Pageable pageable);
	
}
