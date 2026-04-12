package br.com.kairos.timetabling.dto.mapper;

import br.com.kairos.timetabling.dto.DisciplinaDto;
import br.com.kairos.timetabling.model.Disciplina;

public class DisciplinaMapper {

    public static Disciplina toEntity(DisciplinaDto disciplinaDto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(disciplinaDto.getNome());
        disciplina.setSigla(disciplinaDto.getSigla());
        disciplina.setSemestre(disciplinaDto.getSemestre());
        disciplina.setCargaHorariaSemanal(disciplinaDto.getCargaHorariaSemanal()+"");
        disciplina.setCodigoGA(disciplinaDto.getCodigoGA());

        return disciplina;
    }
    public static Disciplina updateDisciplina(DisciplinaDto disciplinaDto, Disciplina disciplina){
        if (disciplinaDto == null){
            return null;
        }

        disciplina.setNome(disciplinaDto.getNome());
        disciplina.setSigla(disciplinaDto.getSigla());
        disciplina.setSemestre(disciplinaDto.getSemestre());
        disciplina.setCargaHorariaSemanal(disciplinaDto.getCargaHorariaSemanal()+"");
        disciplina.setCodigoGA(disciplinaDto.getCodigoGA());
        return disciplina;
    }

    public static DisciplinaDto toDto(Disciplina disciplina){
        if (disciplina == null){
            return null;
        }
        DisciplinaDto disciplinaDto = new DisciplinaDto();
        disciplinaDto.setNome(disciplina.getNome());
        disciplinaDto.setSigla(disciplina.getSigla());
        disciplinaDto.setSemestre(disciplina.getSemestre());
        disciplinaDto.setCargaHorariaSemanal(disciplina.getCargaHorariaSemanal()+"");
        disciplinaDto.setCodigoGA(disciplina.getCodigoGA());
        return disciplinaDto;
    }
    
}
