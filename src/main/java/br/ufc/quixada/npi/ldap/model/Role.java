package br.ufc.quixada.npi.ldap.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	
	public Role() {
		
	}
	
	public Role(String nome) {
		this.nome = nome;
	}
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return this.nome;
	}
	
	

}
