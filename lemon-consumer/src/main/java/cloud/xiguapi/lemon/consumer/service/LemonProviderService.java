package cloud.xiguapi.lemon.consumer.service;

import cloud.xiguapi.lemon.consumer.hystrix.LemonProviderHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author 大大大西西瓜皮🍉
 * date 00:32 2020-08-01
 * description:
 */
@FeignClient(name = "lemon-provider", fallback = LemonProviderHystrix.class)
public interface LemonProviderService {

	@RequestMapping("/hello")
	String hello();
}