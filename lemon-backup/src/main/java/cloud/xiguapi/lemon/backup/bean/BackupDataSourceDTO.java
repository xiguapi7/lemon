package cloud.xiguapi.lemon.backup.bean;

/**
 * 备份数据源DTO对象
 *
 * @author 大大大西西瓜皮🍉
 * @date 13:42 2020-07-31
 * description:
 */
public class BackupDataSourceDTO {

	private String host;

	private String username;

	private String password;

	/**
	 * 备份或还原的数据库名称
	 */
	private String database;

	/**
	 * 文件恢复或文件备份的路径
	 */
	private String path;

	public BackupDataSourceDTO() {
	}

	public BackupDataSourceDTO(String host, String username, String password, String database, String path) {
		this.host = host;
		this.username = username;
		this.password = password;
		this.database = database;
		this.path = path;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
