/*
 * FitnessHorario.java
 *
 * Created on 23 de Setembro de 2006, 18:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.fitness;
 
import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import br.com.kairos.jga.fitness.AbstractFitnessFunction;
import br.com.kairos.timetabling.controle.ControleHorario;
import br.com.kairos.timetabling.filter.*;

import java.util.*;

public class FitnessHorario extends AbstractFitnessFunction{
    private ControleHorario controle;
    ArrayList disciplinas;
    TreeMap professores;
    FilterManager filter;
    FilterAvaliarCargaHoraria avaliarCargaHoraria;
    FilterAvaliarIndisponibilidades avaliarIndisponibilidades;
    FilterAvaliarConflitos avaliarConflitos;
    FilterAvaliarSequenciaDeDisciplinas avaliarSequenciaDeDisciplinas;
        
    
    public FitnessHorario(ArrayList disciplinas, TreeMap professores){
        this.disciplinas=disciplinas;
        this.professores=professores;
        filter = new FilterManager();
        this.addFilters();
    }
    
    
    protected float getFitnessValue(ChromosomeIF chromosome){
        
        
        float valor = filter.processFilter(chromosome);
        return valor;
    }
    
   public void addFilters(){
       avaliarIndisponibilidades = new FilterAvaliarIndisponibilidades(this.disciplinas,this.professores);
       avaliarCargaHoraria = new FilterAvaliarCargaHoraria(this.disciplinas,this.professores);
       avaliarConflitos = new FilterAvaliarConflitos(this.disciplinas,this.professores);
       avaliarSequenciaDeDisciplinas = new FilterAvaliarSequenciaDeDisciplinas(this.disciplinas,this.professores);
       filter.addFilter(avaliarIndisponibilidades);
       filter.addFilter(avaliarCargaHoraria);
       filter.addFilter(avaliarConflitos);
       filter.addFilter(avaliarSequenciaDeDisciplinas);
   }
}    
   