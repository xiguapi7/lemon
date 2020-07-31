package cloud.xiguapi.lemon.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大大大西西瓜皮🍉
 * @date 19:03 2020-07-31
 * description:
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
