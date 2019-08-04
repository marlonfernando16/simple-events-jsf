package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.fachada.Fachada;
import br.edu.ifpb.pweb2.model.Especialidade;

@Named
@RequestScoped
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
			System.out.println("especialidades"+this.especialidades);
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
			FacesMessage.Severity nivel = FacesMessage.SEVERITY_ERROR; 
			FacesContext fc = FacesContext.getCurrentInstance();
			Especialidade esp = fachada.createEspecialidade(especialidade);
			this.especialidades = fachada.findAllEspecialidades();
			if (esp!= null) {
				System.out.println("especialidade cadastrada");
				this.addSuccessMessage("Especialidade cadastrada com sucesso");
				return "/dashboard/perfil?faces-redirect=true";
			}else {
				System.out.println("ja tem ");
				this.addErrorMessage("Especialidade ja cadastrada");
				return null;
			}
			
	}
	public String deleteEspecialidade(Long id) {
		fachada.deleteEspecialidade(id);
		this.especialidades = fachada.findAllEspecialidades();
		return "/dashboard/especialidades?faces-redirect=true";
	}

}
