package cloud.xiguapi.lemon.common.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间工具类
 *
 * @author 大大大西西瓜皮🍉
 * @date 17:21 2020-07-27
 * description:
 */
public class DateTimeUtils {

	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 获取当前标准格式化日期时间
	 */
	public static String getDateTime() {
		return getDateTime(new Date());
	}

	/**
	 * 标准格式化日期时间
	 */
	public static String getDateTime(Date date) {
		return (new SimpleDateFormat(DATE_FORMAT)).format(date);
	}
}
