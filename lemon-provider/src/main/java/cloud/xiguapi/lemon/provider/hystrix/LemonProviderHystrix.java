package cloud.xiguapi.lemon.provider.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 大大大西西瓜皮🍉
 * @date 23:29 2020-07-31
 * description:
 */
@Component
public class LemonProviderHystrix {

	@RequestMapping("/hello")
	public String hello() {
		return "sorry, hello service call failed.";
	}
}
