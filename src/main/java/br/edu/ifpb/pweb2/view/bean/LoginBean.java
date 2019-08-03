package br.edu.ifpb.pweb2.view.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.pweb2.controller.LoginController;
import br.edu.ifpb.pweb2.fachada.Fachada;
import br.edu.ifpb.pweb2.model.User;

@Named
@SessionScoped
public class LoginBean extends GenericBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String usuario;
	
	private String senha;
	
	private User usuarioLogado;
	
	@Inject
	Fachada fachada;

	public String autentique() {
		String proxView = null;
		String mensagem = "Usuário ou senha inválidos!";
		FacesMessage.Severity nivel = FacesMessage.SEVERITY_ERROR;
		FacesContext fc = FacesContext.getCurrentInstance();
		if ((usuarioLogado = fachada.loginIsValido(usuario, senha)) != null) {
			this.setValueOf("#{sessionScope.loginUser}", String.class, usuarioLogado.getEmail());
			proxView = "/pages/dashboard/eventos?faces-redirect=true";
			mensagem = "Usuário válido!";
		}
		this.addErrorMessage(mensagem);
		
		return proxView;
	}
	
	public String logout() {
		this.invalidateSession();
		return "/pages/login/login?faces-redirect=true";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public User getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(User usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}

