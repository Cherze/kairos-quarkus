package br.com.kairos.timetabling.repository;

import br.com.kairos.timetabling.model.Disciplina;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DisciplinaRepository implements PanacheRepository<Disciplina> {
}
