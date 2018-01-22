/*******
 * 
 * Classe para controlar usuários
 * 
 * @author		Rai Braga
 * @version 		2018-01-20
 * 
 */

package br.com.ironMountain.desafioRai01.controller;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.ironMountain.desafioRai01.model.IronUser;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class IronUserController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private IronUser ironUser;

    private String userName;
    private String userPass;
    
    public String login() {
    		if ("admin".equals(this.userName) && "im2018".equals(this.userPass)) {
    			this.ironUser.setName(this.userName);
    			this.ironUser.setLogado(true);
    			
    			return "/index.xhtml?faces-redirect=true";
    		} else {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Login", "Usuário e/ou senha inválidos");
            facesContext.addMessage(null, m);
    		}
    		return null;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String password) {
		this.userPass = password;
	}
}
