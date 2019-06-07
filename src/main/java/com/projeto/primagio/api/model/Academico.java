package com.projeto.primagio.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dados_academicos")
public class Academico {
	@Id
	private Long codigo;

	@NotNull
	private String nivel;
	
	@NotNull
	private String instituicao;
	
	@NotNull
	private String cidade_da_instituicao;
	
	@NotNull
	private String matricula;
	
	@NotNull
	private String curso;
	
	@NotNull
	private String tipo_curso;
	
	@NotNull
	private String periodo_letivo;
	
	@NotNull
	private String turno;
	
	@NotNull
	private String duracaodocurso;
	
	@NotNull
	private String previsao_termino;
	
	@NotNull
	private String disponibilidade;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "codigo_estudante")
	private Estudante estudante;
	
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
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public String getCidade_da_instituicao() {
		return cidade_da_instituicao;
	}
	public void setCidade_da_instituicao(String cidade_da_instituicao) {
		this.cidade_da_instituicao = cidade_da_instituicao;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
	public String getPeriodo_letivo() {
		return periodo_letivo;
	}
	public void setPeriodo_letivo(String periodo_letivo) {
		this.periodo_letivo = periodo_letivo;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getDuracaodocurso() {
		return duracaodocurso;
	}
	public void setDuracaodocurso(String duracaodocurso) {
		this.duracaodocurso = duracaodocurso;
	}
	public String getPrevisao_termino() {
		return previsao_termino;
	}
	public void setPrevisao_termino(String previsao_termino) {
		this.previsao_termino = previsao_termino;
	}
	public String getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade_da_instituicao == null) ? 0 : cidade_da_instituicao.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((disponibilidade == null) ? 0 : disponibilidade.hashCode());
		result = prime * result + ((duracaodocurso == null) ? 0 : duracaodocurso.hashCode());
		result = prime * result + ((estudante == null) ? 0 : estudante.hashCode());
		result = prime * result + ((instituicao == null) ? 0 : instituicao.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((periodo_letivo == null) ? 0 : periodo_letivo.hashCode());
		result = prime * result + ((previsao_termino == null) ? 0 : previsao_termino.hashCode());
		result = prime * result + ((tipo_curso == null) ? 0 : tipo_curso.hashCode());
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
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
		Academico other = (Academico) obj;
		if (cidade_da_instituicao == null) {
			if (other.cidade_da_instituicao != null)
				return false;
		} else if (!cidade_da_instituicao.equals(other.cidade_da_instituicao))
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
		if (disponibilidade == null) {
			if (other.disponibilidade != null)
				return false;
		} else if (!disponibilidade.equals(other.disponibilidade))
			return false;
		if (duracaodocurso == null) {
			if (other.duracaodocurso != null)
				return false;
		} else if (!duracaodocurso.equals(other.duracaodocurso))
			return false;
		if (estudante == null) {
			if (other.estudante != null)
				return false;
		} else if (!estudante.equals(other.estudante))
			return false;
		if (instituicao == null) {
			if (other.instituicao != null)
				return false;
		} else if (!instituicao.equals(other.instituicao))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		if (periodo_letivo == null) {
			if (other.periodo_letivo != null)
				return false;
		} else if (!periodo_letivo.equals(other.periodo_letivo))
			return false;
		if (previsao_termino == null) {
			if (other.previsao_termino != null)
				return false;
		} else if (!previsao_termino.equals(other.previsao_termino))
			return false;
		if (tipo_curso == null) {
			if (other.tipo_curso != null)
				return false;
		} else if (!tipo_curso.equals(other.tipo_curso))
			return false;
		if (turno == null) {
			if (other.turno != null)
				return false;
		} else if (!turno.equals(other.turno))
			return false;
		return true;
	}
	
	
}
