package pl.kryk.data.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.kryk.data.misc.AuditorAwareImpl;

@SpringBootApplication
@ComponentScan(basePackages = { "pl.kryk.data" })
@EnableJpaRepositories(basePackages = { "pl.kryk.data.repository" })
@EntityScan(basePackages = { "pl.kryk.data.domain" })
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}

}
