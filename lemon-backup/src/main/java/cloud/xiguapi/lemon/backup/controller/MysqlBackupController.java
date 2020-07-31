package cloud.xiguapi.lemon.backup.controller;

import cloud.xiguapi.lemon.backup.bean.BackupDataSourceDTO;
import cloud.xiguapi.lemon.backup.bean.HttpResult;
import cloud.xiguapi.lemon.backup.constant.BackupConstants;
import cloud.xiguapi.lemon.backup.datasource.BackupDataSourceProperties;
import cloud.xiguapi.lemon.backup.service.MysqlBackupService;
import cloud.xiguapi.lemon.common.tool.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 大大大西西瓜皮🍉
 * @date 15:19 2020-07-31
 * description:
 */
@RestController
public class MysqlBackupController {

	private final MysqlBackupService mysqlBackupService;

	private final BackupDataSourceProperties properties;

	@Autowired
	public MysqlBackupController(MysqlBackupService mysqlBackupService, BackupDataSourceProperties properties) {
		this.mysqlBackupService = mysqlBackupService;
		this.properties = properties;
	}

	@GetMapping("/backup")
	public HttpResult backup() {
		String backupFolderName = BackupConstants.DEFAULT_BACKUP_NAME + "_" + (new SimpleDateFormat(BackupConstants.DATE_FORMAT)).format(new Date());
		return backup(backupFolderName);
	}

	private HttpResult backup(String backupFolderName) {
		String host = properties.getHost();
		String userName = properties.getUserName();
		String password = properties.getPassword();
		String database = properties.getDatabase();
		String backupFolderPath = BackupConstants.BACKUP_FOLDER + backupFolderName + File.separator;
		String fileName = BackupConstants.BACKUP_FILE_NAME;

		BackupDataSourceDTO dto = new BackupDataSourceDTO(host, userName, password, database, backupFolderPath);

		try {
			boolean success = mysqlBackupService.backup(dto, fileName);
			if (!success) {
				HttpResult.error("数据备份失败");
			}
		} catch (Exception e) {
			return HttpResult.error(500, e.getMessage());
		}
		return HttpResult.ok();
	}

	@GetMapping("/restore")
	public HttpResult restore(@RequestParam String name) {
		String host = properties.getHost();
		String userName = properties.getUserName();
		String password = properties.getPassword();
		String database = properties.getDatabase();
		String restoreFilePath = BackupConstants.RESTORE_FOLDER + name;

		BackupDataSourceDTO dto = new BackupDataSourceDTO(host, userName, password, database, restoreFilePath);

		try {
			mysqlBackupService.restore(dto);
		} catch (Exception e) {
			return HttpResult.error(500, e.getMessage());
		}
		return HttpResult.ok();
	}

	@GetMapping("/findRecords")
	public HttpResult findBackupRecords() {
		if (!new File(BackupConstants.DEFAULT_RESTORE_FILE).exists()) {
			// 初始默认备份文件
			backup(BackupConstants.DEFAULT_BACKUP_NAME);
		}
		List<Map<String, String>> backupRecords = new ArrayList<>();
		File restoreFolderFile = new File(BackupConstants.RESTORE_FOLDER);
		if (restoreFolderFile.exists()) {
			for (File file : Objects.requireNonNull(restoreFolderFile.listFiles())) {
				Map<String, String> backup = new HashMap<>();
				backup.put("name", file.getName());
				backup.put("title", file.getName());
				if (BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(file.getName())) {
					backup.put("title", "系统默认备份");
				}
				backupRecords.add(backup);
			}
		}
		// 排序，默认备份最前，然后按时间戳排序，新备份在前面
		backupRecords.sort((o1, o2) -> BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o1.get("name")) ? -1
				: BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o2.get("name")) ? 1 : o2.get("name").compareTo(o1.get("name")));
		return HttpResult.ok(backupRecords);
	}

	@GetMapping("/delete")
	public HttpResult deleteBackupRecord(@RequestParam String name) {
		if (BackupConstants.DEFAULT_BACKUP_NAME.equals(name)) {
			return HttpResult.error("系统默认备份无法删除!");
		}
		String restoreFilePath = BackupConstants.BACKUP_FOLDER + name;
		try {
			FileUtils.deleteFile(new File(restoreFilePath));
		} catch (Exception e) {
			return HttpResult.error(500, e.getMessage());
		}
		return HttpResult.ok();
	}
}
