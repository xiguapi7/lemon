package cloud.xiguapi.lemon.admin.tool;

import java.util.UUID;

/**
 * @author 大大大西西瓜皮🍉
 * @date 11:30 2020-07-31
 * description:
 */
public class PasswordUtils {

	/**
	 * 匹配密码
	 *
	 * @param salt    盐
	 * @param rawPass 明文
	 * @param encPass 密文
	 */
	public static boolean matches(String salt, String rawPass, String encPass) {
		return new PasswordEncoder(salt).matches(encPass, rawPass);
	}

	/**
	 * 明文密码加密
	 *
	 * @param rawPass 明文
	 */
	public static String encode(String rawPass, String salt) {
		return new PasswordEncoder(salt).encode(rawPass);
	}

	/**
	 * 获取加密盐
	 */
	public static String getSalt() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
	}
}
