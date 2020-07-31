package cloud.xiguapi.lemon.backup.service;

import cloud.xiguapi.lemon.backup.bean.BackupDataSourceDTO;

/**
 * MySQL备份服务接口
 * <p>
 * author 大大大西西瓜皮🍉
 * date 13:40 2020-07-31
 * description:
 */
public interface MysqlBackupService {

	/**
	 * 备份
	 *
	 * @param dto      备份数据源DTO对象
	 * @param fileName 备份文件的文件名
	 * @return 是否成功备份
	 */
	boolean backup(BackupDataSourceDTO dto, String fileName);


	/**
	 * 还原
	 *
	 * @param dto 备份数据源DTO对象
	 * @return 是否成功还原
	 */
	boolean restore(BackupDataSourceDTO dto);
}
