package br.com.kairos.timetabling.dto.mapper;

import br.com.kairos.timetabling.dto.ProfessorDto;
import br.com.kairos.timetabling.model.Professor;

public class ProfessorMapper {

    public static Professor toEntity(ProfessorDto professorDto) {
        Professor professor = new Professor();
        professor.setNome(professorDto.getNome());
        professor.disponibilidade=professorDto.disponibilidade;
        professor.disciplinas=professorDto.disciplinas;
        return professor;
    }
    public static Professor updateProfessor(ProfessorDto professorDto, Professor professor){
        if (professorDto == null){
            return null;
        }
        professor.setNome(professorDto.getNome());
        professor.disponibilidade=professorDto.disponibilidade;
        professor.disciplinas=professorDto.disciplinas;
        return professor;
    }

    public static ProfessorDto toDto(Professor professor){
        if (professor == null){
            return null;
        }
        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setNome(professor.getNome());
        professorDto.disponibilidade=professor.disponibilidade;
        professorDto.disciplinas=professor.disciplinas;
        return professorDto;
    }
    
}
