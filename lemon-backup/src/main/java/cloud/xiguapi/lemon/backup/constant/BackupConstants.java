package cloud.xiguapi.lemon.backup.constant;

import java.io.File;

/**
 * author 大大大西西瓜皮🍉
 * date 13:37 2020-07-31
 * description:
 */
public interface BackupConstants {

	/**
	 * 备份目录名称
	 */
	String BACKUP_FOLDER_NAME = "_lemon_backup";
	/**
	 * 备份目录
	 */
	String BACKUP_FOLDER = System.getProperty("user.home") + File.separator + BACKUP_FOLDER_NAME + File.separator;
	/**
	 * 还原目录，默认就是备份目录
	 */
	String RESTORE_FOLDER = BACKUP_FOLDER;
	/**
	 * 日期格式
	 */
	String DATE_FORMAT = "yyyy-MM-dd_HHmmss";
	/**
	 * SQL拓展名
	 */
	String SQL_EXT = ".sql";
	/**
	 * 默认备份文件名
	 */
	String BACKUP_FILE_NAME = "lemon" + SQL_EXT;
	/**
	 * 默认备份还原目录名称
	 */
	String DEFAULT_BACKUP_NAME = "backup";
	/**
	 * 默认备份还原文件
	 */
	String DEFAULT_RESTORE_FILE = BACKUP_FOLDER + DEFAULT_BACKUP_NAME + File.separator + BACKUP_FILE_NAME;

}
