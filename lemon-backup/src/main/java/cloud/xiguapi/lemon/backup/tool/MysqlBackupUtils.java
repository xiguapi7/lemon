package cloud.xiguapi.lemon.backup.tool;

import cloud.xiguapi.lemon.backup.bean.BackupDataSourceDTO;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Mysql备份服务工具类
 *
 * @author 大大大西西瓜皮🍉
 * @date 13:50 2020-07-31
 * description:
 */
public class MysqlBackupUtils {

	public static boolean backup(BackupDataSourceDTO dto, String fileName) {

		String backupFolderPath = dto.getPath();

		File backupFolderFile = new File(backupFolderPath);

		if (!backupFolderFile.exists()) {
			// 如果目录不存在则创建
			backupFolderFile.mkdirs();
		}

		if (!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith("/")) {
			backupFolderPath = backupFolderPath + File.separator;
		}

		// 拼接命令行的命令
		String backupFilePath = backupFolderPath + fileName;
		StringBuilder sb = new StringBuilder();
		sb.append("mysqldump --opt")
				.append(" --add-drop-database")
				.append(" --add-drop-table")
				.append(" -h").append(dto.getHost())
				.append(" -u").append(dto.getUsername())
				.append(" -p").append(dto.getPassword())
				.append(" --result-file=").append(backupFilePath).append(" default-character-set=utf8")
				.append(" ").append(dto.getDatabase());

		try {
			Process process = Runtime.getRuntime().exec(getCommand(sb.toString()));
			if (process.waitFor() == 0) {
				System.out.println("数据已经备份到：" + backupFilePath + "文件中");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	private static String[] getCommand(String command) {
		String os = System.getProperty("os.name");
		String shell = "/bin/bash";
		String c = "-c";
		if (os.toLowerCase().startsWith("win")) {
			shell = "cmd";
			c = "/c";
		}
		return new String[]{shell, c, command};
	}


	public static boolean restore(BackupDataSourceDTO dto) {

		AtomicReference<String> restoreFilePath = new AtomicReference<>(dto.getPath());

		File restoreFile = new File(dto.getPath());

		if (restoreFile.isDirectory()) {
			Arrays.stream(Objects.requireNonNull(restoreFile.listFiles())).forEach(file -> {
				if (file.exists() && file.getPath().endsWith(".sql")) {
					restoreFilePath.set(file.getAbsolutePath());
				}
			});
		}

		StringBuilder sb = new StringBuilder();
		sb.append("mysql -h").append(dto.getHost())
				.append(" -u").append(dto.getUsername())
				.append(" -p").append(dto.getPassword())
				.append(" ").append(dto.getDatabase())
				.append("<").append(restoreFilePath);

		try {
			Process process = Runtime.getRuntime().exec(getCommand(sb.toString()));
			if (process.waitFor() == 0) {
				System.out.println("数据已从：" + restoreFile + "导入");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
