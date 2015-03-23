package br.ufc.quixada.npi.ldap.dao;

import java.util.List;

import br.ufc.quixada.npi.ldap.model.Affiliation;
import br.ufc.quixada.npi.ldap.model.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> getAll();
	
	public List<Usuario> getByCpf(String cpf);
	
	public List<Affiliation> getAffiliations(String matricula);
	
	public boolean autentica(String matricula, String password);
	
	public List<Usuario> getByAffiliation(String affiliation);
	
}
