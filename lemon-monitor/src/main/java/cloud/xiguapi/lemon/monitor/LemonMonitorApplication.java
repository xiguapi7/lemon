package cloud.xiguapi.lemon.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class LemonMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LemonMonitorApplication.class, args);
	}

}
