package br.edu.ifpb.pweb2.bean;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@RequestScoped
public class CadastroBean {

	private Map<String, String> typeUser;

	@PostConstruct
	public void init() {
		this.typeUser = new LinkedHashMap<String, String>();
		this.typeUser.put("ADM", "admin");
		this.typeUser.put("COL", "colaborador");
		this.typeUser.put("EMP", "empresa");
	}

	public void typeUserChange(AjaxBehaviorEvent abe) {
		System.out.println("Aqui");
//		System.out.println("Processou ajax na fase: " + abe.getPhaseId() + " gerado por "
//				+ ((UIComponent) abe.getSource()).getClientId());
	}

	public Map<String, String> getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(Map<String, String> typeUser) {
		this.typeUser = typeUser;
	}

}
