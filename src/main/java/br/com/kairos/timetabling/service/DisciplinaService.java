package br.com.kairos.timetabling.service;

import br.com.kairos.timetabling.dto.DisciplinaDto;
import br.com.kairos.timetabling.dto.mapper.DisciplinaMapper;
import br.com.kairos.timetabling.dto.mapper.ProfessorMapper;
import br.com.kairos.timetabling.exception.DisciplinaJaExisteException;
import br.com.kairos.timetabling.model.Disciplina;
import br.com.kairos.timetabling.model.Professor;
import br.com.kairos.timetabling.repository.DisciplinaRepository;

import java.util.List;

public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public Disciplina create(DisciplinaDto disciplinaDto) {
        Disciplina disciplina = disciplinaRepository.findByName(disciplinaDto.getNome());
        if(disciplina!=null){
            throw new DisciplinaJaExisteException("A disciplina " + disciplina.getNome() + " já está cadastrada.");
        }
        disciplina = DisciplinaMapper.toEntity(disciplinaDto);
        disciplinaRepository.persist(disciplina);
        return disciplina;
    }

    public List<DisciplinaDto> getAll() {
        return disciplinaRepository.findAll().list().stream().map(DisciplinaMapper::toDto).toList();
    }

    public DisciplinaDto getById(long id) {
        return DisciplinaMapper.toDto(disciplinaRepository.findById(id));
    }

    public Disciplina update(long id, DisciplinaDto disciplinaDto) {
        Disciplina disciplina = disciplinaRepository.findById(id);
        DisciplinaMapper.updateDisciplina(disciplinaDto, disciplina);
        return disciplina;
    }

    public void delete(long id) {
        disciplinaRepository.deleteById(id);
    }
}
