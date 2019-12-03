package controller;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.GenericEntity;
import repositories.EntityRepository;
import services.AbstractServices;

public abstract class AbstractController<T extends AbstractServices<R, E>, R extends EntityRepository<E>, E extends GenericEntity> {

	@Inject
	protected T service;

	@GET
	@Path("healtcheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "Controller works";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<E> listAll() {
		return service.getAll();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public E create(E Entity) {

		return service.create(Entity);
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })

	public E getOne(@PathParam("id") Long id) {

		return service.getId(id);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) {
		service.remove(id);

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, E Entity) {
		try {
			E edited = service.update(id, Entity);
			return Response.status(Response.Status.OK).entity(edited).build();
		} catch (Exception e) {

			return Response.status(Response.Status.BAD_REQUEST).entity("ids do not match.").build();
		}

	}

}
