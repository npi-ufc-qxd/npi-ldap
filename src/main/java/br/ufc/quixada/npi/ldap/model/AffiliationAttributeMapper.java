package br.ufc.quixada.npi.ldap.model;

import static br.ufc.quixada.npi.ldap.model.Constants.AFFILIATION_ADMIN_SIAF;
import static br.ufc.quixada.npi.ldap.model.Constants.AFFILIATION_DISCENTE;
import static br.ufc.quixada.npi.ldap.model.Constants.AFFILIATION_DOCENTE;
import static br.ufc.quixada.npi.ldap.model.Constants.AFFILIATION_STA;
import static br.ufc.quixada.npi.ldap.model.Constants.AFILIACAO_DATA_ENTRADA;
import static br.ufc.quixada.npi.ldap.model.Constants.AFILIACAO_DATA_SAIDA;
import static br.ufc.quixada.npi.ldap.model.Constants.AFILIACAO_NOME;
import static br.ufc.quixada.npi.ldap.model.Constants.AFFILIATION_BIBLIOTECARIO;
import static br.ufc.quixada.npi.ldap.model.Constants.AFFILIATION_COORDENADOR_CURSO;

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
        
        String afiliacao = ((String) attributes.get(AFILIACAO_NOME).get()).toUpperCase();
			if(AFFILIATION_DISCENTE.equals(afiliacao)) {
				affiliation.setNome("ROLE_DISCENTE");
				return affiliation;
			}
			if(AFFILIATION_DOCENTE.equals(afiliacao)) {
				affiliation.setNome("ROLE_DOCENTE");
				return affiliation;
			}
			if(AFFILIATION_ADMIN_SIAF.equals(afiliacao)) {
				affiliation.setNome("ROLE_ADMIN_SIAF");
				return affiliation;
			}
			if(AFFILIATION_STA.equals(afiliacao)) {
				affiliation.setNome("ROLE_STA");
				return affiliation;
			}		
			if(AFFILIATION_BIBLIOTECARIO.equals(afiliacao)) {
				affiliation.setNome("ROLE_BIBLIOTECARIO");
				return affiliation;
			}		
			if(AFFILIATION_COORDENADOR_CURSO.equals(afiliacao)) {
				affiliation.setNome("ROLE_COORDENADOR_CURSO");
				return affiliation;
			}		
			
			affiliation.setNome(afiliacao);
			return affiliation;
    }

}
