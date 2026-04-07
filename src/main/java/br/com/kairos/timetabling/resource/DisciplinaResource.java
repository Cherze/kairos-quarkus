package br.com.kairos.timetabling.resource;

import br.com.kairos.timetabling.dto.DisciplinaDto;
import br.com.kairos.timetabling.model.Disciplina;
import br.com.kairos.timetabling.service.DisciplinaService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/disciplinas")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class DisciplinaResource {
    public final DisciplinaService disciplinaService;

    public DisciplinaResource(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @POST
    @Transactional
    //@RolesAllowed({"admin"})
    //@CacheInvalidateAll(cacheName = "cache-disciplina")
    public Response addDisciplina(DisciplinaDto disciplinaDto){
        Disciplina disciplina = disciplinaService.create(disciplinaDto);
        return Response.status(Response.Status.CREATED).entity(disciplina).build();
    }

    @GET
    //@RolesAllowed({"user"})
    public Response getDisciplina(){
        List<DisciplinaDto> disciplinas = disciplinaService.getAll();
        return Response.status(Response.Status.OK).entity(disciplinas).build();

    }

    @GET
    @Path("/{id}")
    //@RolesAllowed({"user"})
    //@CacheResult(cacheName = "cache-disciplina")
    public Response getById(@PathParam("id") long id){
        DisciplinaDto disciplina = disciplinaService.getById(id);
        return Response.status(Response.Status.OK).entity(disciplina).build();

    }

    @PUT
    @Path("/{id}")
    @Transactional
    //@RolesAllowed({"admin"})
    //@CacheInvalidateAll(cacheName = "cache-disciplina")
    public Response updateDisciplina(@PathParam("id") long id, DisciplinaDto disciplinaDto){
        Disciplina disciplinaAtualizada = disciplinaService.update(id,disciplinaDto);
        return Response.status(Response.Status.OK).entity(disciplinaAtualizada).build();

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    //@RolesAllowed({"admin"})
    //@CacheInvalidateAll(cacheName = "cache-disciplina")
    public Response deleteDisciplina(@PathParam("id") long id){
        disciplinaService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();

    }
}
