package jss.ecommerce.api.resource;

import jss.ecommerce.api.entity.Pedido;
import jss.ecommerce.api.entity.PedidoStatus;
import jss.ecommerce.api.repository.PedidoRepository;
import jss.ecommerce.api.repository.PedidoStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

@Path("pedido")
public class PedidoResource {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoStatusRepository pedidoStatusRepository;

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

    @GET
    @Path("status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStatus() {
        try {
            final List<PedidoStatus> pedidoStatus = new ArrayList<>();
            pedidoStatusRepository.findAll().forEach(i -> pedidoStatus.add(i));

            if(pedidoStatus.isEmpty())
                throw new NoResultException("Nenhum status de pedido encontrado");

            return Response.status(Response.Status.OK)
                    .entity(pedidoStatus)
                    .build();
        } catch (NoResultException e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    @GET
    @Path("status/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatus(@PathParam("id") Long id) {
        try {
            final PedidoStatus pedidoStatus = pedidoStatusRepository.findById(id)
                    .orElseThrow(() -> new NoResultException("Status de pedidos não encontrado"));

            return Response.status(Response.Status.OK)
                    .entity(pedidoStatus)
                    .build();
        } catch (NoResultException e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    @PUT
    @Path("{id}/status")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeStatus(@PathParam("id") Long id, PedidoStatus pedidoStatus) {
        try {
            final Pedido pedido = pedidoRepository.findById(id)
                    .orElseThrow(() -> new NoResultException("Pedido não encontrado"));

            pedido.setStatus(pedidoStatus);

            pedidoRepository.save(pedido);

            return Response.status(Response.Status.ACCEPTED)
                    .entity(pedidoStatus)
                    .build();
        } catch (NoResultException e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
}
