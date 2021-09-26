package jss.ecommerce.api.resource;

import jss.ecommerce.api.entity.Pedido;
import jss.ecommerce.api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("pedido")
public class PedidoResource {

    @Autowired
    private PedidoRepository pedidoRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPedido(@Context UriInfo uriInfo, Pedido pedido) {
        pedidoRepository.save(pedido);

        return Response.status(Response.Status.CREATED)
                .header(
                        "Location",
                        String.format("%s/%s", uriInfo.getAbsolutePath().toString(), pedido.getId()))
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPedido(@PathParam("id") Long id) {
        try {
            final Pedido pedido = pedidoRepository
                    .findById(id)
                    .orElseThrow(() -> new NoResultException("Pedido não pedido"));

            return Response.status(Response.Status.OK)
                    .entity(pedido)
                    .build();
        } catch (NoResultException e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
}
