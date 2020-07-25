package cloud.xiguapi.lemon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS跨域配置类
 *
 * @author 大大大西西瓜皮🍉
 * @date 02:05 2020-07-26
 * description:
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("/**")
				.allowedMethods("POST", "GET", "DELETE", "PUT", "OPTIONS")
				.maxAge(168000)
				.allowedHeaders("*")
				.allowCredentials(true);
	}
}
