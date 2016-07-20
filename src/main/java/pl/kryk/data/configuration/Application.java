package pl.kryk.data.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@ComponentScan(basePackages = { "pl.kryk.data" })
@EnableJpaRepositories(basePackages = { "pl.kryk.data.repository" })
@EntityScan(basePackages = { "pl.kryk.data.domain" })
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
