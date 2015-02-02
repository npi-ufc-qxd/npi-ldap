package br.ufc.quixada.npi.ldap.dao;

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
	public List<Usuario> getAll(String base) {
		return ldapTemplate.search(base, "(objectclass=person)", new UsuarioAttributeMapper());
	}

	@Override
	public List<Usuario> getUsuarioByUid(String base, String uid) {
		AndFilter andFilter = new AndFilter();
	    andFilter.and(new EqualsFilter("objectclass","person"));
	    andFilter.and(new EqualsFilter(MATRICULA_USUARIO_LDAP,uid));
	    return ldapTemplate.search(base, andFilter.encode(), new UsuarioAttributeMapper());
	}

	@Override
	public List<Role> getAuthorities(String base, String uid) {
		return ldapTemplate.search(MATRICULA_USUARIO_LDAP + "=" + uid + "," + base, "(objectclass=brEduPerson)", new RoleAttributeMapper());
		
	}

	@Override
	public boolean autentica(String base, String uid, String password) {
		LdapQuery query = query().base(base).where("objectclass").is("person").and(MATRICULA_USUARIO_LDAP).is(uid);
		return ldapTemplate.authenticate(base, query.filter().encode(), password);
	}

}
