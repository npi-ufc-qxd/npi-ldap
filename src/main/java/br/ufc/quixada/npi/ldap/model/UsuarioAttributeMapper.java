package br.ufc.quixada.npi.ldap.model;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import static br.ufc.quixada.npi.ldap.model.Constants.*;

import org.springframework.ldap.core.AttributesMapper;

public class UsuarioAttributeMapper implements AttributesMapper<Usuario>{
	
	public Usuario mapFromAttributes(Attributes attributes) throws NamingException {
        Usuario person = new Usuario();
        String name = (String) attributes.get(NOME_USUARIO_LDAP).get();
        if(name != null) {
        	person.setNome(name);
        }
        
        String mail = (String) attributes.get(EMAIL_USUARIO_LDAP).get();
        if(mail != null) {
        	person.setEmail(mail);
        }
        
        String matricula = (String) attributes.get(MATRICULA_USUARIO_LDAP).get();
        if(matricula != null) {
        	person.setMatricula(matricula);
        }
        
        String cpf = (String) attributes.get(CPF_USUARIO_LDAP).get();
        if(cpf != null) {
        	person.setCpf(cpf);
        }
        
        String siape = (String) attributes.get(SIAPE_USUARIO_LDAP).get();
        if(siape != null) {
        	person.setSiape(siape);
        }
        
        String celular = (String) attributes.get(CELULAR_USUARIO_LDAP).get();
        if(celular != null) {
        	person.setCelular(celular);
        }
        
        return person;
    }

}
