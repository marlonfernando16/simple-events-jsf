package br.edu.ifpb.pweb2.fachada;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.edu.ifpb.pweb2.controller.AdminController;
import br.edu.ifpb.pweb2.controller.EmpresaController;
import br.edu.ifpb.pweb2.controller.LoginController;
import br.edu.ifpb.pweb2.controller.UserController;
import br.edu.ifpb.pweb2.model.User;
import br.edu.ifpb.pweb2.controller.EspecialidadeController;
import br.edu.ifpb.pweb2.controller.EventoController;
import br.edu.ifpb.pweb2.model.Especialidade;
import br.edu.ifpb.pweb2.model.Evento;


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
	public 	Evento createEvento(Evento evento) {
		return eventoController.createEvento(evento);
	}
	
	public List<Evento>findAllEventos(){
		return eventoController.findAllEspecialidades();
	}

}
