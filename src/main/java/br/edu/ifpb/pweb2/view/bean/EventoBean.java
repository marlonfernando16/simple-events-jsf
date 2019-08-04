package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.fachada.Fachada;
import br.edu.ifpb.pweb2.model.Evento;



@Named
@RequestScoped
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
	

	public String createEvento() {
		System.out.println("oiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		System.out.println("evento "+evento+" qtd-vagas ");
		for(String s : quantidadevagas) {
			System.out.println(s);
		}
		return "/dashboard/perfil?faces-redirect=true";

	}
	
	
}
