package br.com.kairos.timetabling.resource;

//import io.quarkus.cache.CacheInvalidateAll;
import br.com.kairos.timetabling.model.Professor;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/professores")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ProfessorResource {
    public final ProfessorService professorService;

    public ProfessorResource(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @POST
    @Transactional
    //@RolesAllowed({"admin"})
    //@CacheInvalidateAll(cacheName = "cache-produto")
    public Response addProduto(ProfessorDto professorDto){
        Professor professor = professorService.create(professorDto);
        return Response.status(Response.Status.CREATED).entity(professor).build();
    }

    @GET
    @RolesAllowed({"user"})
    public Response getProduto(){
        List<ProfessorDto> professores = professores.getAll();
        return Response.status(Response.Status.OK).entity(professores).build();

    }

    @GET
    @Path("/{id}")
    //@RolesAllowed({"user"})
    //@CacheResult(cacheName = "cache-produto")
    public Response getById(@PathParam("id") long id){
        ProfessorDto professor = professorService.getById(id);
        return Response.status(Response.Status.OK).entity(professor).build();

    }

    @PUT
    @Path("/{id}")
    @Transactional
    //@RolesAllowed({"admin"})
    //@CacheInvalidateAll(cacheName = "cache-produto")
    public Response updateProduto(@PathParam("id") long id, ProfessorDto produtoDto){
        Professor professorAtualizado = professorService.update(id,produtoDto);
        return Response.status(Response.Status.OK).entity(professorAtualizado).build();

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    //@RolesAllowed({"admin"})
    //@CacheInvalidateAll(cacheName = "cache-produto")
    public Response deleteProduto(@PathParam("id") long id){
        professorService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();

    }

}
