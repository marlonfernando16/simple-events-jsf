package br.edu.ifpb.pweb2.view.bean;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;


public abstract class GenericBean {
	 
	/** Devolve um objeto acess�vel a partir de uma express�o JSF-EL.
	 * @param elExpression A express�o EL de acesso ao objeto.
	 * @param clazz A classe deste objeto.
	 * @return O objeto acess�vel pela EL.
	 */
	@SuppressWarnings("unchecked")
	public Object getValueOf(String elExpression, Class clazz) {
		FacesContext current = FacesContext.getCurrentInstance();
		ELContext elContext = current.getELContext();
		Application app = current.getApplication();
		ExpressionFactory fac = app.getExpressionFactory();
		ValueExpression ve = fac.createValueExpression(elContext, elExpression, clazz);
		return ve.getValue(current.getELContext());
	}

	/** Modifica um objeto acess�vel a partir de uma express�o JSF-EL.
	 * @param elExpression A express�o EL de acesso ao objeto.
	 * @param clazz A classe deste objeto.
	 * @param value O novo objeto.
	 */
	@SuppressWarnings("unchecked")
	public void setValueOf(String elExpression, Class clazz, Object value) {
		FacesContext current = FacesContext.getCurrentInstance();
		ELContext elContext = current.getELContext();
		Application app = current.getApplication();
		ExpressionFactory fac = app.getExpressionFactory();
		ValueExpression ve = fac.createValueExpression(elContext, elExpression, clazz);
		ve.setValue(current.getELContext(), value);		
	}
	
	/** Obt�m o backing bean a partir do seu nome.
	 * @param beanName O nome do backing bean.
	 * @return O backing bean.
	 */
	public Object getBean(String beanName) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        return facesContext.getApplication().getELResolver().getValue(elContext, null, beanName);
	}

	/** Invalida a sess�o HTTP.
	 * @param beanName O nome do backing bean.
	 */
	public void invalidateSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
        ((HttpSession)facesContext.getExternalContext().getSession(false)).invalidate();
	}
	
	/**Adiciona uma nova mensagem ao FacesContext.
	 * @param severidade Severidade da mensagem.
	 * @param mensagem Texto da mensagem.
	 */
	public void addMessage(FacesMessage.Severity severidade, String mensagem) {
		FacesMessage m = new FacesMessage(severidade, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, m);
	}
	
	/**Adiciona uma nova mensagem de erro ao FacesContext.
	 * @param mensagem Texto da mensagem.
	 */
	public void addErrorMessage(String mensagem) {
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, m);
	}
	
	/**Adiciona uma nova mensagem de sucesso ao FacesContext.
	 * @param mensagem Texto da mensagem.
	 */
	public void addSuccessMessage(String mensagem) {
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, m);
	}
	
	/**
	 * Seta um par�metro de request chamado endofconversation para sinalizar para o filtro
	 * que a conversa��o deve ser finalizada e o entitymanager fechado. Usado logo depois de um
	 * rollback em uma transa��o de BD.
	 */
	public void endOfConversation() {
		this.setValueOf("#{requestScope.endofconversation}", String.class, "true");
	}
	
	public HttpSession getHttpSession() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
        return ((HttpSession)facesContext.getExternalContext().getSession(false));
	}
	
	
	public void pesquisar(ActionEvent e) {}

}
