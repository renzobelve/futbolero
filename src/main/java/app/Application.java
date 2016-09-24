package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author renzobelve
 * 
 * Clase que inicializa la app
 */

@SpringBootApplication
@ComponentScan({"app", "controller"})
@EntityScan("model")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
