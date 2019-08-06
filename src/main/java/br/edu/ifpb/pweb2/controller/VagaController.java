package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.dao.VagaDAO;
import br.edu.ifpb.pweb2.model.Especialidade;
import br.edu.ifpb.pweb2.model.Vaga;

public class VagaController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private VagaDAO vagaDAO;
	
	VagaController(){};
	
	public Vaga find(long id) {
		return vagaDAO.find(id);
	}
	
	@Transactional
	public Vaga createVaga(Vaga vaga)  {
		vagaDAO.beginTransaction();
		vagaDAO.insert(vaga);
		vagaDAO.commit();
		return vaga;
		}	
}
