package com.projeto.primagio.api.repository.filter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.projeto.primagio.api.model.Usuario;

public class EmpresaFilter {
	@OneToOne
	@JoinColumn(name = "usuario_codigo", referencedColumnName = "codigo")
	private Usuario usuario;
}
