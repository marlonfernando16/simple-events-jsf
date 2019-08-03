package br.edu.ifpb.pweb2.controller;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.edu.ifpb.pweb2.dao.EmpresaDAO;
import br.edu.ifpb.pweb2.dao.Transactional;
import br.edu.ifpb.pweb2.dao.UserDAO;
import br.edu.ifpb.pweb2.model.Empresa;
import br.edu.ifpb.pweb2.model.User;

public class EmpresaController implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Inject
	EmpresaDAO empresaDAO;
	
	@Inject
	UserDAO userDAO;
	
	EmpresaController(){};
	
	@Transactional
	public Empresa createEmpresa(String nome, String phone,String email,String senha,String date, String endereco) {
		User usuario = userDAO.findByLogin(email);
		if(usuario != null) {
			return null;
		}
		
		User user = new User();
		user.setNome(nome);
		user.setTelefone(phone);
		user.setEmail(email);
		user.setSenha(senha);
		user.setDatanascimento(new Date(date));
		userDAO.beginTransaction();
		userDAO.insert(user);
		userDAO.commit();
		Empresa empresa = new Empresa(user);
		empresa.setEndereco(endereco);
		empresaDAO.beginTransaction();
		empresaDAO.insert(empresa);
		empresaDAO.commit();
		return empresa;
	}

}
