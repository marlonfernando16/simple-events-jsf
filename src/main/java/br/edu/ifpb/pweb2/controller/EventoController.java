package br.edu.ifpb.pweb2.controller;

import java.util.List;

import javax.inject.Inject;
import br.edu.ifpb.pweb2.dao.EventoDAO;
import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.model.Especialidade;
import br.edu.ifpb.pweb2.model.Evento;

public class EventoController {

	@Inject
	private EventoDAO eventoDAO;
	
	
	@Transactional
	public Evento createEvento(Evento evento) {
		Evento esp = eventoDAO.findByName(evento.getNome());
		if(esp != null ) {
			return null;
		}else {
			eventoDAO.beginTransaction();
			eventoDAO.insert(evento);
			eventoDAO.commit();
			return evento;
		}	
	}
	
	public List<Evento> findAllEspecialidades() {
		List<Evento> evento = eventoDAO.findAll();
		return evento;
	}
}
