package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.fachada.Fachada;
import br.edu.ifpb.pweb2.model.Especialidade;
import br.edu.ifpb.pweb2.model.Evento;



@Named
@RequestScoped
public class EventoBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private Evento evento;
	private List<Evento> eventos;

	@Inject 
	private Fachada fachada;

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public String createEvento() {
		FacesMessage.Severity nivel = FacesMessage.SEVERITY_ERROR; 
		FacesContext fc = FacesContext.getCurrentInstance();
		Evento event = fachada.createEvento(evento);
		this.eventos = fachada.findAllEventos();
		if (event!= null) {
			System.out.println("especialidade cadastrada");
			//this.addSuccessMessage("Evento cadastrada com sucesso");
			return "/dashboard/perfil?faces-redirect=true";
		}else {
			System.out.println("ja tem ");
			//this.addErrorMessage("Evento ja cadastrada");
			return null;
		}
	}
	
	
}
