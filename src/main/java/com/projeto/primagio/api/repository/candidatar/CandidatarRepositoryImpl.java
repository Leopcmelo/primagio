package com.projeto.primagio.api.repository.candidatar;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.projeto.primagio.api.model.Candidatar;
import com.projeto.primagio.api.model.Candidatar_;
import com.projeto.primagio.api.repository.filter.CandidaturaFilter;

public class CandidatarRepositoryImpl implements CandidatarRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Candidatar> filtrar(CandidaturaFilter candidaturaFilter){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Candidatar> criteria = builder.createQuery(Candidatar.class);
		Root<Candidatar> root = criteria.from(Candidatar.class);
		
		//criar os filtroes/restricoes das vagas 
		Predicate[] predicates = criarRestricoes(candidaturaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Candidatar> query = manager.createQuery(criteria); 
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(CandidaturaFilter candidaturaFilter, CriteriaBuilder builder,
			Root<Candidatar> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(candidaturaFilter.getEstudante() != null) {
			predicates.add(builder.equal(root.get(Candidatar_.estudante), candidaturaFilter.getEstudante()));
		}
		
		if(candidaturaFilter.getVaga() != null) {
			predicates.add(builder.equal(root.get(Candidatar_.vaga_codigo), candidaturaFilter.getVaga()));
		}
		
		if(candidaturaFilter.getEmpresa() != null) {
			predicates.add(builder.equal(root.get(Candidatar_.empresa_codigo), candidaturaFilter.getEmpresa()));
		}
		 
		if(candidaturaFilter.getStatus() != null) {
			predicates.add(builder.notEqual(root.get(Candidatar_.status), candidaturaFilter.getStatus()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
}
