package cloud.xiguapi.lemon.admin.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * MyBatis配置类
 *
 * @author 大大大西西瓜皮🍉
 * @date 00:39 2020-07-26
 * description:
 */
@Configuration
@MapperScan("cloud.xiguapi.lemon.admin.mapper")
public class MyBatisConfig {

	private final DataSource dataSource;

	@Autowired
	public MyBatisConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		// 扫描model
		bean.setTypeAliasesPackage("cloud.xiguapi.lemon.**.model");

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		// 扫描映射文件
		bean.setMapperLocations(resolver.getResources("classpath*:**/sqlmap/*.xml"));

		return bean.getObject();
	}
}
