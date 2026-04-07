package br.com.kairos.timetabling.service;

import br.com.kairos.timetabling.dto.ProfessorDto;
import br.com.kairos.timetabling.dto.mapper.ProfessorMapper;
import br.com.kairos.timetabling.exception.ProfessorJaExisteException;
import br.com.kairos.timetabling.model.Professor;
import br.com.kairos.timetabling.repository.ProfessorRepository;
import jakarta.enterprise.context.ApplicationScoped;
//import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@ApplicationScoped

public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }


    public Professor create(ProfessorDto professorDto) {
        Professor professor = professorRepository.findById(professorDto.getNome());
        if (professor != null) {
            throw new ProfessorJaExisteException("O professor " + professor.getNome() + " ja está cadastrado.");
        }
        professor = ProfessorMapper.toEntity(professorDto);

        professorRepository.persist(professor);
        return professor;
    }

    public ProfessorDto getById(long id) {
        return ProfessorMapper.toDto(findById(id));
    }

    public Professor update(long id, ProfessorDto professorDto) {
        Professor professor = this.findById(id);
        ProfessorMapper.updateProfessor(professorDto, professor);
        return professor;
    }

    public void delete(long id) {
        Professor professor = this.findById(id);
        professorRepository.delete(professor);
    }

    public List<ProfessorDto> getAll() {
        return professorRepository.findAll().list().stream().map(ProfessorMapper::toDto).toList();
    }
}
