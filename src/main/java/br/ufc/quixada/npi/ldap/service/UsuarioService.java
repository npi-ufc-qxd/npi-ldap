package br.ufc.quixada.npi.ldap.service;

import java.util.List;

import br.ufc.quixada.npi.ldap.model.Usuario;

public interface UsuarioService {
	
	public Usuario getUsuarioByCpf(String cpf);
	
	public boolean autentica(String cpf, String password);
	
	public List<Usuario> getAll();

}
