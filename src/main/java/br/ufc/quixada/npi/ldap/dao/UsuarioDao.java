package br.ufc.quixada.npi.ldap.dao;

import java.util.List;

import br.ufc.quixada.npi.ldap.model.Role;
import br.ufc.quixada.npi.ldap.model.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> getAll();
	
	public List<Usuario> getUsuarioByCpf(String cpf);
	
	public List<Role> getAuthorities(String cpf);
	
	public boolean autentica(String cpf, String password);

}
