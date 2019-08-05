package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.fachada.Fachada;
import br.edu.ifpb.pweb2.model.Evento;
import br.edu.ifpb.pweb2.model.Vaga;
@Named
@RequestScoped
public class CandidatoVagaBean extends GenericBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	List<String> vagas;
	
	@PostConstruct
	private void init() {
		vagas = new ArrayList<String>();
	}
	
	@Inject 
	private Fachada fachada;
	
	public void add(String vaga) {
		this.vagas.add(vaga);
	}


	public String candidatar() {
		System.out.println("vagaseiiiii ");
		for (String s : vagas) {
			System.out.println(s);
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
