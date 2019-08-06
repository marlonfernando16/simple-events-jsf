package br.edu.ifpb.pweb2.fachada;

import java.io.Serializable;
import java.util.List;

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

	
	@PostConstruct
	private void init() {
	}
	/*controller User */
	public User createUser(String nome, String phone, String email, String senha, String date, String typeUser, String endereco) {
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
	/*controller login */
	public User loginIsValido(String usuario, String senha) {
		return loginController.isValido(usuario, senha);
	}
	
	public boolean userIsAdmin(long idUser) {
		Admin admin = adminController.find(idUser);
		if(admin != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean userIsEmpresa(long idUser) {
		Empresa empresa = empresaController.find(idUser);
		if(empresa != null) {
			return true;
		}else {
			return false;
		}
	}
	
	/*controller Especialidade */

	/*controller especialidade*/
	public Especialidade createEspecialidade(Especialidade especialidade) {
		return especialidadeController.createEspecialidade(especialidade);
	}
	
	public List<Especialidade>findAllEspecialidades(){
		return especialidadeController.findAllEspecialidades();
	}
	public void deleteEspecialidade(Long id) {
		especialidadeController.deleteEspecialidade(id);
	}
	
	/*controller evento */
	public 	Evento createEvento(Evento evento, String[]quantidadevagas) {
		List<Especialidade> especialidades = this.findAllEspecialidades();
		User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		System.out.println("user logged"+user);
		evento.setOwner(user);
		Evento ev = eventoController.createEvento(evento);
		if(ev == null) {
			return null;
		}
		int i = 0;
		for(String s : quantidadevagas) {
			if(s!= "" && s!=null) {
				Vaga vaga = new Vaga();
				vaga.setEspecialidade(especialidades.get(i));
				vaga.setQtd_vagas(Integer.parseInt(s));
				evento.add(vaga);
				vaga.setEvento(evento);
				vagaController.createVaga(vaga);
			}
			i++;
		}
		System.out.println(evento);
		return evento;
	}
	
	public List<Evento>findAllEventos(){
		return eventoController.findAllEventos();
	}
	public void deleteEvento(Long id) {
		eventoController.deleteEvento(id);
	}
	
	public boolean candidatar(List<String> vagas) {
		User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		MudaEstado mv = new MudaEstado();
		for(String idvagaS: vagas) {
			long idvaga = Long.parseLong(idvagaS);
			Vaga vaga = vagaController.find(idvaga);
			CandidatoVaga cv= new CandidatoVaga();
			cv.setCandidato(user);
			mv.setState(false, State.NAO_AVALIADO, cv);
			cv.setVaga(vaga);
			candidatoVagaController.createCandidatoVaga(cv);
			
		}
		return true;
	}
	
}
