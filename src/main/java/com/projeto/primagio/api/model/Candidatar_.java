package com.projeto.primagio.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Candidatar.class)
public abstract class Candidatar_ {

	public static volatile SingularAttribute<Candidatar, Vaga> vaga_codigo;
	public static volatile SingularAttribute<Candidatar, Vaga> empresa_codigo;
	public static volatile SingularAttribute<Candidatar, Long> codigo;
	public static volatile SingularAttribute<Candidatar, Estudante> estudante;
	public static volatile SingularAttribute<Candidatar, String> status;

}

