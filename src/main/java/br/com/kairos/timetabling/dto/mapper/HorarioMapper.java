package br.com.kairos.timetabling.dto.mapper;

import br.com.kairos.timetabling.dto.HorarioDto;
import br.com.kairos.timetabling.model.Horario;

public class HorarioMapper {

    public static Horario toEntity(HorarioDto horarioDto) {
        Horario horario = new Horario();
        horario.setNomeHorario(horarioDto.getNomeHorario());
        horario.setDataInauguracao(horarioDto.getDataInauguracao());
        horario.setCgc(horarioDto.getCgc());
        horario.setCep(horarioDto.getCep());
        horario.setNumero(horarioDto.getNumero());
        horario.setNomeGestor(horarioDto.getNomeGestor());
        return horario;
    }
    public static Horario updateHorario(HorarioDto horarioDto, Horario horario){
        if (horarioDto == null){
            return null;
        }
        horario.setCgc(horarioDto.getCgc());
        horario.setNomeHorario(horarioDto.getNomeHorario());
        horario.setNomeGestor(horarioDto.getNomeGestor());
        horario.setCep(horarioDto.getCep());
        horario.setNumero(horarioDto.getNumero());
        horario.setDataInauguracao(horarioDto.getDataInauguracao());
        return horario;
    }

    public static HorarioDto toDto(Horario horario){
        if (horario == null){
            return null;
        }
        HorarioDto horarioDto = new HorarioDto();
        horarioDto.setCgc(horario.getCgc());
        horarioDto.setNomeHorario(horario.getNomeHorario());
        horarioDto.setCep(horario.getCep());
        horarioDto.setDataInauguracao(horario.getDataInauguracao());
        horarioDto.setNomeGestor(horario.getNomeGestor());
        horarioDto.setLogradouro(horario.getLogradouro());
        horarioDto.setNumero(horario.getNumero());
        horarioDto.setCidade(horario.getCidade());
        horarioDto.setEstado(horario.getEstado());
        return horarioDto;
    }
    
}
