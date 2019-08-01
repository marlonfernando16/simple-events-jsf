package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.controller.EspecialidadeController;
import br.edu.ifpb.pweb2.model.Especialidade;

@Named(value="userBean")
@SessionScoped
public class EspecialidadeBean extends GenericBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Especialidade> especialidades;
	
	private Especialidade especialidade;
	
	@Inject
	private EspecialidadeController ctrl;
	
	@PostConstruct
	private void init() {
		Especialidade especialidade = (Especialidade) this.getFlash("especialidade");
		if (especialidade != null) {
			this.especialidade = especialidade;
		} else {
			this.especialidades = ctrl.consultar(especialidade);
			this.especialidade  = new Especialidade();
		}
		
	}

}
