package br.edu.ifpb.pweb2.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_admin")
@DiscriminatorValue(value = "admin")
public class Admin extends User {
	
	public void cadastrarEspecialidade() {};
	public void removerEvento() {};
	public void removerUsuario() {};

}
