package br.com.kairos.timetabling.resource;

import br.com.kairos.timetabling.dto.HorarioDto;
import br.com.kairos.timetabling.model.Horario;
import br.com.kairos.timetabling.service.HorarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/horarios")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class HorarioResource {
    public final HorarioService horarioService;

    public HorarioResource(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @POST
    @Transactional
    //@RolesAllowed({"admin"})
    //@CacheInvalidateAll(cacheName = "cache-horario")
    public Response addHorario(HorarioDto horarioDto){
        Horario horario = horarioService.create(horarioDto);
        return Response.status(Response.Status.CREATED).entity(horario).build();
    }

    @GET
    //@RolesAllowed({"user"})
    public Response getHorario(){
        List<HorarioDto> horarios = horarioService.getAll();
        return Response.status(Response.Status.OK).entity(horarios).build();

    }

    @GET
    @Path("/{id}")
    //@RolesAllowed({"user"})
    //@CacheResult(cacheName = "cache-horario")
    public Response getById(@PathParam("id") long id){
        HorarioDto horario = horarioService.getById(id);
        return Response.status(Response.Status.OK).entity(horario).build();

    }

    @PUT
    @Path("/{id}")
    @Transactional
    //@RolesAllowed({"admin"})
    //@CacheInvalidateAll(cacheName = "cache-horario")
    public Response updateHorario(@PathParam("id") long id, HorarioDto horarioDto){
        Horario horarioAtualizado = horarioService.update(id,horarioDto);
        return Response.status(Response.Status.OK).entity(horarioAtualizado).build();

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    //@RolesAllowed({"admin"})
    //@CacheInvalidateAll(cacheName = "cache-horario")
    public Response deleteHorario(@PathParam("id") long id){
        horarioService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();

    }
}
