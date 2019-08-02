package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.controller.EspecialidadeController;
import br.edu.ifpb.pweb2.fachada.Fachada;
import br.edu.ifpb.pweb2.model.Especialidade;

@Named(value="especialidadeBean")
@SessionScoped
public class EspecialidadeBean extends GenericBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Especialidade> especialidades;
	
	private Especialidade especialidade;
	
	@Inject 
	private Fachada fachada;
	
	@PostConstruct
	private void init() {
		Especialidade especialidade = (Especialidade) this.getFlash("especialidade");
		if (especialidade != null) {
			this.especialidade = especialidade;
		} else {
			this.especialidades = fachada.findAllEspecialidades();
			this.especialidade  = new Especialidade();
		}
		
	}
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	public String createEspecialidade() {
		
			fachada.createEspecialidade(especialidade);
			this.addSuccessMessage("Especialidade cadastrada com sucesso");
			return "/dashboard/perfil?faces-redirect=true";
	}

}
