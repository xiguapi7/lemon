package cloud.xiguapi.lemon.backup.service.impl;

import cloud.xiguapi.lemon.backup.bean.BackupDataSourceDTO;
import cloud.xiguapi.lemon.backup.service.MysqlBackupService;
import cloud.xiguapi.lemon.backup.tool.MysqlBackupUtils;
import org.springframework.stereotype.Service;

/**
 * Mysql数据备份服务实现类
 *
 * @author 大大大西西瓜皮🍉
 * @date 13:47 2020-07-31
 * description:
 */
@Service
public class MysqlBackupServiceImpl implements MysqlBackupService {

	@Override
	public boolean backup(BackupDataSourceDTO dto, String fileName) {
		return MysqlBackupUtils.backup(dto, fileName);
	}

	@Override
	public boolean restore(BackupDataSourceDTO dto) {
		return MysqlBackupUtils.restore(dto);
	}
}
