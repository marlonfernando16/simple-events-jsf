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
import br.edu.ifpb.pweb2.controller.UserController;
import br.edu.ifpb.pweb2.model.Especialidade;


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

	
	@PostConstruct
	private void init() {
	}
	/*controller User */
	public void createUser(String nome, String phone, String email, String senha, String date, String typeUser) {
		if (typeUser.equalsIgnoreCase("FIS")) {
			userController.createUser(nome, phone, email, senha, date);
		} else if (typeUser.equalsIgnoreCase("ADM")) {
			adminController.createAdmin(nome, phone, email, senha, date);
		} else if (typeUser.equalsIgnoreCase("JUR")) {
			String endereco = "Rua gov. jose gomes";
			empresaController.createEmpresa(nome, phone, email, senha, date, endereco);
		}

	}
	/*controller login */
	public User loginIsValido(String usuario, String senha) {
		return loginController.isValido(usuario, senha);
	}

	public Especialidade createEspecialidade(Especialidade especialidade) {
		return especialidadeController.createEspecialidade(especialidade);
		
	}
	
	public List<Especialidade>findAllEspecialidades(){
		return especialidadeController.findAllEspecialidades();
	}
	public void deleteEspecialidade(Long id) {
		especialidadeController.deleteEspecialidade(id);
	}


}
