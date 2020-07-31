package cloud.xiguapi.lemon.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class LemonZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(LemonZuulApplication.class, args);
	}

}
