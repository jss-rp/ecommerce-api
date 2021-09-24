package jss.ecommerce.api.resource;

import jss.ecommerce.api.dto.LoteDTO;
import jss.ecommerce.api.entity.Lote;
import jss.ecommerce.api.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("lote")
public class LoteResource {

    @Autowired
    private LoteRepository loteRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLote(@Context UriInfo uriInfo, Lote lote) {
        loteRepository.save(lote);

        return Response.status(Response.Status.CREATED.getStatusCode())
                .header(
                        "Location",
                        String.format("%s/%s", uriInfo.getAbsolutePath().toString(), lote.getCodigo()))
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLote(@PathParam("id") Long id) {
        try {
            final Lote lote = loteRepository
                    .findById(id)
                    .orElseThrow(() -> new NoResultException("Lote não encontrado"));

            final LoteDTO dto = new LoteDTO(lote);

            return Response.status(Response.Status.OK)
                    .entity(dto)
                    .build();
        } catch (NoResultException e) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
}
