package cloud.xiguapi.lemon.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"cloud.xiguapi.lemon"})
@EnableDiscoveryClient
public class LemonBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(LemonBackupApplication.class, args);
	}

}
