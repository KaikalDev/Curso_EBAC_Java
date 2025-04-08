package kaique.luan.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class ProdutoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoServerApplication.class, args);
	}

}
