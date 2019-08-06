package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.CandidatoVagaDAO;
import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.model.CandidatoVaga;
import br.edu.ifpb.pweb2.model.Vaga;


public class CandidatoVagaController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	CandidatoVagaDAO candidatoVagaDAO;

	@Transactional
	public CandidatoVaga createCandidatoVaga(CandidatoVaga candidatoVaga)  {
			candidatoVagaDAO.beginTransaction();
			candidatoVagaDAO.insert(candidatoVaga);
			candidatoVagaDAO.commit();
			return candidatoVaga;	
	}
	
	@Transactional
	public CandidatoVaga updateCandidatoVaga(CandidatoVaga candidatoVaga)  {
			candidatoVagaDAO.beginTransaction();
			candidatoVagaDAO.update(candidatoVaga);
			candidatoVagaDAO.commit();
			return candidatoVaga;	
	}
	
	public CandidatoVaga find(long id) {
		return candidatoVagaDAO.find(id);
	}
}
