package com.projeto.primagio.api.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estudante.class)
public abstract class Estudante_ {

	public static volatile SingularAttribute<Estudante, Long> codigo;
	public static volatile SingularAttribute<Estudante, Endereco> endereco;
	public static volatile SingularAttribute<Estudante, String> estadocivil;
	public static volatile SingularAttribute<Estudante, String> nome;
	public static volatile SingularAttribute<Estudante, Date> datanascimento;
	public static volatile SingularAttribute<Estudante, String> cpf;
	public static volatile SingularAttribute<Estudante, String> nomepai;
	public static volatile SingularAttribute<Estudante, Usuario> usuario;
	public static volatile SingularAttribute<Estudante, String> sobrenome;
	public static volatile SingularAttribute<Estudante, String> sexo;
	public static volatile SingularAttribute<Estudante, String> nacionalidade;
	public static volatile SingularAttribute<Estudante, Contato> contato;
	public static volatile SingularAttribute<Estudante, String> email;
	public static volatile SingularAttribute<Estudante, String> nomemae;

}

