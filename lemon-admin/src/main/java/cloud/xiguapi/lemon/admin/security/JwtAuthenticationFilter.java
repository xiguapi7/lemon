package cloud.xiguapi.lemon.admin.security;

import cloud.xiguapi.lemon.admin.tool.SecurityUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义JWT认证过滤器
 *
 * @author 大大大西西瓜皮🍉
 * @date 10:19 2020-07-31
 * description:
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 获取token，并检查登录状态
		SecurityUtils.checkAuthentication(request);
		chain.doFilter(request, response);
	}
}
