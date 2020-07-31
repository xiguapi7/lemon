package cloud.xiguapi.lemon.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class LemonMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LemonMonitorApplication.class, args);
	}

}
