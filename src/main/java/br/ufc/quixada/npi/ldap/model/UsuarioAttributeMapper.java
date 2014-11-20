package br.ufc.quixada.npi.ldap.model;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import static br.ufc.quixada.npi.ldap.model.Constants.*;

import org.springframework.ldap.core.AttributesMapper;

public class UsuarioAttributeMapper implements AttributesMapper<Usuario>{
	
	public Usuario mapFromAttributes(Attributes attributes) throws NamingException {
        Usuario person = new Usuario();
        
        if(attributes.get(NOME_USUARIO_LDAP) != null) {
        	person.setNome((String)attributes.get(NOME_USUARIO_LDAP).get());
        }
        
        if(attributes.get(EMAIL_USUARIO_LDAP) != null) {
        	person.setEmail((String)attributes.get(EMAIL_USUARIO_LDAP).get());
        }
        
        if(attributes.get(MATRICULA_USUARIO_LDAP) != null) {
        	person.setMatricula((String)attributes.get(MATRICULA_USUARIO_LDAP).get());
        }
        
        if(attributes.get(CPF_USUARIO_LDAP) != null) {
        	person.setCpf((String)attributes.get(CPF_USUARIO_LDAP).get());
        }
        
        if(attributes.get(SIAPE_USUARIO_LDAP) != null) {
        	person.setSiape((String)attributes.get(SIAPE_USUARIO_LDAP).get());
        }
        
        if(attributes.get(CELULAR_USUARIO_LDAP) != null) {
        	person.setCelular((String)attributes.get(CELULAR_USUARIO_LDAP).get());
        }
        
        return person;
    }

}
