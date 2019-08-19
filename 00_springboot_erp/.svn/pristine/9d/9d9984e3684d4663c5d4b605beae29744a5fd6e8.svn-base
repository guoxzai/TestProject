package com.gxz.sys.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
@ConditionalOnClass({ DruidDataSource.class })
@ConfigurationProperties(prefix = "spring.druid.web")
public class DruidConfig {

	private String loginUsername; // 登陆名
	private String loginPassword; // 密码
	private String allow; // 白名单
	private String deny; // 黑名单
	private String druidRegistrationUrl; // 请求地址
	private String exclusions; // 过滤器的过滤规则
	private String filtersUrlPatterns; // url

	/**
	 * 创建DruidDataSource对象并设置其它属性
	 **/
	@Bean(initMethod = "init")
	@ConfigurationProperties(prefix = "spring.datasource.druid")
	public DruidDataSource getDrudiDataSource() {
		return new DruidDataSource();
	}

	/**
	 * 配置监控页面 注册StatViewServlet
	 */
	@Bean
	public ServletRegistrationBean<StatViewServlet> getStatViewServlet() {
		// 创建Servlet的对象
		StatViewServlet servlet = new StatViewServlet();
		// 创建注册器
		ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>();
		// 注册
		registrationBean.setServlet(servlet);
		// 设置其它参数
		registrationBean.addInitParameter("loginUsername", loginUsername);
		registrationBean.addInitParameter("loginPassword", loginPassword);
		registrationBean.addInitParameter("allow", allow);//
		registrationBean.addInitParameter("deny", deny);
		registrationBean.addUrlMappings(druidRegistrationUrl);
		registrationBean.setLoadOnStartup(-1);
		return registrationBean;
	}

	/**
	 * 注册过滤器WebStatFilter
	 */
	@Bean
	public FilterRegistrationBean<WebStatFilter> getWebStatFilter() {
		WebStatFilter statFilter = new WebStatFilter();
		FilterRegistrationBean<WebStatFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(statFilter);
		registrationBean.addInitParameter("exclusions", exclusions);
		Collection<String> urlPatterns = new ArrayList<>();
		urlPatterns.add(filtersUrlPatterns);
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getAllow() {
		return allow;
	}

	public void setAllow(String allow) {
		this.allow = allow;
	}

	public String getDeny() {
		return deny;
	}

	public void setDeny(String deny) {
		this.deny = deny;
	}

	public String getDruidRegistrationUrl() {
		return druidRegistrationUrl;
	}

	public void setDruidRegistrationUrl(String druidRegistrationUrl) {
		this.druidRegistrationUrl = druidRegistrationUrl;
	}

	public String getExclusions() {
		return exclusions;
	}

	public void setExclusions(String exclusions) {
		this.exclusions = exclusions;
	}

	public String getFiltersUrlPatterns() {
		return filtersUrlPatterns;
	}

	public void setFiltersUrlPatterns(String filtersUrlPatterns) {
		this.filtersUrlPatterns = filtersUrlPatterns;
	}

}
