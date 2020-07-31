package cloud.xiguapi.lemon.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 大大大西西瓜皮🍉
 * @date 00:35 2020-08-01
 * description:
 */
@RestController
public class ServicesController {

	private final LoadBalancerClient loadBalancerClient;

	private final DiscoveryClient discoveryClient;

	@Autowired
	public ServicesController(LoadBalancerClient loadBalancerClient, DiscoveryClient discoveryClient) {
		this.loadBalancerClient = loadBalancerClient;
		this.discoveryClient = discoveryClient;
	}

	/**
	 * 获取所有服务
	 */
	@RequestMapping("/services")
	public Object services() {
		return discoveryClient.getInstances("mango-producer");
	}

	/**
	 * 从所有服务中选择一个服务（轮询）
	 */
	@RequestMapping("/discover")
	public Object discover() {
		return loadBalancerClient.choose("mango-producer").getUri().toString();
	}
}
