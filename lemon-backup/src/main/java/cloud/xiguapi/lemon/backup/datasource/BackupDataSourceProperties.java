package cloud.xiguapi.lemon.backup.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 数据源
 *
 * @author 大大大西西瓜皮🍉
 * @date 13:38 2020-07-31
 * description:
 */
@Component
@ConfigurationProperties(prefix = "lemon.backup.datasource")
public class BackupDataSourceProperties {

	private String host;
	private String userName;
	private String password;
	private String database;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
}
