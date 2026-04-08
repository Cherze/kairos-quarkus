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
        professor.setCgc(professorDto.getCgc());
        professor.setNomeProfessor(professorDto.getNomeProfessor());
        professor.setNome(professorDto.getNome());
        professor.setCep(professorDto.getCep());
        professor.setNumero(professorDto.getNumero());
        professor.setDataInauguracao(professorDto.getDataInauguracao());
        return professor;
    }

    public static ProfessorDto toDto(Professor professor){
        if (professor == null){
            return null;
        }
        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setCgc(professor.getCgc());
        professorDto.setNomeProfessor(professor.getNomeProfessor());
        professorDto.setCep(professor.getCep());
        professorDto.setDataInauguracao(professor.getDataInauguracao());
        professorDto.setNomeGestor(professor.getNomeGestor());
        professorDto.setLogradouro(professor.getLogradouro());
        professorDto.setNumero(professor.getNumero());
        professorDto.setCidade(professor.getCidade());
        professorDto.setEstado(professor.getEstado());
        return professorDto;
    }
    
}
