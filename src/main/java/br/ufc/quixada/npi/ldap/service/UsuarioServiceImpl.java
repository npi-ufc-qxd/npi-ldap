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
	public Usuario getByCpf(String base, String cpf) {
		List<Usuario> usuarios = usuarioDao.getByCpf(base, cpf);
		if (usuarios != null && !usuarios.isEmpty()) {
			Usuario user = usuarios.get(0);
			user.setAffiliations(usuarioDao.getAffiliations(base, cpf));
			return user;
		}
		return null;
	}

	@Override
	public boolean autentica(String base, String matricula, String password) {
		return usuarioDao.autentica(base, matricula, password);
	}

	@Override
	public List<Usuario> getAll(String base) {
		return usuarioDao.getAll(base);
	}

	@Override
	public List<Usuario> getByAffiliation(String base, String affiliation) {
		return usuarioDao.getByAffiliation(base, affiliation);
	}

}
