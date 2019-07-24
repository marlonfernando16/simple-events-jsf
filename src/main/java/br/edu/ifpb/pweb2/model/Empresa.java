package br.edu.ifpb.pweb2.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_empresa")
@DiscriminatorValue(value = "empresa")
public class Empresa extends UsuarioDecorator {
	
	String endereco;
	
	public String getEndereco() {
		return endereco;
	}
	
	public Empresa() {}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Empresa(User usuario) {
		super(usuario);
	}
	
	

}
