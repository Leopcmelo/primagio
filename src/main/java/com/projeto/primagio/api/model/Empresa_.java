package com.projeto.primagio.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empresa.class)
public abstract class Empresa_ {

	public static volatile SingularAttribute<Empresa, String> nome_responsavel;
	public static volatile SingularAttribute<Empresa, String> email_responsavel;
	public static volatile SingularAttribute<Empresa, Long> codigo;
	public static volatile SingularAttribute<Empresa, Endereco> endereco;
	public static volatile SingularAttribute<Empresa, String> razao_social;
	public static volatile SingularAttribute<Empresa, Usuario> usuario;
	public static volatile SingularAttribute<Empresa, String> cnpj;
	public static volatile SingularAttribute<Empresa, String> nome_fantasia;
	public static volatile SingularAttribute<Empresa, Contato> contato;
	public static volatile SingularAttribute<Empresa, String> email;

}

