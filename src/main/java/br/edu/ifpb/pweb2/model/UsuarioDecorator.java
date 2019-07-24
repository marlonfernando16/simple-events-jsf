package br.edu.ifpb.pweb2.model;

import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class UsuarioDecorator extends User {
	User usuario;
	

	public UsuarioDecorator(User usuario) {
		this.usuario = usuario;
	}
	
	public UsuarioDecorator() {}


	public User getPerfil() {
		return new User();
	};
}
