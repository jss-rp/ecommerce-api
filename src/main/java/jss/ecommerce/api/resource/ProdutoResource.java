package jss.ecommerce.api.resource;

import jss.ecommerce.api.dto.ProdutoDTO;
import jss.ecommerce.api.entity.Produto;
import jss.ecommerce.api.repository.ProdutoRepository;
import jss.ecommerce.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("produto")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoService produtoService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduto(@Context UriInfo uriInfo, Produto produto) {
		produtoRepository.save(produto);

		return Response.status(Response.Status.CREATED.getStatusCode())
				.header(
						"Location",
						String.format("%s/%s", uriInfo.getAbsolutePath().toString(), produto.getId()))
				.build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduto(@PathParam("id") Long id) {
		try {
			final Produto produto = produtoRepository
					.findById(id)
					.orElseThrow(() -> new NoResultException("Produto não encontrado"));

			final ProdutoDTO dto = new ProdutoDTO(produto);
			dto.setQuantidade(produtoService.contarProdutos(id));

			return Response.status(Response.Status.OK)
					.entity(dto)
					.build();
		} catch (NoResultException e) {
			return Response.status(Response.Status.NO_CONTENT).build();
		}
	}
}
