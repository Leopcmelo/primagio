package com.projeto.primagio.api.repository.filter;

import java.math.BigDecimal;

import com.projeto.primagio.api.model.Empresa;

public class VagaFilter {
	private String nivel;
	private String titulo;
	private String descricao;
	private BigDecimal valorbolsamin;
	private String beneficios;
	private String turno;
	private String curso;
	private String tipo_curso;
	private String periodominde;
	private String periodomaxate;
	private Boolean ativo;
	private Empresa empresa;
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
	public BigDecimal getValorbolsamin() {
		return valorbolsamin;
	}
	public void setValorbolsamin(BigDecimal valorbolsamin) {
		this.valorbolsamin = valorbolsamin;
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
	public String getPeriodominde() {
		return periodominde;
	}
	public void setPeriodominde(String periodominde) {
		this.periodominde = periodominde;
	}
	public String getPeriodomaxate() {
		return periodomaxate;
	}
	public void setPeriodomaxate(String periodomaxate) {
		this.periodomaxate = periodomaxate;
	}
	public Boolean getAtivo() {
		return ativo;
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
	
	
}
