package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.fachada.Fachada;
import br.edu.ifpb.pweb2.model.CandidatoVaga;
import br.edu.ifpb.pweb2.model.Vaga;

@Named
@ViewScoped
public class VagaBean extends GenericBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Vaga> vagas;

	private Vaga vaga;

	@Inject
	private Fachada fachada;

	@PostConstruct
	private void init() {
		Vaga vaga = (Vaga) this.getFlash("vaga");
		if (vaga != null) {
			this.vaga = vaga;
		} else {
			this.vagas = fachada.findAllVagas();
			this.vaga = new Vaga();
		}
	}

	public String createVaga() {
		String proxView = null;
		try {
			fachada.createVaga(vaga);
			this.addSuccessMessage("Vaga salva com sucesso");
			proxView = "/pages/dashboard/eventos?faces-redirect=true";
			this.vaga = new Vaga();
		} catch (Exception e) {
			this.addErrorMessage("Erro ao tentar salvar a vaga");
		}
		return proxView;

	}

	public String deleteVaga(Long id) {
		fachada.deleteEspecialidade(id);
		this.vagas = fachada.findAllVagas();
		return "/pages/dashboard/eventos?faces-redirect=true";
	}

	public String editVaga(Vaga v) {
		this.setFlash("vaga", v);
		return "/pages/dashboard/eventos?faces-redirect=true";
	}
	
	public boolean contains(Long id_candidato) {
//		System.out.println(id_candidato);
		for (Vaga vaga : vagas) {
			for (CandidatoVaga cv: vaga.getCandidato_vaga()) {
				if(id_candidato == cv.getCandidato().getId())
					return true;
			}
		}
		return false;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

}
