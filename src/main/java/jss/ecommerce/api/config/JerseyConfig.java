package jss.ecommerce.api.config;

import jss.ecommerce.api.resource.ProdutoResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ProdutoResource.class);
    }
}
