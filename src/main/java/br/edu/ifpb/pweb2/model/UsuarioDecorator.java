package br.edu.ifpb.pweb2.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@MappedSuperclass
public class UsuarioDecorator extends User {
	@OneToOne
	User usuario;
	

	public UsuarioDecorator(User usuario) {
		this.usuario = usuario;
	}
	
	public UsuarioDecorator() {}


	public User getPerfil() {
		return new User();
	};
}
