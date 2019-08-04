package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.fachada.Fachada;
import br.edu.ifpb.pweb2.model.Evento;



@Named
@SessionScoped
public class EventoBean extends GenericBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private Evento evento;
	//private List<Evento> eventos;
	private int[] quantidadevagas;
	private int[] especialidades;

	@Inject 
	private Fachada fachada;
	
	@PostConstruct
	private void init() {
		System.out.println("iiiiiiiiii");
		Evento evento = (Evento) this.getFlash("evento");
		if (evento != null) {
			this.evento = evento;
		} else {
			System.out.println("aaaaaaaaaaaaaaaaa");
			//this.eventos = fachada.findAllEventos();
			System.out.println("eventos"+this.evento);
			this.evento = new Evento();
		}
		
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	


	public int[] getQuantidadevagas() {
		return quantidadevagas;
	}

	public void setQuantidadevagas(int[] quantidadevagas) {
		this.quantidadevagas = quantidadevagas;
	}

	public int[] getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(int[] especialidades) {
		this.especialidades = especialidades;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public String createEvento() {
		System.out.println("oiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		//System.out.println("evento "+evento+" qtd-vagas "+quantidadevagas+"especialidades "+especialidades);
		return "/dashboard/perfil?faces-redirect=true";

	}
	
	
}
