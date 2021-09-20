package jss.ecommerce.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EcommerceApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new EcommerceApiApplication()
                .configure(new SpringApplicationBuilder(EcommerceApiApplication.class))
                .run(args);
    }

}
