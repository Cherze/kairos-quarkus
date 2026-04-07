/*
 * Horario.java
 *
 * Created on 4 de Setembro de 2006, 19:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.model;

import jakarta.persistence.*;

@Entity
@Table(name = "horarios")

public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(nullable = false)
    private String[] dias;
    @Column(nullable = false)
    private int periodos=0;
    @Column(nullable = false)
    private final String[] diasPossiveis= {"Horario","Segunda", "Terca", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo"};
    
    public Horario() {
    }
    
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
