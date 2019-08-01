package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.fachada.Fachada;

@Named(value="userBean")
@SessionScoped
public class UserBean implements Serializable{
private static final long serialVersionUID = 1L;
	@Inject 
	private Fachada fachada;
	/* Formul�rio */
	private String nome;

	private String phone;

	private String email;

	private String senha;

	private String date;
	
	private String typeUser;
	
	@PostConstruct
	private void init() {
		System.out.println("Fachada: "+ fachada);
	}
	
	public String createUser() {
		System.out.println("fachada "+fachada);
		fachada.createUser(nome, phone, email, senha, date, typeUser);
		return "login/login";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

}
