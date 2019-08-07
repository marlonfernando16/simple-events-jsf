package br.edu.ifpb.pweb2.fachada;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.edu.ifpb.pweb2.controller.AdminController;
import br.edu.ifpb.pweb2.controller.CandidatoVagaController;
import br.edu.ifpb.pweb2.controller.EmpresaController;
import br.edu.ifpb.pweb2.controller.EspecialidadeController;
import br.edu.ifpb.pweb2.controller.EventoController;
import br.edu.ifpb.pweb2.controller.LoginController;
import br.edu.ifpb.pweb2.controller.UserController;
import br.edu.ifpb.pweb2.controller.VagaController;
import br.edu.ifpb.pweb2.model.Admin;
import br.edu.ifpb.pweb2.model.CandidatoVaga;
import br.edu.ifpb.pweb2.model.Empresa;
import br.edu.ifpb.pweb2.model.Especialidade;
import br.edu.ifpb.pweb2.model.Evento;
import br.edu.ifpb.pweb2.model.MudaEstado;
import br.edu.ifpb.pweb2.model.State;
import br.edu.ifpb.pweb2.model.User;
import br.edu.ifpb.pweb2.model.Vaga;

public class Fachada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private UserController userController;
	@Inject
	private AdminController adminController;
	@Inject
	private EmpresaController empresaController;
	@Inject
	private LoginController loginController;
	@Inject
	private EspecialidadeController especialidadeController;
	@Inject
	private EventoController eventoController;
	@Inject
	private VagaController vagaController;
	@Inject
	private CandidatoVagaController candidatoVagaController;
	@Inject
	MudaEstado mudaEstado;

	@PostConstruct
	private void init() {
	}

	/* controller User */
	public User createUser(String nome, String phone, String email, String senha, String date, String typeUser,
			String endereco) {
		User user = null;
		if (typeUser.equalsIgnoreCase("FIS")) {
			user = userController.createUser(nome, phone, email, senha, date);
		} else if (typeUser.equalsIgnoreCase("ADM")) {
			user = adminController.createAdmin(nome, phone, email, senha, date);
		} else if (typeUser.equalsIgnoreCase("JUR")) {
			user = empresaController.createEmpresa(nome, phone, email, senha, date, endereco);
		}
		return user;

	}

	/* controller login */
	public User loginIsValido(String usuario, String senha) {
		return loginController.isValido(usuario, senha);
	}

	public boolean userIsAdmin(long idUser) {
		Admin admin = adminController.find(idUser);
		if (admin != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean userIsEmpresa(long idUser) {
		Empresa empresa = empresaController.find(idUser);
		if (empresa != null) {
			return true;
		} else {
			return false;
		}
	}

	/* controller Especialidade */

	/* controller especialidade */
	public Especialidade createEspecialidade(Especialidade especialidade) {
		return especialidadeController.createEspecialidade(especialidade);
	}

	public List<Especialidade> findAllEspecialidades() {
		return especialidadeController.findAllEspecialidades();
	}

	public void deleteEspecialidade(Long id) {
		especialidadeController.deleteEspecialidade(id);
	}

	/* controller evento */
	public Evento createEvento(Evento evento, String[] quantidadevagas) {
		List<Especialidade> especialidades = this.findAllEspecialidades();
		User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		evento.setOwner(user);
		Evento ev = eventoController.createEvento(evento);
		if (ev == null) {
			return null;
		}
		int i = 0;
		for (String qv : quantidadevagas) {
			if (qv != "" && qv != null) {
				Vaga vaga = new Vaga();
				vaga.setEspecialidade(especialidades.get(i));
				vaga.setQtd_vagas(Integer.parseInt(qv));
				evento.add(vaga);
				vaga.setEvento(evento);
				vagaController.createVaga(vaga);
			}
			i++;
		}
		return evento;
	}

	public List<Evento> findAllEventos() {
		return eventoController.findAllEventos();
	}

	public void deleteEvento(Long id) {
		eventoController.deleteEvento(id);
	}

	public boolean candidatar(Map<Long, Boolean> checked) {
		User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

		for (Map.Entry<Long, Boolean> idvagaS : checked.entrySet()) {
			if (idvagaS.getValue()) {
				Vaga vaga = vagaController.find(idvagaS.getKey());
				CandidatoVaga cv = new CandidatoVaga();
				cv.setCandidato(user);
				mudaEstado.setState(false, State.NAO_AVALIADO, cv);
				cv.setVaga(vaga);
				candidatoVagaController.createCandidatoVaga(cv);
			}
		}
		return true;
	}

	public boolean finalizarEvento(String[] candidatovagaIds) {
		Evento evento = null;
		for (String cvid : candidatovagaIds) {
			long id = Long.parseLong(cvid);
			CandidatoVaga cv = candidatoVagaController.find(id);
			evento = cv.getVaga().getEvento();
			mudaEstado.setState(false, State.APROVADO, cv);
			candidatoVagaController.updateCandidatoVaga(cv);
		}
		for (Vaga vaga : evento.getVagas()) {
			for (CandidatoVaga cv : vaga.getCandidatovaga()) {
				if (cv.getState() == State.NAO_AVALIADO) {
					mudaEstado.setState(false, State.NAO_APROVADO, cv);
					candidatoVagaController.updateCandidatoVaga(cv);
				}
			}
		}
		evento.setFinalizado(true);
		evento.notifyObservers();
		eventoController.updateEvento(evento);
		return true;

	}

	public List<Vaga> findAllVagas() {
		return vagaController.findAllVagas();
	}

	public Vaga createVaga(Vaga vaga) {
		return vagaController.createVaga(vaga);
	}

}
