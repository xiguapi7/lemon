package cloud.xiguapi.lemon.common.tool;

/**
 * String工具类
 *
 * @author 大大大西西瓜皮🍉
 * @date 17:25 2020-07-27
 * description:
 */
public class StringUtils {

	/**
	 * 判空操作
	 */
	public static boolean isBlank(String value) {
		return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
	}
}
