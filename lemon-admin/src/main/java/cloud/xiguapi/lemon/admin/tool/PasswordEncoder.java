package cloud.xiguapi.lemon.admin.tool;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author 大大大西西瓜皮🍉
 * @date 11:28 2020-07-31
 * description:
 */
public class PasswordEncoder {

	private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f"};

	private final static String MD5 = "MD5";

	private final Object salt;
	private final String algorithm;

	public PasswordEncoder(Object salt) {
		this(salt, MD5);
	}

	public PasswordEncoder(Object salt, String algorithm) {
		this.salt = salt;
		this.algorithm = algorithm;
	}

	/**
	 * 密码加密
	 */
	public String encode(String rawPass) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			// 加密后的字符串
			result = byteArrayToHexString(md.digest(mergePasswordAndSalt(rawPass).getBytes(StandardCharsets.UTF_8)));
		} catch (Exception ignored) {
		}
		return result;
	}

	/**
	 * 密码匹配验证
	 *
	 * @param encPass 密文
	 * @param rawPass 明文
	 */
	public boolean matches(String encPass, String rawPass) {
		String pass1 = "" + encPass;
		String pass2 = encode(rawPass);

		return pass1.equals(pass2);
	}

	private String mergePasswordAndSalt(String password) {
		if (password == null) {
			password = "";
		}

		if ((salt == null) || "".equals(salt)) {
			return password;
		} else {
			return password + "{" + salt.toString() + "}";
		}
	}

	/**
	 * 转换字节数组为16进制字串
	 *
	 * @param b 字节数组
	 * @return 16进制字串
	 */
	private String byteArrayToHexString(byte[] b) {
		StringBuilder resultSb = new StringBuilder();
		for (byte value : b) {
			resultSb.append(byteToHexString(value));
		}
		return resultSb.toString();
	}

	/**
	 * 将字节转换为16进制
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
}
