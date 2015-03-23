package br.ufc.quixada.npi.ldap.service;

import java.util.List;

import br.ufc.quixada.npi.ldap.model.Usuario;

public interface UsuarioService {
	
	public Usuario getByCpf(String cpf);
	
	public boolean autentica(String cpf, String password);
	
	public List<Usuario> getAll();
	
	public List<Usuario> getByAffiliation(String affiliation);

}
