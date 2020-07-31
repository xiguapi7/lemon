package cloud.xiguapi.lemon.admin.controller;

import cloud.xiguapi.lemon.admin.model.SysUser;
import cloud.xiguapi.lemon.admin.security.JwtAuthenticationToken;
import cloud.xiguapi.lemon.admin.service.SysUserService;
import cloud.xiguapi.lemon.admin.tool.PasswordUtils;
import cloud.xiguapi.lemon.admin.tool.SecurityUtils;
import cloud.xiguapi.lemon.admin.vo.LoginBean;
import cloud.xiguapi.lemon.common.tool.IOUtils;
import cloud.xiguapi.lemon.core.http.HttpResult;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author 大大大西西瓜皮🍉
 * @date 09:31 2020-07-31
 * description:
 */
@RestController
public class SysLoginController {

	private final Producer producer;

	private final SysUserService sysUserService;

	private final AuthenticationManager authenticationManager;

	@Autowired
	public SysLoginController(Producer producer, SysUserService sysUserService, AuthenticationManager authenticationManager) {
		this.producer = producer;
		this.sysUserService = sysUserService;
		this.authenticationManager = authenticationManager;
	}


	@GetMapping("captcha.jpg")
	public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		// 生成文字验证码
		String text = producer.createText();
		// 生成图片验证码
		BufferedImage image = producer.createImage(text);
		// 保存到验证码到 session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		IOUtils.closeQuietly(out);
	}

	/**
	 * 登录接口
	 */
	@PostMapping(value = "/login")
	public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) {
		String username = loginBean.getAccount();
		String password = loginBean.getPassword();
		String captcha = loginBean.getCaptcha();
		// 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
		Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (kaptcha == null) {
			return HttpResult.error("验证码已失效");
		}
		if (!captcha.equals(kaptcha)) {
			return HttpResult.error("验证码不正确");
		}
		// 用户信息
		SysUser user = sysUserService.findByName(username);
		// 账号不存在、密码错误
		if (user == null) {
			return HttpResult.error("账号不存在");
		}
		if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
			return HttpResult.error("密码不正确");
		}
		// 账号锁定
		if (user.getStatus() == 0) {
			return HttpResult.error("账号已被锁定,请联系管理员");
		}
		// 系统登录认证
		JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);
		return HttpResult.ok(token);
	}
}
