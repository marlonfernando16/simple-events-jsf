package br.edu.ifpb.pweb2.model;

public class UsuarioDecorator extends User {
	User usuario;
	

	public UsuarioDecorator(User usuario) {
		this.usuario = usuario;
	}


	public User getPerfil() {
		return new User();
	};
}
