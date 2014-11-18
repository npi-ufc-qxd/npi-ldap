package br.ufc.quixada.npi.ldap.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.npi.ldap.dao.UsuarioDao;
import br.ufc.quixada.npi.ldap.model.Usuario;

@Named
public class UsuarioServiceImpl implements UsuarioService {
	
	@Inject
	private UsuarioDao usuarioDao;

	@Override
	public Usuario getUsuarioByCpf(String cpf) {
		List<Usuario> usuarios = usuarioDao.getUsuarioByCpf(cpf);
		if (usuarios != null && !usuarios.isEmpty()) {
			Usuario user = usuarios.get(0);
			user.setAuthorities(usuarioDao.getAuthorities(cpf));
			return user;
		}
		return null;
	}

	@Override
	public boolean autentica(String matricula, String password) {
		return usuarioDao.autentica(matricula, password);
	}

	@Override
	public List<Usuario> getAll() {
		return usuarioDao.getAll();
	}

}
