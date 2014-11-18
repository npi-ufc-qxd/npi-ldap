package br.ufc.quixada.npi.ldap.model;

public class Constants {
	
	/** Atributos do usu�rio no LDAP */
	
	public static final String NOME_USUARIO_LDAP = "cn";
	
	public static final String EMAIL_USUARIO_LDAP = "mail";
	
	public static final String MATRICULA_USUARIO_LDAP = "uid";
	
	public static final String CPF_USUARIO_LDAP = "brPersonCPF";
	
	public static final String SIAPE_USUARIO_LDAP = "siape";
	
	public static final String CELULAR_USUARIO_LDAP = "celular";
	
	public static final String AFILIA��O_USUARIO_LDAP = "brEduAffiliationType";
	
	
	/**  Configura��es do LDAP */
	
	public static final String BASE_USUARIOS_LDAP = "ou=people";
	
	/**  Mensagens */
	
	public static final String LOGIN_INVALIDO = "Usu�rio e/ou senha inv�lidos";
	

}
