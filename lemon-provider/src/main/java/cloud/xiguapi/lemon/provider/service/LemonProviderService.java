package cloud.xiguapi.lemon.provider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 大大大西西瓜皮🍉
 * @date 20:16 2020-07-31
 * description:
 */
@FeignClient(name = "lemon-provider")
public interface LemonProviderService {

	@RequestMapping("/hello")
	String hello();
}
