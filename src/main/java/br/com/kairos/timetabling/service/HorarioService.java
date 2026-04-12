package br.com.kairos.timetabling.service;

import br.com.kairos.timetabling.dto.HorarioDto;
import br.com.kairos.timetabling.dto.mapper.DisciplinaMapper;
import br.com.kairos.timetabling.dto.mapper.HorarioMapper;
import br.com.kairos.timetabling.exception.DisciplinaJaExisteException;
import br.com.kairos.timetabling.model.Disciplina;
import br.com.kairos.timetabling.model.Horario;
import br.com.kairos.timetabling.repository.HorarioRepository;

import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.findAll;

public class HorarioService {

    private final HorarioRepository horarioRepository;

    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public Horario create(HorarioDto horarioDto) {

        Horario horario = HorarioMapper.toEntity(horarioDto);
        horarioRepository.persist(horario);
        return horario;
    }

    public List<HorarioDto> getAll() {
        return horarioRepository.findAll().list().stream().map(HorarioMapper::toDto).toList();
    }

    public HorarioDto getById(long id) {
        Horario horario=horarioRepository.findById(id);
        return HorarioMapper.toDto(horario);
    }

    public Horario update(long id, HorarioDto horarioDto) {
        Horario horario = horarioRepository.findById(id);
        HorarioMapper.updateHorario(horarioDto, horario);
        return horario;
    }

    public void delete(long id) {
        horarioRepository.deleteById(id);
    }
}
