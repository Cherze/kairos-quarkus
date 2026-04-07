/*
 * Professor.java
 *
 * Created on 2 de Setembro de 2006, 17:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(nullable = false)
    public String nome;
    @Column(nullable = false)
    Integer[] disponibilidade;
    @ManyToMany(mappedBy = "professor")
    public List<Disciplina> disciplinas = new ArrayList<>();
    
    /** Creates a new instance of Professor */
    public Professor(String nome) {
        this.setNome(nome);
    }
    
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
