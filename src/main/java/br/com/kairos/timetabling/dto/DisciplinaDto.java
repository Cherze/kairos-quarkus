package br.com.kairos.timetabling.dto;

import br.com.kairos.timetabling.model.Professor;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDto {

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sigla;
    @Column(name="carga_horaria_semanal", nullable = false)
    @JsonProperty("carga_horaria_semanal")
    private int cargaHorariaSemanal;
    @Column(name="codigo_GA", nullable = false)
    @JsonProperty("codigo_GA")
    private int codigoGA;
    @Column(nullable = false)
    private boolean prioridade;
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
