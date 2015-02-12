package br.ufc.quixada.npi.ldap.model;

import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

public class Affiliation implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	
	private Date dataEntrada;
	
	private Date dataSaida;
	
	private String nome;
	
	private String dn;
	
	public Affiliation() {
		
	}
	
	public Affiliation(String nome) {
		this.nome = nome;
	}

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

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getDn() {
		return dn;
	}

	public void setDn(String dn) {
		this.dn = dn;
	}

}
