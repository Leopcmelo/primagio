package com.projeto.primagio.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.primagio.api.model.Candidatar;
import com.projeto.primagio.api.repository.candidatar.CandidatarRepositoryQuery;

public interface CandidatarRepository extends JpaRepository<Candidatar, Long>, CandidatarRepositoryQuery{
	
}
