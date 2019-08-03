package br.edu.ifpb.pweb2.controller;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.EspecialidadeDAO;
import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.model.Especialidade;
import br.edu.ifpb.pweb2.model.User;

public class EspecialidadeController {
	
	@Inject
	private EspecialidadeDAO especialidadeDAO;
	
	EspecialidadeController(){};

	public List<Especialidade> findAllEspecialidades() {
		List<Especialidade> especialidades = especialidadeDAO.findAll();
		return especialidades;
	}

	@Transactional
	public Especialidade createEspecialidade(Especialidade especialidade)  {
		Especialidade esp = especialidadeDAO.findByName(especialidade.getNome());
		if(esp != null ) {
			return null;
		}else {
			especialidadeDAO.beginTransaction();
			especialidadeDAO.insert(especialidade);
			especialidadeDAO.commit();
			return especialidade;
		}	
	}

	@Transactional
	public void deleteEspecialidade(Long id) {
		Especialidade e = especialidadeDAO.find(id);
		especialidadeDAO.beginTransaction();
		especialidadeDAO.delete(e);
		especialidadeDAO.commit();
	}

}
