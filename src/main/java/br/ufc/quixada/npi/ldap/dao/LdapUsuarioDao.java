package br.ufc.quixada.npi.ldap.dao;

import static br.ufc.quixada.npi.ldap.model.Constants.BASE_USUARIOS_LDAP;
import static br.ufc.quixada.npi.ldap.model.Constants.MATRICULA_USUARIO_LDAP;
import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQuery;

import br.ufc.quixada.npi.ldap.model.Role;
import br.ufc.quixada.npi.ldap.model.RoleAttributeMapper;
import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.model.UsuarioAttributeMapper;

@Named
public class LdapUsuarioDao implements UsuarioDao {
	
	@Inject
	private LdapTemplate ldapTemplate;
	
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	@Override
	public List<Usuario> getAll() {
		return ldapTemplate.search(BASE_USUARIOS_LDAP, "(objectclass=person)", new UsuarioAttributeMapper());
	}

	@Override
	public List<Usuario> getUsuarioByCpf(String matricula) {
		AndFilter andFilter = new AndFilter();
	    andFilter.and(new EqualsFilter("objectclass","person"));
	    andFilter.and(new EqualsFilter(MATRICULA_USUARIO_LDAP,matricula));
	    return ldapTemplate.search("", andFilter.encode(), new UsuarioAttributeMapper());
	}

	@Override
	public List<Role> getAuthorities(String matricula) {
		return ldapTemplate.search(MATRICULA_USUARIO_LDAP + "=" + matricula + "," + BASE_USUARIOS_LDAP, "(objectclass=brEduPerson)", new RoleAttributeMapper());
		
	}

	@Override
	public boolean autentica(String matricula, String password) {
		LdapQuery query = query().base(BASE_USUARIOS_LDAP).where("objectclass").is("person").and(MATRICULA_USUARIO_LDAP).is(matricula);
		return ldapTemplate.authenticate(BASE_USUARIOS_LDAP, query.filter().encode(), password);
	}

}
