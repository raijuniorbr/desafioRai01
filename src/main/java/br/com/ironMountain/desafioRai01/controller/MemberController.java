/*
 * 	==============================================================================================
	Data: 	20/01/2017
	Autor: 	Rai
	Edição:	Este arquivo foi gerado automatiamente pelo Template WildFly encontrado no Maven
			Modificado para atender especificação do DESAFIO IMB-desafio-tecnico.pdf

	==============================================================================================

 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.ironMountain.desafioRai01.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import br.com.ironMountain.desafioRai01.model.Member;
import br.com.ironMountain.desafioRai01.model.TypeMember;
import br.com.ironMountain.desafioRai01.service.MemberRegistration;

// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
public class MemberController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private MemberRegistration memberRegistration;

    @Produces
    @Named
    private Member newMember;

    @Produces
    @Named
    private Member currMember;
    
    @PostConstruct
    public void initNewMember() {
        newMember = new Member();
    }

    // 2018-01-20 : Rai
    public void register() throws Exception {
        try {
        		newMember.setMemberActive(true);
            memberRegistration.register(newMember);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado!", "Sucesso na inclusão");
            facesContext.addMessage(null, m);
            initNewMember();
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            // 2018-01-20 : Rai
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Problemas no registro");
            facesContext.addMessage(null, m);
        }
    }
    
    private String getRootErrorMessage(Exception e) {
        // Default to general error message that registration failed.
        // 2018-01-20 : Rai
        String errorMessage = "Registro falhou. Veja o LOG para maiores informações.";
        if (e == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = e;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }

    // 2018-01-20 : Rai
    public void save(Member member) throws Exception {
        try {
            memberRegistration.saveMember(member);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado!", "Sucesso no registro");
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Problemas no registro");
            facesContext.addMessage(null, m);
        }
    }
    
    // 2018-01-20 : Rai
    public void delMember() throws Exception  {
		String resultado = "currMember é nulo";
		String clienteAtivoInativo;
        try {
			// --> Algumas maneiras de posicionar o registro
			//setCurrMember(memberRepository.findById(id));
			//setCurrMember(((Member) event.getObject()));
			//----- No caso o registro está sendo posicionado pelo DataTable da PrimeFaces	
			if (currMember != null) {
				Long id = currMember.getId();
				resultado = "Id: " + id.toString() + " : " + currMember.getName();
		        //memberRegistration.deleteMember(currMember);
				currMember.setMemberActive(!currMember.isMemberActive());;
	            memberRegistration.saveMember(currMember);
			}
			clienteAtivoInativo = currMember.isMemberActive() ? "Cliente ativado" : "Cliente inativado";
			FacesMessage msg = new FacesMessage(clienteAtivoInativo, resultado);
			facesContext.addMessage(null, msg);    	
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Problemas no registro");
            facesContext.addMessage(null, m);
        }
    }
    

    // 2018-01-20 : Rai
    public TypeMember[] getTypesMember() {
        return TypeMember.values();
    }
    

    // 2018-01-20 : Rai
    public Member getCurrMember() {
    		return currMember;
    }
    public void setCurrMember(Member member) {
    		this.currMember = member;
    }   

    // 2018-01-20 : Rai
    public void onRowEdit(RowEditEvent event) {    		
    		String resultado = "currMember é nulo";
    		
    		// --> Algumas maneiras de posicionar o registro
    		//setCurrMember(memberRepository.findById(id));
    		//setCurrMember(((Member) event.getObject()));
    		//----- No caso o registro está sendo posicionado pelo DataTable da PrimeFaces

    		if (currMember != null) {
        		Long id = ((Member) event.getObject()).getId();
    			resultado = "Id: " + id.toString() + " : " + currMember.getName();        		
    	        memberRegistration.saveMember(currMember);
    		}
        FacesMessage msg = new FacesMessage("Cliente alterado", resultado);
        facesContext.addMessage(null, msg);
    }
     
    // 2018-01-20 : Rai
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Alteração cancelada", ((Member) event.getObject()).getId().toString());
        facesContext.addMessage(null, msg);
    }    
}
