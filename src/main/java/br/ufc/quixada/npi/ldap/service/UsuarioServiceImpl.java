]package br.ufc.quixada.npi.ldap.service;

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
	public Usuario getByCpf(String cpf) {
		List<Usuario> usuarios = usuarioDao.getByCpf(cpf);
		if (usuarios != null && !usuarios.isEmpty()) {
			Usuario user = usuarios.get(0);
			user.setAffiliations(usuarioDao.getAffiliations(cpf));
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

	@Override
	public List<Usuario> getByAffiliation(String affiliation) {
		return usuarioDao.getByAffiliation(affiliation);
	}

	@Override
	public List<Usuario> getByCpfOrNome(String busca) {
		return usuarioDao.getByCpfOrNome(busca);
	}
	
	@Override
	public Usuario getByEmail(String email);
		List<Usuario> usuarios = usuarioDao.getByEmail(email);
		if (usuarios != null && !usuarios.isEmpty()) {
			Usuario user = usuarios.get(0);
			return user;
		}
		return null;
	}

}
