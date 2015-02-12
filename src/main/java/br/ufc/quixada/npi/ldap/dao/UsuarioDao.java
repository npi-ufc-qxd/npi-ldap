package br.ufc.quixada.npi.ldap.dao;

import java.util.List;

import br.ufc.quixada.npi.ldap.model.Affiliation;
import br.ufc.quixada.npi.ldap.model.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> getAll(String base);
	
	public List<Usuario> getByCpf(String base, String cpf);
	
	public List<Affiliation> getAffiliations(String base, String matricula);
	
	public boolean autentica(String base, String matricula, String password);
	
	public List<Usuario> getByAffiliation(String base, String affiliation);
	
}
