package br.ufc.quixada.npi.ldap.model;

public class Constants {
	
	/** Atributos do usuário no LDAP */
	
	public static final String NOME_USUARIO = "cn";
	
	public static final String EMAIL_USUARIO = "mail";
	
	public static final String UID_USUARIO = "uid";
	
	public static final String CPF_USUARIO = "brPersonCPF";
	
	public static final String SIAPE_USUARIO = "siape";
	
	public static final String TELEFONE_USUARIO = "telefone";
	
	public static final String CARGO_USUARIO = "cargo";
	
	public static final String CLASSE_USUARIO = "classe";
	
	public static final String LOTACAO_USUARIO = "lotacao";
	
	public static final String DATA_NASCIMENTO_USUARIO = "nascimento";
	
	public static final String AFILIACAO_NOME = "brEduAffiliationType";
	
	public static final String AFILIACAO_DATA_SAIDA = "brExitDate";
	
	public static final String AFILIACAO_DATA_ENTRADA = "brEntranceDate";
	
	public static final String FORMATO_DATA_NASCIMENTO = "dd/MM/yyyy";
	
	public static final String FORMATO_DATA_AFILIACAO = "yyyyMMdd";
	
	
	//public static final String BASE_USUARIOS_ENV = "java:comp/env/ldap/ou";
		
	
	/**  Mensagens */
	
	public static final String LOGIN_INVALIDO = "Usuário e/ou senha inválidos";
	
	/** Afiliações */

	public static final String AFFILIATION_DISCENTE = "DISCENTE";
	
	public static final String AFFILIATION_DOCENTE = "DOCENTE";
	
	public static final String AFFILIATION_ADMIN_SIAF = "ADMIN-SIAF";
	
	public static final String AFFILIATION_STA = "STA";

}
