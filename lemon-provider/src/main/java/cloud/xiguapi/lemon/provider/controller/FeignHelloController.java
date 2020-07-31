package cloud.xiguapi.lemon.provider.controller;

import cloud.xiguapi.lemon.provider.service.LemonProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大大大西西瓜皮🍉
 * @date 23:17 2020-07-31
 * description:
 */
@RestController
public class FeignHelloController {

	private final LemonProviderService service;

	@Autowired
	public FeignHelloController(LemonProviderService service) {
		this.service = service;
	}

	@RequestMapping("/feign/call")
	public String call() {
		// 像调用本地服务一样
		return service.hello();
	}
}
