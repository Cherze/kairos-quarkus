/*
 * Disciplina.java
 *
 * Created on 4 de Setembro de 2006, 19:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.objetos;
 

import java.util.ArrayList;
import java.awt.Color;

public class Disciplina {
    private String nome;
    private String sigla;
    private int cargaHorariaSemanal;
    private int codigoGA;
    private boolean prioridade;
    private String professor;
    private String grupo;
    private String semestre;
    private Color corDisciplina;
    
   public Disciplina(String nomeDisciplina, String sigla, String nomeProfessor ,
                        String cargaHoraria, boolean prioridade, String semestre, Color cor) {
        this.setNome(nomeDisciplina);
        this.setSigla(sigla);
        this.setCargaHorariaSemanal(cargaHoraria);
        this.setProfessor(nomeProfessor);
        this.setPrioridade(prioridade);
        this.setSemestre(semestre);
        this.setCor(cor);
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setSigla(String sigla){
        this.sigla=sigla;
    }
    
    public String getSigla(){
        return sigla;
    }
    
    public void setSemestre(String semestre){
        this.semestre=semestre;
    }
    
    public String getSemestre(){
        return semestre;
    }
    
    public void setCargaHorariaSemanal(String cargaHoraria){
        this.cargaHorariaSemanal=Integer.parseInt(cargaHoraria);
    }
    
    public int getCargaHorariaSemanal(){
        return cargaHorariaSemanal;
    }
    
    public void setCodigoGA(int num){
        this.codigoGA=num;
    }
    
    public int getCodigoGA(){
        return codigoGA;
    }
    
    public void setProfessor(String nomeProfessor){
        this.professor=nomeProfessor;
    }    
    
    public String getNomeProfessor(){
        return professor;
    }
    
    public void setPrioridade(boolean prioridade){
        this.prioridade=prioridade;         
    }
    
    public boolean getPrioridade(){
        return prioridade;
    }
    
    public void setCor(Color cor){
        this.corDisciplina=cor;
    }
    
    public Color getCor(){
        return corDisciplina;
    }
}
