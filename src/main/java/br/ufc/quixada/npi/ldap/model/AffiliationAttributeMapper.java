package br.ufc.quixada.npi.ldap.model;

import static br.ufc.quixada.npi.ldap.model.Constants.AFILIACAO_DATA_ENTRADA;
import static br.ufc.quixada.npi.ldap.model.Constants.AFILIACAO_DATA_SAIDA;
import static br.ufc.quixada.npi.ldap.model.Constants.AFILIACAO_NOME;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.ContextMapper;
import org.springframework.ldap.core.DirContextAdapter;

public class AffiliationAttributeMapper implements ContextMapper<Affiliation> {
	
	@Override
	public Affiliation mapFromContext(Object ctx) throws NamingException {
		Affiliation affiliation = new Affiliation();
		
		DirContextAdapter context = (DirContextAdapter)ctx;
		String dn = context.getDn().toString();
		affiliation.setDn(dn);
		
		Attributes attributes = context.getAttributes();
        
        if(attributes.get(AFILIACAO_DATA_ENTRADA) != null) {
        	SimpleDateFormat format = new SimpleDateFormat(Constants.FORMATO_DATA_AFILIACAO);
			try {
				Date entrada = (Date) format.parse((String) attributes.get(AFILIACAO_DATA_ENTRADA).get());
				affiliation.setDataEntrada(entrada);
			} catch (ParseException e) {
			}
        	
        }
        
        if(attributes.get(AFILIACAO_DATA_SAIDA) != null) {
        	SimpleDateFormat format = new SimpleDateFormat(Constants.FORMATO_DATA_AFILIACAO);
			try {
				Date saida = (Date) format.parse((String) attributes.get(AFILIACAO_DATA_SAIDA).get());
				affiliation.setDataSaida(saida);
			} catch (ParseException e) {
			}
        	
        }
        
        if(attributes.get(AFILIACAO_NOME) != null) {
        	affiliation.setNome(((String) attributes.get(AFILIACAO_NOME).get()).toUpperCase());
        }
        
		return affiliation;
    }

}
