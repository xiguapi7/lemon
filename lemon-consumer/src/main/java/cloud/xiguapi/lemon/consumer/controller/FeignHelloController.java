package cloud.xiguapi.lemon.consumer.controller;

import cloud.xiguapi.lemon.consumer.service.LemonProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大大大西西瓜皮🍉
 * @date 00:31 2020-08-01
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