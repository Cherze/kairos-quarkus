package br.com.kairos.timetabling.dto.mapper;

import br.com.kairos.timetabling.dto.HorarioDto;
import br.com.kairos.timetabling.model.Horario;

public class HorarioMapper {

    public static Horario toEntity(HorarioDto horarioDto) {
        Horario horario = new Horario();
        horario.setDias(horarioDto.getDias());
        horario.setPeriodos(horarioDto.getPeriodos());

        return horario;
    }
    public static Horario updateHorario(HorarioDto horarioDto, Horario horario){
        if (horarioDto == null){
            return null;
        }
        horario.setDias(horarioDto.getDias());
        horario.setPeriodos(horarioDto.getPeriodos());
        return horario;
    }

    public static HorarioDto toDto(Horario horario){
        if (horario == null){
            return null;
        }
        HorarioDto horarioDto = new HorarioDto();
        horarioDto.setDias(horario.getDias());
        horarioDto.setPeriodos(horario.getPeriodos());
        return horarioDto;
    }
    
}
