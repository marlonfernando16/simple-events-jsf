package br.edu.ifpb.pweb2.fachada;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.controller.UserController;

public class Fachada {
	
@Inject
public static  UserController userController;
	
	public static void createUser(String nome, String phone,String email,String senha,String date) {
		System.out.println("eiiiiiiiiiiiiii");
		userController.createUser(nome, phone, email, senha, date);
	}

}
