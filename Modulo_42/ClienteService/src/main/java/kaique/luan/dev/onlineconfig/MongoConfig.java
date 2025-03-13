/**
 * 
 */
package kaique.luan.dev.onlineconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "kaique.luan.dev.repository")
public class MongoConfig {

}
