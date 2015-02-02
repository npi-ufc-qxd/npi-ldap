package br.ufc.quixada.npi.ldap.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

import static br.ufc.quixada.npi.ldap.model.Constants.*;

public class RoleAttributeMapper implements AttributesMapper<Role> {
	
	@Override
	public Role mapFromAttributes(Attributes attributes) throws NamingException {
        String afiliacao = ((String) attributes.get(AFILIACAO_TYPE).get()).toUpperCase();
        if(attributes.get(AFILIACAO_EXIT_DATE) != null) {
        	SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
			try {
				Date exitDate = (Date) format.parse((String) attributes.get(AFILIACAO_EXIT_DATE).get());
				Date today = format.parse(format.format(new Date()));
				if(exitDate.before(today)) {
	        		return new Role("");
	        	}
			} catch (ParseException e) {
				return new Role("");
			}
        	
        }
        
        switch (afiliacao) {
			case ROLE_ALUNO:
				return new Role("ROLE_DISCENTE");
			case ROLE_PROFESSOR:
				return new Role("ROLE_DOCENTE");
			case ROLE_ADMIN_SIAF:
				return new Role("ROLE_ADMIN_SIAF");
			default:
				return new Role(afiliacao);
		}
    }

}
