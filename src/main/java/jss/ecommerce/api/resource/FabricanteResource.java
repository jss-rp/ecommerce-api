package jss.ecommerce.api.resource;

import jss.ecommerce.api.dto.FabricanteDTO;
import jss.ecommerce.api.entity.Fabricante;
import jss.ecommerce.api.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("fabricante")
public class FabricanteResource {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFabricante(@Context UriInfo uriInfo, Fabricante fabricante) {
        fabricanteRepository.save(fabricante);

        return Response.status(Response.Status.CREATED.getStatusCode())
                .header(
                        "Location",
                        String.format("%s/%s", uriInfo.getAbsolutePath().toString(), fabricante.getId()))
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFabricante(@PathParam("id") Long id) {
        try {
            final Fabricante fabricante = fabricanteRepository
                    .findById(id)
                    .orElseThrow(() -> new NoResultException("Fabricante não encontrado"));

            final FabricanteDTO dto = new FabricanteDTO(fabricante);

            return Response.status(Response.Status.OK)
                    .entity(dto)
                    .build();
        } catch (NoResultException e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
}
