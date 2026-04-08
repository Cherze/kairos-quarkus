package br.com.kairos.timetabling.dto.mapper;

import br.com.kairos.timetabling.dto.DisciplinaDto;
import br.com.kairos.timetabling.model.Disciplina;

public class DisciplinaMapper {

    public static Disciplina toEntity(DisciplinaDto disciplinaDto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNomeDisciplina(disciplinaDto.getNomeDisciplina());
        disciplina.setDataInauguracao(disciplinaDto.getDataInauguracao());
        disciplina.setCgc(disciplinaDto.getCgc());
        disciplina.setCep(disciplinaDto.getCep());
        disciplina.setNumero(disciplinaDto.getNumero());
        disciplina.setNomeGestor(disciplinaDto.getNomeGestor());
        return disciplina;
    }
    public static Disciplina updateDisciplina(DisciplinaDto disciplinaDto, Disciplina disciplina){
        if (disciplinaDto == null){
            return null;
        }
        disciplina.setCgc(disciplinaDto.getCgc());
        disciplina.setNomeDisciplina(disciplinaDto.getNomeDisciplina());
        disciplina.setNomeGestor(disciplinaDto.getNomeGestor());
        disciplina.setCep(disciplinaDto.getCep());
        disciplina.setNumero(disciplinaDto.getNumero());
        disciplina.setDataInauguracao(disciplinaDto.getDataInauguracao());
        return disciplina;
    }

    public static DisciplinaDto toDto(Disciplina disciplina){
        if (disciplina == null){
            return null;
        }
        DisciplinaDto disciplinaDto = new DisciplinaDto();
        disciplinaDto.setCgc(disciplina.getCgc());
        disciplinaDto.setNomeDisciplina(disciplina.getNomeDisciplina());
        disciplinaDto.setCep(disciplina.getCep());
        disciplinaDto.setDataInauguracao(disciplina.getDataInauguracao());
        disciplinaDto.setNomeGestor(disciplina.getNomeGestor());
        disciplinaDto.setLogradouro(disciplina.getLogradouro());
        disciplinaDto.setNumero(disciplina.getNumero());
        disciplinaDto.setCidade(disciplina.getCidade());
        disciplinaDto.setEstado(disciplina.getEstado());
        return disciplinaDto;
    }
    
}
