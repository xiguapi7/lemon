package cloud.xiguapi.lemon.backup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 *
 * @author 大大大西西瓜皮🍉
 * @date 13:31 2020-07-31
 * description:
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")    // 允许跨域访问的路径
				.allowedOrigins("*")    // 允许跨域访问的源
				.allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")    // 允许请求方法
				.maxAge(168000)    // 预检间隔时间
				.allowedHeaders("*")  // 允许头部设置
				.allowCredentials(true);    // 是否发送cookie
	}
}
