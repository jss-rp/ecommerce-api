package jss.ecommerce.api.config;

import jss.ecommerce.api.resource.FabricaResource;
import jss.ecommerce.api.resource.FabricanteResource;
import jss.ecommerce.api.resource.LoteResource;
import jss.ecommerce.api.resource.ProdutoResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ProdutoResource.class);
        register(FabricanteResource.class);
        register(LoteResource.class);
        register(FabricaResource.class);
    }
}
