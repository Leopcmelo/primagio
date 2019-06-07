package com.projeto.primagio.api.repository.candidatar;

import java.util.List;

import com.projeto.primagio.api.model.Candidatar;
import com.projeto.primagio.api.repository.filter.CandidaturaFilter;

public interface CandidatarRepositoryQuery {
	
	public List<Candidatar> filtrar(CandidaturaFilter candidaturaFilter);
}
