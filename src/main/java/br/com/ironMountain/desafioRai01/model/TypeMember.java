/*******
 * 2018-01-20
 * Autor:	Rai
 * Descr:	Enumeração para Tipos de Clientes
 * 
 */
package br.com.ironMountain.desafioRai01.model;

public enum TypeMember {
	FISICA("Física"), 
	JURIDICA("Jurídica");
	
	private String descricao;
	
	TypeMember(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
