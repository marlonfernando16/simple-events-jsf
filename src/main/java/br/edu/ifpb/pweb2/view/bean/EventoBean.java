package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.fachada.Fachada;
import br.edu.ifpb.pweb2.model.Evento;



@Named
@ViewScoped
public class EventoBean extends GenericBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private Evento evento;
	//private List<Evento> eventos;
	private String[] quantidadevagas;

	@Inject 
	private Fachada fachada;
	
	@PostConstruct
	private void init() {
		quantidadevagas = new String[10];
		Evento evento = (Evento) this.getFlash("evento");
		if (evento != null) {
			this.evento = evento;
		} else {
			this.evento = new Evento();
		}
	}
	
	

//	public String createEvento() {
//		FacesMessage.Severity nivel = FacesMessage.SEVERITY_ERROR; 
//		FacesContext fc = FacesContext.getCurrentInstance();
//		Evento ev = fachada.createEvento(evento, quantidadevagas);
//		if(ev == null) {
//			this.addErrorMessage("já existe um evento com esse nome");
//			return null;
//		}
//		this.addSuccessMessage("Evento cadastrado com sucesso !");
//		return "/pages/dashboard/perfil?faces-redirect=true";
//
//	}
	public String createEvento() {
		String proxView = null;
		try {
			fachada.createEvento(evento, quantidadevagas);
			this.addSuccessMessage("Evento salvo com sucesso");
			proxView = "/pages/dashboard/eventos?faces-redirect=true";
			this.evento = new Evento();
		} catch (Exception e) {
			this.addErrorMessage("Erro ao tentar salvar o evento");
		}
		return proxView;

	}
	
	public List<Evento> findAllEventos() {
		FacesMessage.Severity nivel = FacesMessage.SEVERITY_ERROR; 
		FacesContext fc = FacesContext.getCurrentInstance();
		List<Evento> eventos = fachada.findAllEventos();
		return eventos;
	}
	
	public String deleteEvento(Long id) {
		fachada.deleteEvento(id);
		return "/pages/dashboard/eventos?faces-redirect=true";
	}
	
	public String editEvento(Evento e) {
		this.setFlash("evento", e);
		return "/pages/dashboard/especialidade?faces-redirect=true";
	}	
	
	public String findMyEventos(Long id) {
		System.out.println(id);
		return null;
	}
	
	public String[] getQuantidadevagas() {
		return quantidadevagas;
	}

	public void setQuantidadevagas(String[] quantidadevagas) {
		this.quantidadevagas = quantidadevagas;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
