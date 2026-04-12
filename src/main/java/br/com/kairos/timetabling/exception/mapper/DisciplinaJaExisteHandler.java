package br.com.kairos.timetabling.exception.mapper;


import jakarta.ws.rs.core.Response;
import br.com.kairos.timetabling.exception.DisciplinaJaExisteException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DisciplinaJaExisteHandler implements ExceptionMapper<DisciplinaJaExisteException> {
    @Override
    public Response toResponse(DisciplinaJaExisteException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}


