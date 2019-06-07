package com.projeto.primagio.api.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vaga")
public class Vaga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nivel;
	private String titulo;
	private String descricao;
	private BigDecimal valor_bolsa;
	private String beneficios;
	private String turno;
	private String curso;
	private String tipo_curso;
	private String periodomin;
	private String periodomax;
	private Boolean ativo;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_empresa")
	private Empresa empresa;


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getNivel() {
		return nivel;
	}


	public void setNivel(String nivel) {
		this.nivel = nivel;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public BigDecimal getValor_bolsa() {
		return valor_bolsa;
	}


	public void setValor_bolsa(BigDecimal valor_bolsa) {
		this.valor_bolsa = valor_bolsa;
	}


	public String getBeneficios() {
		return beneficios;
	}


	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}


	public String getTurno() {
		return turno;
	}


	public void setTurno(String turno) {
		this.turno = turno;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public String getTipo_curso() {
		return tipo_curso;
	}


	public void setTipo_curso(String tipo_curso) {
		this.tipo_curso = tipo_curso;
	}


	public String getPeriodomin() {
		return periodomin;
	}


	public void setPeriodomin(String periodomin) {
		this.periodomin = periodomin;
	}


	public String getPeriodomax() {
		return periodomax;
	}


	public void setPeriodomax(String periodomax) {
		this.periodomax = periodomax;
	}


	public Boolean getAtivo() {
		return ativo;
	}
	
	@JsonIgnore
	@Transient
	public Boolean isInativo() {
		return !this.ativo;
	}


	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((beneficios == null) ? 0 : beneficios.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((periodomax == null) ? 0 : periodomax.hashCode());
		result = prime * result + ((periodomin == null) ? 0 : periodomin.hashCode());
		result = prime * result + ((tipo_curso == null) ? 0 : tipo_curso.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
		result = prime * result + ((valor_bolsa == null) ? 0 : valor_bolsa.hashCode());
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
		Vaga other = (Vaga) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (beneficios == null) {
			if (other.beneficios != null)
				return false;
		} else if (!beneficios.equals(other.beneficios))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		if (periodomax == null) {
			if (other.periodomax != null)
				return false;
		} else if (!periodomax.equals(other.periodomax))
			return false;
		if (periodomin == null) {
			if (other.periodomin != null)
				return false;
		} else if (!periodomin.equals(other.periodomin))
			return false;
		if (tipo_curso == null) {
			if (other.tipo_curso != null)
				return false;
		} else if (!tipo_curso.equals(other.tipo_curso))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (turno == null) {
			if (other.turno != null)
				return false;
		} else if (!turno.equals(other.turno))
			return false;
		if (valor_bolsa == null) {
			if (other.valor_bolsa != null)
				return false;
		} else if (!valor_bolsa.equals(other.valor_bolsa))
			return false;
		return true;
	}

}
