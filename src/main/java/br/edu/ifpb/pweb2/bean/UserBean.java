package br.edu.ifpb.pweb2.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.edu.ifpb.pweb2.controller.UserController;
@ManagedBean
@SessionScoped
public class UserBean extends GenericBean implements Serializable {
	private static final long serialVersionUID = 1L;
	/*Formulario*/
	private String nome;

	private String phone;

	private String email;

	private String senha;

	private String date;
	
	private String typeUser;
	
	@Inject
	public UserController userController;
	
	
	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public void createUser() {
		System.out.println(""+nome+" "+ phone+" "+ email+" "+senha+" "+ date);
		System.out.println("ihuuuuuu");
		System.out.println(userController);
		userController.createUser(nome, phone, email, senha, date);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}



}
