package cloud.xiguapi.lemon.common.tool;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * POI报表工具类
 *
 * @author 大大大西西瓜皮🍉
 * @date 20:09 2020-07-26
 * description:
 */
public class PoiUtils {

	/**
	 * 导出报表
	 *
	 * @param workbook 数据
	 * @param fileName 文件名
	 * @return 文件对象
	 */
	public static File createExcelFile(Workbook workbook, String fileName) {

		OutputStream os = null;
		File file = null;

		try {
			file = File.createTempFile(fileName, ".xlsx");
			os = new FileOutputStream(file.getAbsoluteFile());
			workbook.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(workbook);
			IOUtils.closeQuietly(os);
		}

		return file;
	}
}
