package com.projeto.primagio.api.model;

import javax.persistence.Embeddable;

@Embeddable
public class Contato {
	private String telefone;
	private String celular;
	private String recado;
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getRecado() {
		return recado;
	}
	public void setRecado(String recado) {
		this.recado = recado;
	}
	
	
}
