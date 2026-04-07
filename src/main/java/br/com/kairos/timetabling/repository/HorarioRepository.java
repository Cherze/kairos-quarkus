package br.com.kairos.timetabling.repository;

import br.com.kairos.timetabling.model.Horario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HorarioRepository implements PanacheRepository<Horario> {
}
