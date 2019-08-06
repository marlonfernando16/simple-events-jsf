package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.fachada.Fachada;
import br.edu.ifpb.pweb2.model.Especialidade;
import br.edu.ifpb.pweb2.model.Evento;
import br.edu.ifpb.pweb2.model.Vaga;
@Named
@RequestScoped
public class CandidatoVagaBean extends GenericBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	List<String> vagas;
	
	String[] candidatos;


	public String[] getCandidatos() {
		return candidatos;
	}


	public void setCandidatos(String[] candidatos) {
		this.candidatos = candidatos;
	}


	@PostConstruct
	private void init() {
		vagas = new ArrayList<String>();
		candidatos = new String[100];
	}
	
	@Inject 
	private Fachada fachada;
	
	public void add(String vaga) {
		this.vagas.add(vaga);
	}


	public String candidatar() {
		if(fachada.candidatar(vagas)) {
			this.addSuccessMessage("candidatura efetuada com suceso");
			return "/dashboard/eventos?redirect=true";
		}
			this.addErrorMessage("não foi possível efetuar sua candidatura");
			return null;
	}
	
	public String finalizar() {
		if(fachada.finalizarEvento(candidatos)) {
			this.addSuccessMessage("evento finalizado");
			return "/dashboard/eventos?redirect=true";
		}
		
		return null;
	}
		
	

	public List<String> getVagas() {
		return vagas;
	}
	
	public void setVagas(List<String> vagas) {
		this.vagas = vagas;
	}
}
