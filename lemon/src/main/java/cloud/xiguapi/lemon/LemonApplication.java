package cloud.xiguapi.lemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author adanz
 */
@SpringBootApplication(scanBasePackages = {"cloud.xiguapi.lemon"})
public class LemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(LemonApplication.class, args);
	}

}
