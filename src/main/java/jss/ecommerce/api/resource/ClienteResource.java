package jss.ecommerce.api.resource;

import jss.ecommerce.api.dto.ClienteDTO;
import jss.ecommerce.api.entity.Cliente;
import jss.ecommerce.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("cliente")
public class ClienteResource {

    @Autowired
    private ClienteRepository clienteRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCliente(@Context UriInfo uriInfo, Cliente cliente) {
        clienteRepository.save(cliente);

        return Response.status(Response.Status.CREATED.getStatusCode())
                .header(
                        "Location",
                        String.format("%s/%s", uriInfo.getAbsolutePath().toString(), cliente.getId()))
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(@PathParam("id") Long id) {
        try {
            final Cliente cliente = clienteRepository
                    .findById(id)
                    .orElseThrow(() -> new NoResultException("Cliente não encontrado"));

            final ClienteDTO dto = new ClienteDTO(cliente);

            return Response.status(Response.Status.OK)
                    .entity(dto)
                    .build();
        } catch(NoResultException e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
}
