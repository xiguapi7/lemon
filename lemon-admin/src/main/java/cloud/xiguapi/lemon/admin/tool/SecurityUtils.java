package cloud.xiguapi.lemon.admin.tool;


import cloud.xiguapi.lemon.admin.security.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * Security工具类
 *
 * @author 大大大西西瓜皮🍉
 * @date 10:24 2020-07-31
 * description:
 */
public class SecurityUtils {

	/**
	 * 系统登录认证
	 */
	public static JwtAuthenticationToken login(HttpServletRequest request, String username, String password, AuthenticationManager authenticationManager) {
		JwtAuthenticationToken token = new JwtAuthenticationToken(username, password);
		token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		// 执行登录认证过程
		Authentication authentication = authenticationManager.authenticate(token);
		// 认证成功存储认证信息到上下文
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// 生成令牌并返回给客户端
		token.setToken(JwtTokenUtils.generateToken(authentication));
		return token;
	}

	/**
	 * 获取令牌进行认证
	 */
	public static void checkAuthentication(HttpServletRequest request) {
		// 获取令牌并根据令牌获取登录认证信息
		Authentication authentication = JwtTokenUtils.getAuthenticationeFromToken(request);
		// 设置登录认证信息到上下文
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	/**
	 * 获取当前用户名
	 */
	public static String getUsername() {
		String username = null;
		Authentication authentication = getAuthentication();
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			}
		}
		return username;
	}

	/**
	 * 获取用户名
	 */
	public static String getUsername(Authentication authentication) {
		String username = null;
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			}
		}
		return username;
	}

	/**
	 * 获取当前登录信息
	 */
	public static Authentication getAuthentication() {
		if (SecurityContextHolder.getContext() == null) {
			return null;
		}
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
