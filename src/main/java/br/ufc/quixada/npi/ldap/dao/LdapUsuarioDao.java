package br.ufc.quixada.npi.ldap.dao;

import static br.ufc.quixada.npi.ldap.model.Constants.AFILIACAO_NOME;
import static br.ufc.quixada.npi.ldap.model.Constants.CPF_USUARIO;
import static br.ufc.quixada.npi.ldap.model.Constants.NOME_USUARIO;
import static br.ufc.quixada.npi.ldap.model.Constants.UID_USUARIO;
import static br.ufc.quixada.npi.ldap.model.Constants.EMAIL_USUARIO;
import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.stereotype.Component;

import br.ufc.quixada.npi.ldap.model.Affiliation;
import br.ufc.quixada.npi.ldap.model.AffiliationAttributeMapper;
import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.model.UsuarioAttributeMapper;

@Named
@Component
public class LdapUsuarioDao implements UsuarioDao {
	
	@Inject
	private LdapTemplate ldapTemplate;
	
	@Inject
	private String base;
	
	public void setBase(String base) {
		this.base = base;
	}
	
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	@Override
	public List<Usuario> getAll() {
		LdapQuery query = query().base(base).where("objectclass").is("person");
		return ldapTemplate.search(query, new UsuarioAttributeMapper());
	}

	@Override
	public boolean autentica(String matricula, String password) {
		LdapQuery query = query().base(base).where("objectclass").is("person").and(UID_USUARIO).is(matricula);
		return ldapTemplate.authenticate(base, query.filter().encode(), password);
	}

	@Override
	public List<Usuario> getByAffiliation(String affiliation) {
		LdapQuery query = query().base(base).where("objectclass").is("brEduPerson").and(AFILIACAO_NOME).is(affiliation);
		List<Affiliation> affiliations = ldapTemplate.search(query, new AffiliationAttributeMapper());
		List<Usuario> usuarios = new ArrayList<Usuario>();
		if(affiliations != null) {
			for(Affiliation aff : affiliations) {
				if(aff.getDn() != null && !aff.getDn().isEmpty()) {
					String cpf = aff.getDn().split(",")[1].split("=")[1];
					List<Usuario> result = getByCpf(cpf);
					if(result != null && !result.isEmpty()) {
						usuarios.add(result.get(0));
					}
				}
			}
		}
		return usuarios;
	}

	@Override
	public List<Usuario> getByCpf(String cpf) {
		LdapQuery query = query().base(base).where("objectclass").is("person").and(CPF_USUARIO).is(cpf);
	    return ldapTemplate.search(query, new UsuarioAttributeMapper());
	}

	@Override
	public List<Affiliation> getAffiliations(String cpf) {
		return ldapTemplate.search(UID_USUARIO + "=" + cpf + "," + base, "(objectclass=brEduPerson)", new AffiliationAttributeMapper());
	}

	@Override
	public List<Usuario> getByCpfOrNome(String busca) {
		LdapQuery query = query().base(base).where(CPF_USUARIO).is(busca).or(NOME_USUARIO).like("*"+busca+"*");
	    return ldapTemplate.search(query, new UsuarioAttributeMapper());
	}

	@Override
	public List<Usuario> getByEmail(String busca) {
		LdapQuery query = query().base(base).where(EMAIL_USUARIO).is(busca);
	    return ldapTemplate.search(query, new UsuarioAttributeMapper());
	}

}
