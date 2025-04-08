package kaique.luan.dev.config;

import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorConfig {
    public ValidatorConfig() {
    }

    @Bean
    public Validator validatorFactory() {
        return new LocalValidatorFactoryBean();
    }
}
