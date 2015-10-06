package br.ufc.quixada.npi.ldap.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	private String matricula;
	
	private String nome;
	
	private String cpf;
	
	private String email;
	
	private String password;
	
	private String siape;
	
	private String telefone;
	
	private Date nascimento;
	
	private String cargo;
	
	private String lotacao;
	
	private String classe;
	
	private List<Affiliation> affiliations;
	
	private List<Affiliation> authorities;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String celular) {
		this.telefone = celular;
	}

	public List<Affiliation> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Affiliation> authorities) {
		this.authorities = authorities;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public List<Affiliation> getAffiliations() {
		return affiliations;
	}

	public void setAffiliations(List<Affiliation> affiliations) {
		this.affiliations = affiliations;
		List<Affiliation> authorities = new ArrayList<Affiliation>();
		for(Affiliation affiliation : affiliations) {
			if(affiliation.getDataSaida() != null) {
	        	SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
				try {
					Date today = format.parse(format.format(new Date()));
					if(!affiliation.getDataSaida().before(today)) {
		        		authorities.add(affiliation);
		        	}
				} catch (ParseException e) {
				}
	        	
	        } else {
	        	authorities.add(affiliation);
	        }
		}
		this.authorities = authorities;
	}

	@Override
	public String getUsername() {
		return matricula;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	

}
