package br.ufc.quixada.npi.ldap.model;

public class Constants {
	
	/** Atributos do usuário no LDAP */
	
	public static final String NOME_USUARIO_LDAP = "cn";
	
	public static final String EMAIL_USUARIO_LDAP = "mail";
	
	public static final String MATRICULA_USUARIO_LDAP = "uid";
	
	public static final String CPF_USUARIO_LDAP = "brPersonCPF";
	
	public static final String SIAPE_USUARIO_LDAP = "siape";
	
	public static final String CELULAR_USUARIO_LDAP = "celular";
	
	public static final String AFILIACAO_TYPE = "brEduAffiliationType";
	
	public static final String AFILIACAO_EXIT_DATE = "brExitDate";
	
	
	/**  Configurações do LDAP */
	
	public static final String BASE_USUARIOS = "ou=people";
	
	public static final String BASE_USUARIOS_TESTE = "ou=people_teste";
	
	/**  Mensagens */
	
	public static final String LOGIN_INVALIDO = "Usuário e/ou senha inválidos";
	
	/** Roles */

	public static final String ROLE_ALUNO = "DISCENTE";
	
	public static final String ROLE_PROFESSOR = "DOCENTE";
	
	public static final String ROLE_ADMIN_SIAF = "ADMIN-SIAF";

}
