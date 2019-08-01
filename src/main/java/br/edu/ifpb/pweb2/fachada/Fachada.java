package br.edu.ifpb.pweb2.fachada;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.edu.ifpb.pweb2.controller.AdminController;
import br.edu.ifpb.pweb2.controller.EmpresaController;
import br.edu.ifpb.pweb2.controller.UserController;

public class Fachada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private UserController userController;
	@Inject
	private AdminController adminController;
	@Inject
	private EmpresaController empresaController;
	
	@PostConstruct
	private void init() {
	}

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


}
