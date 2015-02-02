package br.ufc.quixada.npi.ldap.service;

import java.util.List;

import br.ufc.quixada.npi.ldap.model.Usuario;

public interface UsuarioService {
	
	public Usuario getUsuarioByCpf(String base, String cpf);
	
	public boolean autentica(String base, String cpf, String password);
	
	public List<Usuario> getAll(String base);

}
