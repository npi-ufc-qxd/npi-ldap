package br.ufc.quixada.npi.ldap.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import static br.ufc.quixada.npi.ldap.model.Constants.*;

import org.springframework.ldap.core.AttributesMapper;

public class UsuarioAttributeMapper implements AttributesMapper<Usuario>{
	
	public Usuario mapFromAttributes(Attributes attributes) throws NamingException {
        Usuario usuario = new Usuario();
        
        SimpleDateFormat format = new SimpleDateFormat(Constants.FORMATO_DATA_NASCIMENTO);
        
        if(attributes.get(NATURALIDADE_USUARIO) != null){
        	usuario.setNaturalidade((String) attributes.get(NATURALIDADE_USUARIO).get());
        }
        
        if(attributes.get(NACIONALIDADE_USUARIO) != null){
        	usuario.setNacionalidade((String) attributes.get(NACIONALIDADE_USUARIO).get());
        }
        
        if(attributes.get(UFNATURALIDADE_USUARIO) != null){
        	usuario.setUfNaturalidade((String) attributes.get(UFNATURALIDADE_USUARIO).get());
        }
        
        if(attributes.get(INGRESSO_USUARIO) != null){
        	usuario.setIngresso((String) attributes.get(INGRESSO_USUARIO).get());
        }
        
        if(attributes.get(CURSO_USUARIO) != null){
        	usuario.setCurso((String) attributes.get(CURSO_USUARIO).get());
        }
             
        if(attributes.get(SEXO_USUARIO) != null){
        	usuario.setSexo((String) attributes.get(SEXO_USUARIO).get());
        }
        
        if(attributes.get(ESTADO_CIVIL_USUARIO) != null){
        	usuario.setEstadoCivil((String) attributes.get(ESTADO_CIVIL_USUARIO).get());
        }
        
        if(attributes.get(RG_USUARIO) != null){
        	usuario.setRg((String) attributes.get(RG_USUARIO).get());
        }
        
        if(attributes.get(NOME_USUARIO) != null) {
        	usuario.setNome((String)attributes.get(NOME_USUARIO).get());
        }
        
        if(attributes.get(EMAIL_USUARIO) != null) {
        	usuario.setEmail((String)attributes.get(EMAIL_USUARIO).get());
        }
        
        if(attributes.get(CARGO_USUARIO) != null) {
        	usuario.setCargo((String)attributes.get(CARGO_USUARIO).get());
        }
        
        if(attributes.get(CLASSE_USUARIO) != null) {
        	usuario.setClasse((String)attributes.get(CLASSE_USUARIO).get());
        }
        
        if(attributes.get(LOTACAO_USUARIO) != null) {
        	usuario.setLotacao((String)attributes.get(LOTACAO_USUARIO).get());
        }
        
        if(attributes.get(MATRICULA) != null) {
        	usuario.setMatricula((String)attributes.get(MATRICULA).get());
        }
        
        if(attributes.get(CPF_USUARIO) != null) {
        	usuario.setCpf((String)attributes.get(CPF_USUARIO).get());
        }
        
        if(attributes.get(DATA_NASCIMENTO_USUARIO) != null) {
        	try {
				Date nascimento = (Date) format.parse((String) attributes.get(DATA_NASCIMENTO_USUARIO).get());
				usuario.setNascimento(nascimento);
			} catch (ParseException e) {
			}
        }
        
        if(attributes.get(SIAPE_USUARIO) != null) {
        	usuario.setSiape((String)attributes.get(SIAPE_USUARIO).get());
        }
        
        if(attributes.get(TELEFONE_USUARIO) != null) {
        	usuario.setTelefone((String)attributes.get(TELEFONE_USUARIO).get());
        }
        
        return usuario;
    }

}
