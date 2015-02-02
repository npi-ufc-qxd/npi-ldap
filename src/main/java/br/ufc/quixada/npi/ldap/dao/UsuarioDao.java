package br.ufc.quixada.npi.ldap.dao;

import java.util.List;

import br.ufc.quixada.npi.ldap.model.Role;
import br.ufc.quixada.npi.ldap.model.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> getAll(String base);
	
	public List<Usuario> getUsuarioByUid(String base, String uid);
	
	public List<Role> getAuthorities(String base, String uid);
	
	public boolean autentica(String base, String uid, String password);
	
}
