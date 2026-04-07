package br.com.kairos.timetabling.service;

import br.com.kairos.timetabling.dto.HorarioDto;
import br.com.kairos.timetabling.model.Horario;
import br.com.kairos.timetabling.repository.HorarioRepository;

import java.util.List;

public class HorarioService {

    private final HorarioRepository horarioRepository;

    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public Horario create(HorarioDto horarioDto) {
    }

    public List<HorarioDto> getAll() {
    }

    public HorarioDto getById(long id) {
    }

    public Horario update(long id, HorarioDto horarioDto) {
    }

    public void delete(long id) {
    }
}
