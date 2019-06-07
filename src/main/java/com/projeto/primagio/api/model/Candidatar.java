package com.projeto.primagio.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estudante_vaga")
public class Candidatar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "estudante_codigo")
	private Estudante estudante;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "vaga_codigo")
	private Vaga vaga_codigo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "empresa_codigo")
	private Vaga empresa_codigo;
	
	private String status;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public Vaga getVaga_codigo() {
		return vaga_codigo;
	}

	public void setVaga_codigo(Vaga vaga_codigo) {
		this.vaga_codigo = vaga_codigo;
	}

	public Vaga getEmpresa_codigo() {
		return empresa_codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidatar other = (Candidatar) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public void setEmpresa_codigo(Vaga empresa_codigo) {
		this.empresa_codigo = empresa_codigo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
