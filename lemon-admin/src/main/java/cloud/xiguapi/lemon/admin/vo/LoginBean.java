package cloud.xiguapi.lemon.admin.vo;

/**
 * 登录接口对象封装
 *
 * @author 大大大西西瓜皮🍉
 * @date 12:36 2020-07-31
 * description:
 */
public class LoginBean {

	private String account;
	private String password;
	private String captcha;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}
