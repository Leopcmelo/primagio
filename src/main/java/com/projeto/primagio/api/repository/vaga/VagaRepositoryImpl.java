package com.projeto.primagio.api.repository.vaga;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.projeto.primagio.api.model.Vaga;
import com.projeto.primagio.api.model.Vaga_;
import com.projeto.primagio.api.repository.filter.VagaFilter;

public class VagaRepositoryImpl implements VagaRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Vaga> filtrar(VagaFilter vagaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Vaga> criteria = builder.createQuery(Vaga.class);
		Root<Vaga> root = criteria.from(Vaga.class);
		
		//criar os filtroes/restricoes das vagas 
		Predicate[] predicates = criarRestricoes(vagaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Vaga> query = manager.createQuery(criteria); 
		
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(vagaFilter));
	}

	private Long total(VagaFilter vagaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Vaga> root = criteria.from(Vaga.class); 
		
		Predicate[] predicates = criarRestricoes(vagaFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Vaga> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Predicate[] criarRestricoes(VagaFilter vagaFilter, CriteriaBuilder builder, Root<Vaga> root) {
			
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(vagaFilter.getDescricao())) {
			predicates.add(builder.like(builder.lower(root.get(Vaga_.descricao)), "%" + vagaFilter.getDescricao().toLowerCase() + "%"));
		}
		
		if(vagaFilter.getValorbolsamin() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(Vaga_.valor_bolsa), vagaFilter.getValorbolsamin()));
		}
		
		if(vagaFilter.getPeriodominde() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(Vaga_.periodomin), vagaFilter.getPeriodominde()));
		}
		
		if(vagaFilter.getPeriodomaxate() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get(Vaga_.periodomax), vagaFilter.getPeriodomaxate()));
		}	
		if(vagaFilter.getAtivo() != null) {
			predicates.add(builder.equal(root.get(Vaga_.ativo), vagaFilter.getAtivo()));
		}
		if(vagaFilter.getEmpresa() != null) {
			predicates.add(builder.equal(root.get(Vaga_.empresa), vagaFilter.getEmpresa()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
}
