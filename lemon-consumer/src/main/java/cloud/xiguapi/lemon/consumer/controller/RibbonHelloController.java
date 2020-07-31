package cloud.xiguapi.lemon.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 大大大西西瓜皮🍉
 * @date 19:18 2020-07-31
 * description:
 */
@RestController
public class RibbonHelloController {

	private final RestTemplate restTemplate;

	@Autowired
	public RibbonHelloController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/ribbon/hello")
	public String call() {
		// 调用服务，service-producer为注册的服务名称
		String result = restTemplate.getForObject("http://lemon-provider/hello", String.class);
		System.out.println("result: " + result);
		return result;
	}
}
