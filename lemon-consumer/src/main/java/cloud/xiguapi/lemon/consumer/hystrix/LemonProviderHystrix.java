package cloud.xiguapi.lemon.consumer.hystrix;

import cloud.xiguapi.lemon.consumer.service.LemonProviderService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 大大大西西瓜皮🍉
 * @date 00:34 2020-08-01
 * description:
 */
@Component
public class LemonProviderHystrix implements LemonProviderService {

	@RequestMapping("/hello")
	public String hello() {
		return "sorry, hello service call failed.";
	}
}
