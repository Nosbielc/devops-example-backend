package nosbielc.com.devops.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 19/05/2020
 * @project devops-example-backend
 */
@SpringBootApplication
public class DevopsExampleBackendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DevopsExampleBackendApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DevopsExampleBackendApplication.class);
    }

}
