package com.projeto.primagio.api.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vaga.class)
public abstract class Vaga_ {

	public static volatile SingularAttribute<Vaga, Long> codigo;
	public static volatile SingularAttribute<Vaga, String> periodomax;
	public static volatile SingularAttribute<Vaga, Boolean> ativo;
	public static volatile SingularAttribute<Vaga, String> tipo_curso;
	public static volatile SingularAttribute<Vaga, String> titulo;
	public static volatile SingularAttribute<Vaga, BigDecimal> valor_bolsa;
	public static volatile SingularAttribute<Vaga, String> turno;
	public static volatile SingularAttribute<Vaga, String> descricao;
	public static volatile SingularAttribute<Vaga, String> periodomin;
	public static volatile SingularAttribute<Vaga, String> curso;
	public static volatile SingularAttribute<Vaga, Empresa> empresa;
	public static volatile SingularAttribute<Vaga, String> nivel;
	public static volatile SingularAttribute<Vaga, String> beneficios;

}

