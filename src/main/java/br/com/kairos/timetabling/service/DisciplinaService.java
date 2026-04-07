package br.com.kairos.timetabling.service;

import br.com.kairos.timetabling.dto.DisciplinaDto;
import br.com.kairos.timetabling.model.Disciplina;
import br.com.kairos.timetabling.repository.DisciplinaRepository;

import java.util.List;

public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public Disciplina create(DisciplinaDto disciplinaDto) {
    }

    public List<DisciplinaDto> getAll() {
    }

    public DisciplinaDto getById(long id) {
    }

    public Disciplina update(long id, DisciplinaDto disciplinaDto) {
    }

    public void delete(long id) {
    }
}
