/*
 * Disciplina.java
 *
 * Created on 4 de Setembro de 2006, 19:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.model;
 

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "disciplinas")

public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sigla;
    @Column(nullable = false)
    private int cargaHorariaSemanal;
    @Column(nullable = false)
    private int codigoGA;
    @Column(nullable = false)
    private boolean prioridade;
    //@Column(nullable = false)
    //private String professor;
    @ManyToMany
    @JoinTable(
            name = "disciplina_professor", // Nome da tabela no Postgres
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    public List<Professor> professores = new ArrayList<>();
    @Column(nullable = false)
    private String semestre;
    @Column(nullable = false)
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
       Professor professor=new Professor(nomeProfessor);
       this.professores.add(professor);
    }    
    
    public Professor getNomeProfessor(){
        return professores.getLast();
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
