package br.com.kairos.timetabling.dto;

import jakarta.persistence.Column;

public class HorarioDto {

    public long id;
    private String[] dias;
    private int periodos=0;
    private final String[] diasPossiveis= {"Horario","Segunda", "Terca", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo"};


    public void setDias(String[] dia){
        dias=dia;
    }

    public String[] getDias(){
        return dias;
    }

    public void setPeriodos(int periodo){
        periodos=periodo;
    }

    public int getPeriodos(){
        return periodos;
    }

    public int getNumeroHorarios(){
        int num= (dias.length)*this.getPeriodos();
        return num;
    }

    public String[] getDiasPossiveis(){
        return diasPossiveis;
    }

}
