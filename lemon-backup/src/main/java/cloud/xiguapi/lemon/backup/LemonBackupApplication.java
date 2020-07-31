package cloud.xiguapi.lemon.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cloud.xiguapi.lemon"})
public class LemonBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(LemonBackupApplication.class, args);
	}

}
