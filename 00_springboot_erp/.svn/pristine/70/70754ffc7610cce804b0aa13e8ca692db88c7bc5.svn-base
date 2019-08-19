package com.gxz.sys.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.aspectj.apache.bcel.util.ByteSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gxz.sys.constast.SYSConstast;
import com.gxz.sys.domain.User;
import com.gxz.sys.service.UserService;
import com.gxz.sys.utils.ActiverUser;

@Component
public class UserRealm extends AuthorizingRealm  {

	@Autowired
	private UserService userService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String loginname = token.getPrincipal().toString();
		String pwd =  token.getCredentials().toString();
		System.out.println(loginname+"-->"+pwd);
		User user = userService.queryUserByLoginname(loginname);
		if(null!=user) {
			ActiverUser activeUser = new ActiverUser();
			activeUser.setUser(user);
			
			if(user.getType()==SYSConstast.USER_TYPE_NORMAL) {
				//查询角色
				//查询权限
			}
			
			ByteSource byteSource = ByteSource.Util.bytes(user.getSalt());
			AuthenticationInfo AuthenticationInfo = new SimpleAuthenticationInfo(activeUser, user.getPwd(), byteSource, this.getClass().getSimpleName());
			return AuthenticationInfo;
		}else {
			return null;
		}
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ActiverUser user = (ActiverUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		if(user.getUser().getType()==SYSConstast.USER_TYPE_SUPER) {
			authorizationInfo.addStringPermission("*:*");
		}else {
			if(null!=user && !user.getRoles().isEmpty()) {
				authorizationInfo.addRoles(user.getRoles());
			}
			
			if(null!=user && !user.getPermissions().isEmpty()) {
				authorizationInfo.addStringPermissions(user.getPermissions());
			}
		}
		
		return authorizationInfo;
	}
}
