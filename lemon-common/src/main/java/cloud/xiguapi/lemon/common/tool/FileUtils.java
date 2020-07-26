package cloud.xiguapi.lemon.common.tool;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件操作工具类
 *
 * @author 大大大西西瓜皮🍉
 * @date 20:12 2020-07-26
 * description:
 */
public class FileUtils {

	/**
	 * 下载文件
	 *
	 * @param resp     HTTP响应对象
	 * @param file     源文件
	 * @param fileName 文件名
	 */
	public static void downloadFile(HttpServletResponse resp, File file, String fileName) {
		try {
			resp.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("ISO-8859-1"), "UTF-8"));

			BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
			InputStream is = new FileInputStream(file.getAbsolutePath());
			BufferedInputStream bis = new BufferedInputStream(is);

			int length = 0;
			byte[] temp = new byte[1 * 1024 * 10];

			while ((length = bis.read()) != -1) {
				bos.write(temp, 0, length);
			}

			bos.flush();
			bis.close();
			bos.close();
			is.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
