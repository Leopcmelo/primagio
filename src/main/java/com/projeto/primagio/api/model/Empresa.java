package com.projeto.primagio.api.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {
	@Id
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	private Long 	codigo;
	private String 	razao_social;
	private String	nome_fantasia;
	private String 	cnpj;
	private String	email;
	private String	nome_responsavel;
	private String	email_responsavel;
	
	@OneToOne
	@JoinColumn(name = "usuario_codigo", referencedColumnName = "codigo")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Embedded
	private Endereco endereco;
	
	@Embedded
	private Contato contato;
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getRazao_social() {
		return razao_social;
	}
	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
	public String getNome_fantasia() {
		return nome_fantasia;
	}
	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome_responsavel() {
		return nome_responsavel;
	}
	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}
	public String getEmail_responsavel() {
		return email_responsavel;
	}
	public void setEmail_responsavel(String email_responsavel) {
		this.email_responsavel = email_responsavel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((email_responsavel == null) ? 0 : email_responsavel.hashCode());
		result = prime * result + ((nome_fantasia == null) ? 0 : nome_fantasia.hashCode());
		result = prime * result + ((nome_responsavel == null) ? 0 : nome_responsavel.hashCode());
		result = prime * result + ((razao_social == null) ? 0 : razao_social.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (email_responsavel == null) {
			if (other.email_responsavel != null)
				return false;
		} else if (!email_responsavel.equals(other.email_responsavel))
			return false;
		if (nome_fantasia == null) {
			if (other.nome_fantasia != null)
				return false;
		} else if (!nome_fantasia.equals(other.nome_fantasia))
			return false;
		if (nome_responsavel == null) {
			if (other.nome_responsavel != null)
				return false;
		} else if (!nome_responsavel.equals(other.nome_responsavel))
			return false;
		if (razao_social == null) {
			if (other.razao_social != null)
				return false;
		} else if (!razao_social.equals(other.razao_social))
			return false;
		return true;
	}
	
	
}
