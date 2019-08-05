package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.fachada.Fachada;
import br.edu.ifpb.pweb2.model.Especialidade;

@Named
@ViewScoped
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

	public String createEspecialidade() {
		String proxView = null;
		try {
			fachada.createEspecialidade(especialidade);
			this.addSuccessMessage("Especialidade salva com sucesso");
			proxView = "/pages/dashboard/especialidades?faces-redirect=true";
			this.especialidade = new Especialidade();
		} catch (Exception e) {
			this.addErrorMessage("Erro ao tentar salvar a especialidade");
		}
		return proxView;

	}
		
	public String deleteEspecialidade(Long id) {
		fachada.deleteEspecialidade(id);
		this.especialidades = fachada.findAllEspecialidades();
		return "/pages/dashboard/especialidades?faces-redirect=true";
	}
	
	public String editEspecialidade(Especialidade e) {
		this.setFlash("especialidade", e);
		return "/pages/dashboard/especialidade?faces-redirect=true";
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
}
