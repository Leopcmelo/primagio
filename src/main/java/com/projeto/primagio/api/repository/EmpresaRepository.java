package com.projeto.primagio.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.primagio.api.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
