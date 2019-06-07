package com.projeto.primagio.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Academico.class)
public abstract class Academico_ {

	public static volatile SingularAttribute<Academico, String> periodo_letivo;
	public static volatile SingularAttribute<Academico, Long> codigo;
	public static volatile SingularAttribute<Academico, String> duracaodocurso;
	public static volatile SingularAttribute<Academico, String> disponibilidade;
	public static volatile SingularAttribute<Academico, String> tipo_curso;
	public static volatile SingularAttribute<Academico, String> instituicao;
	public static volatile SingularAttribute<Academico, String> turno;
	public static volatile SingularAttribute<Academico, String> cidade_da_instituicao;
	public static volatile SingularAttribute<Academico, String> previsao_termino;
	public static volatile SingularAttribute<Academico, String> curso;
	public static volatile SingularAttribute<Academico, String> matricula;
	public static volatile SingularAttribute<Academico, Estudante> estudante;
	public static volatile SingularAttribute<Academico, String> nivel;

}

