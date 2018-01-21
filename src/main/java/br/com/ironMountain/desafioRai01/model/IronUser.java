/*
	==============================================================================================
	Data: 	20/01/2017
	Autor: 	Rai
	Edição:	Este arquivo foi gerado automatiamente pelo Template WildFly encontrado no Maven
			Modificado para atender especificação do DESAFIO IMB-desafio-tecnico.pdf

	==============================================================================================
 */
package br.com.ironMountain.desafioRai01.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@SessionScoped
// A constraint ou bean validation acima define que não podem haver emails repetidos
public class IronUser implements Serializable {

    private String name;
    private String email;
    private boolean memberActive = true;
    private boolean logado;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
	public boolean isMemberActive() {
		return memberActive;
	}

	public void setMemberActive(boolean memberActive) {
		this.memberActive = memberActive;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

}
