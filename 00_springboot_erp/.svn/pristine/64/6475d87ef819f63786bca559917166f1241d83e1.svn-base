package com.gxz.sys.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.gxz.sys.realm.UserRealm;
import org.apache.shiro.mgt.SecurityManager;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
@ConfigurationProperties(prefix="shiro.web")
public class ShiroConfig {
	private String[] ingoreUrls;  //放行的URL数组
	private String[]  logOuts;//登出的URL
	private String[] authUrls;//要认证的url
	private String loginUrl;//没有认证跳转的页面
	private String successUrl;//认证成功之后跳转的页面
	private String unauthorizedUrl;//如果没有授权时跳转的页面
	/**
	 * 创建凭证匹配器
	 */
	@Bean
	@ConfigurationProperties(prefix="shiro")
	public HashedCredentialsMatcher getHashedCredentialsMatcher() {
		return new HashedCredentialsMatcher();
	}
	/**
	 * 创建安全管理器    自定义realm需要加@Component纳入到容器管理
	
	 *  SecurityManager要引用shiro的包而不能使用jdk的包
	 */
	@Bean
	public SecurityManager getSecurityManager(UserRealm userRealm,HashedCredentialsMatcher credentialsMatcher) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//设置凭证匹配器
		userRealm.setCredentialsMatcher(credentialsMatcher);
		// 设置自定义realm
		securityManager.setRealm(userRealm);
		return securityManager;
	}
	/**
	 *  配置过滤器
	 */

	/**
	 * Shiro 的Web过滤器
	 */
	@Bean("shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// Shiro的核心安全接口，这个属性是必须的
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 过滤器配置
		Map<String, String> map = new HashMap<String, String>();
		// 登陆的接口放行
		for (String url : ingoreUrls) {
			map.put(url, "anon");
		}
		// 登出操作
		for (String url : logOuts) {
			map.put(url, "logout");
		}
		// 对所有用户认证
		for (String url : authUrls) {
			map.put(url, "authc");
		}
		// 要求登录时的链接
		shiroFilterFactoryBean.setLoginUrl(loginUrl);
		// 登陆成功的页面 可以不配置，在controller里面去跳转
		shiroFilterFactoryBean.setSuccessUrl(successUrl);
		// 错误页面，认证不通过跳转
		shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}
	/**
	 * //加入注解的使用，不加入这个注解不生效
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	/**
	 * 注册shiro的委托过滤器，相当于之前在web.xml里面配置的
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<DelegatingFilterProxy> delegatingFilterProxy() {
		FilterRegistrationBean<DelegatingFilterProxy> filterRegistrationBean = new FilterRegistrationBean<DelegatingFilterProxy>();
		DelegatingFilterProxy proxy = new DelegatingFilterProxy();
		proxy.setTargetFilterLifecycle(true);
		proxy.setTargetBeanName("shiroFilter");
		filterRegistrationBean.setFilter(proxy);
		return filterRegistrationBean;
	}
	  //这里是为了能在html页面引用shiro标签，上面两个函数必须添加，不然会报错
    @Bean(name = "shiroDialect")  
    public ShiroDialect shiroDialect(){  
        return new ShiroDialect();       
    } 

	public String[] getIngoreUrls() {
		return ingoreUrls;
	}

	public void setIngoreUrls(String[] ingoreUrls) {
		this.ingoreUrls = ingoreUrls;
	}

	public String[] getLogOuts() {
		return logOuts;
	}

	public void setLogOuts(String[] logOuts) {
		this.logOuts = logOuts;
	}

	public String[] getAuthUrls() {
		return authUrls;
	}

	public void setAuthUrls(String[] authUrls) {
		this.authUrls = authUrls;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}

	public String getUnauthorizedUrl() {
		return unauthorizedUrl;
	}

	public void setUnauthorizedUrl(String unauthorizedUrl) {
		this.unauthorizedUrl = unauthorizedUrl;
	}

}
