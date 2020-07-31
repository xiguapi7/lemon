package cloud.xiguapi.lemon.admin.config;

import cloud.xiguapi.lemon.admin.security.JwtAuthenticationFilter;
import cloud.xiguapi.lemon.admin.security.JwtAuthenticationProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

/**
 * Security配置
 *
 * @author 大大大西西瓜皮🍉
 * @date 09:56 2020-07-31
 * description:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Qualifier("userDetailsServiceImpl")
	private UserDetailsService service;

	@Override
	public void configure(AuthenticationManagerBuilder auth) {
		// 使用自定义身份验证组件
		auth.authenticationProvider(new JwtAuthenticationProvider(service));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
		http.cors().and().csrf().disable()
				.authorizeRequests()
				// 跨域预检请求
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				// web jars
				.antMatchers("/webjars/**").permitAll()
				// 查看SQL监控（druid）
				.antMatchers("/druid/**").permitAll()
				// 首页和登录页面
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				// swagger
				.antMatchers("/swagger-ui.html").permitAll()
				.antMatchers("/swagger-resources/**").permitAll()
				.antMatchers("/v2/api-docs").permitAll()
				.antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
				// 验证码
				.antMatchers("/captcha.jpg**").permitAll()
				// 服务监控
				.antMatchers("/actuator/**").permitAll()
				// 其他所有请求需要身份认证
				.anyRequest().authenticated();
		// 退出登录处理器
		http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
		// token验证过滤器
		http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
