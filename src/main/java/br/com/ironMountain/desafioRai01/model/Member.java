/****
	==============================================================================================
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
package br.com.ironMountain.desafioRai01.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
// A constraint ou bean validation acima define que não podem haver emails repetidos
public class Member implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 25)
    // 2018-01-20 : Rai : message alterada para PT-Br
    @Pattern(regexp = "[^0-9]*", message = "Nao pode conter numeros")
    private String name;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 12)
    @Digits(fraction = 0, integer = 12)
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "tp_member")
    private TypeMember tpMember;

    @NotNull
    private boolean memberActive = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	public TypeMember getTpMember() {
		return tpMember;
	}

	public void setTpMember(TypeMember tpMember) {
		this.tpMember = tpMember;
	}

	public boolean isMemberActive() {
		return memberActive;
	}

	public void setMemberActive(boolean memberActive) {
		this.memberActive = memberActive;
	}
}
