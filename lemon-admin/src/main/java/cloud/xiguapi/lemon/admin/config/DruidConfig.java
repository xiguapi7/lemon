package cloud.xiguapi.lemon.admin.config;

import cloud.xiguapi.lemon.admin.properties.DruidDataSourceProperties;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Druid数据库连接池配置类
 *
 * @author 大大大西西瓜皮🍉
 * @date 01:39 2020-07-26
 * description:
 */
@Configuration
@EnableConfigurationProperties({DruidDataSourceProperties.class})
public class DruidConfig {

	private final DruidDataSourceProperties properties;

	@Autowired
	public DruidConfig(DruidDataSourceProperties properties) {
		this.properties = properties;
	}

	@Bean
	@ConditionalOnMissingBean
	public DataSource druidDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(properties.getDriverClassName());
		druidDataSource.setUrl(properties.getUrl());
		druidDataSource.setUsername(properties.getUsername());
		druidDataSource.setPassword(properties.getPassword());
		druidDataSource.setInitialSize(properties.getInitialSize());
		druidDataSource.setMinIdle(properties.getMinIdle());
		druidDataSource.setMaxActive(properties.getMaxActive());
		druidDataSource.setMaxWait(properties.getMaxWait());
		druidDataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
		druidDataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
		druidDataSource.setValidationQuery(properties.getValidationQuery());
		druidDataSource.setTestWhileIdle(properties.isTestWhileIdle());
		druidDataSource.setTestOnBorrow(properties.isTestOnBorrow());
		druidDataSource.setTestOnReturn(properties.isTestOnReturn());
		druidDataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
		druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());

		try {
			druidDataSource.setFilters(properties.getFilters());
			druidDataSource.init();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return druidDataSource;
	}

	/**
	 * 注册Servlet信息， 配置监控视图
	 */
	@Bean
	@ConditionalOnMissingBean
	public ServletRegistrationBean<Servlet> druidServlet() {
		ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

		// 白名单：
		servletRegistrationBean.addInitParameter("deny", "192.168.1.119");
		//登录查看信息的账号密码, 用于登录Druid监控后台
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		servletRegistrationBean.addInitParameter("loginPassword", "admin");
		//是否能够重置数据.
		servletRegistrationBean.addInitParameter("resetEnable", "true");
		return servletRegistrationBean;

	}

	/**
	 * 注册Filter信息, 监控拦截器
	 */
	@Bean
	@ConditionalOnMissingBean
	public FilterRegistrationBean<Filter> filterRegistrationBean() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
