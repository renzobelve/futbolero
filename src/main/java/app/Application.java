package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author renzobelve
 * 
 * Clase que inicializa la app
 */

@SpringBootApplication
@ComponentScan({"app", "controller", "loader", "service"})
@EntityScan("model")
@EnableJpaRepositories("repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
