package cloud.xiguapi.lemon.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 大大大西西瓜皮🍉
 * @date 19:12 2020-07-31
 * description:
 */
@RestController
public class CallHelloController {

	private final LoadBalancerClient loadBalancerClient;

	@Autowired
	public CallHelloController(LoadBalancerClient loadBalancerClient) {
		this.loadBalancerClient = loadBalancerClient;
	}

	@GetMapping("/call")
	public String call() {
		ServiceInstance si = loadBalancerClient.choose("lemon-provider");
		System.out.println("服务地址：" + si.getUri());
		System.out.println("服务名称：" + si.getServiceId());

		String callServiceResult = new RestTemplate()
				.getForObject(si.getUri().toString() + "/hello", String.class);

		System.out.println(callServiceResult);

		return callServiceResult;
	}
}
