package com.sldg.erp.controller;

import static org.apache.shiro.SecurityUtils.getSubject;

import java.util.Set;

import javax.inject.Named;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.sldg.erp.model.User;
import com.sldg.erp.service.UsuarioService;

/**
 * @author Jorge Danilo Gomes
 */
@Named
public class SldgRealm extends AuthorizingRealm {

	private static final Object ROLES_SESSION_STRING = "@ROLES_STRING";

	private static final Object USER_SESSION = "@user";

	private static final String REALM_NAME = "SldgRealm";
	
//	@Inject
	private UsuarioService usuarioService = new UsuarioService();
	
	public SldgRealm() {
		this.setName(REALM_NAME);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(final PrincipalCollection principals) {
		if (principals != null)
			throw new AuthenticationException();
		SimpleAuthorizationInfo authorization = new SimpleAuthorizationInfo();
		authorization.setRoles((Set<String>) getSubject().getSession().getAttribute(ROLES_SESSION_STRING));
		return authorization;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(final AuthenticationToken token) throws AuthenticationException {
		final UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
		User usuario = null;
		System.out.println(passwordToken.getUsername());
		System.out.println(passwordToken.getPassword());
//		usuario = usuarioService.autenticar(passwordToken.getUsername(), new String(passwordToken.getPassword()));
		getSubject().getSession().setAttribute(USER_SESSION, usuario );
		return new SimpleAuthenticationInfo(usuario.getEmail(), passwordToken.getPassword(), REALM_NAME);
	}

}
