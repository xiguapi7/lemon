package cloud.xiguapi.lemon.common.tool;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO工具类
 *
 * @author 大大大西西瓜皮🍉
 * @date 17:23 2020-07-27
 * description:
 */
public class IOUtils {

	/**
	 * 关闭对象，连接
	 */
	public static void closeQuietly(final Closeable closeable) {
		try {
			if (closeable != null) {
				closeable.close();
			}
		} catch (final IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
