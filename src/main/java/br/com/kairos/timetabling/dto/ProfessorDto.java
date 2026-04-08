package br.com.kairos.timetabling.dto;

import br.com.kairos.timetabling.model.Disciplina;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDto {

    @Column(nullable = false)
    public String nome;
    @Column(nullable = false)
    public Integer[] disponibilidade;
    @ManyToMany(mappedBy = "professor")
    public List<Disciplina> disciplinas = new ArrayList<>();


    public void setNome(String nome){
        this.nome=nome;
    }

    public String getNome(){
        return nome;
    }

    public void zeraDisponibilidades(int qtdHorarios){
        disponibilidade= new Integer[qtdHorarios];
        for(int i=0;i<disponibilidade.length;i++){
            disponibilidade[i]=0;
        }
    }

    public void addDisponibilidades(Integer[] disp){
        System.arraycopy(disp, 0, disponibilidade, 0, disponibilidade.length);
    }

    public Integer[] getDisponibilidades(){
        return disponibilidade;
    }

    public int getDisponibilidade(int posicaoVetor){
        return disponibilidade[posicaoVetor];
    }

}
