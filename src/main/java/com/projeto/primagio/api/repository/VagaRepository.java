package com.projeto.primagio.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.primagio.api.model.Vaga;
import com.projeto.primagio.api.repository.vaga.VagaRepositoryQuery;

public interface VagaRepository extends JpaRepository<Vaga, Long>, VagaRepositoryQuery{
}
