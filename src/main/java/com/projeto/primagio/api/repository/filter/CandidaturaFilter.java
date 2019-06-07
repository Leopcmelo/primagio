package com.projeto.primagio.api.repository.filter;

import javax.persistence.JoinColumn;

import com.projeto.primagio.api.model.Estudante;
import com.projeto.primagio.api.model.Vaga;

public class CandidaturaFilter {
	@JoinColumn(name = "estudante_codigo")
	private Estudante estudante; 
	
	private Vaga vaga;
	
	@JoinColumn(name="empresa_codigo")
	private Vaga empresa;
	
	private String status;

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Vaga getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Vaga empresa) {
		this.empresa = empresa;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
