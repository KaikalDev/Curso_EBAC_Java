package kaique.luan.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class ClienteServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteServerApplication.class, args);
	}

}
