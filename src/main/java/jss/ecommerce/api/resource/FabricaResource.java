package jss.ecommerce.api.resource;

import jss.ecommerce.api.dto.FabricaDTO;
import jss.ecommerce.api.dto.FabricanteDTO;
import jss.ecommerce.api.entity.Fabrica;
import jss.ecommerce.api.repository.FabricaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("fabrica")
public class FabricaResource {

    @Autowired
    private FabricaRepository fabricaRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFabrica(@Context UriInfo uriInfo, Fabrica fabrica) {
        fabricaRepository.save(fabrica);

        return Response.status(Response.Status.CREATED.getStatusCode())
                .header(
                        "Location",
                        String.format("%s/%s", uriInfo.getAbsolutePath().toString(), fabrica.getId()))
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFabrica(@PathParam("id") Long id) {
        try {
            final Fabrica fabrica = fabricaRepository
                    .findById(id)
                    .orElseThrow(() -> new NoResultException("Fabrica não encontrada"));

            FabricaDTO dto = new FabricaDTO(fabrica);

            return Response.status(Response.Status.OK)
                    .entity(dto)
                    .build();
        } catch (NoResultException e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
}
