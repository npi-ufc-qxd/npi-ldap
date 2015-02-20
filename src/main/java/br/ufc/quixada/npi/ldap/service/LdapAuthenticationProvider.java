package br.ufc.quixada.npi.ldap.service;

import static br.ufc.quixada.npi.ldap.model.Constants.LOGIN_INVALIDO;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import br.ufc.quixada.npi.ldap.model.Constants;
import br.ufc.quixada.npi.ldap.model.Usuario;

@Named
public class LdapAuthenticationProvider implements AuthenticationProvider {
	
	@Inject
	private UsuarioService usuarioService;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String username = authentication.getName();
        String password = (String) authentication.getCredentials();
 
        Usuario user = usuarioService.getByCpf(Constants.BASE_USUARIOS, username);
 
        if (user == null || !usuarioService.autentica(Constants.BASE_USUARIOS, username, password) || user.getAuthorities().isEmpty()) {
            throw new BadCredentialsException(LOGIN_INVALIDO);
        }
 
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
 
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
