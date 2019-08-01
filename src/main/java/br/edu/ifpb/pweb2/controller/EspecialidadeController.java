package br.edu.ifpb.pweb2.controller;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.EspecialidadeDAO;
import br.edu.ifpb.pweb2.model.Especialidade;

public class EspecialidadeController {
	
	@Inject
	private EspecialidadeDAO especialidadeDAO;

	public List<Especialidade> consultar(Especialidade especialidade) {
		List<Especialidade> especialidades = especialidadeDAO.findAllFromEspecialidade(especialidade);
		return especialidades;
	}

}
