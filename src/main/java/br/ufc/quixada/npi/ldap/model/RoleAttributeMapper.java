package br.ufc.quixada.npi.ldap.model;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

import static br.ufc.quixada.npi.ldap.model.Constants.*;

public class RoleAttributeMapper implements AttributesMapper<Role> {
	
	@Override
	public Role mapFromAttributes(Attributes attributes) throws NamingException {
        String name = (String) attributes.get(AFILIAÇÃO_USUARIO_LDAP).get();
        return new Role(name);
    }

}
