/*
 * ConfiguradorGA.java
 *
 * Created on 9 de Setembro de 2006, 11:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.controle;
 
import br.com.kairos.jga.core.*;
import br.com.kairos.jga.core.chromosome.*;
import br.com.kairos.timetabling.cromossomo.*;
import br.com.kairos.timetabling.fitness.FitnessHorario;
import br.com.kairos.jga.fitness.*;
import br.com.kairos.jga.mutation.*;
import br.com.kairos.jga.crossover.*;
import br.com.kairos.jga.selection.*;
import java.util.*;


public class ConfiguradorGA{
    private final PopulationFactoryIF popIF;
    private PopulationIF pop;
    private final FitnessIF fitness;
    private final SelectionIF selection;
    private final CrossoverIF crossover;
    private final MutationIF mutation;
    private final TerminateIF terminate;
    
    public ConfiguradorGA(TreeMap professores, ArrayList disciplinas, int qtdHorario) {
        int size=qtdHorario*professores.size();
        this.popIF = new DefaultPopulationFactory(
                new CromossomoHorario(size,disciplinas.size()+1));        
        this.fitness= new FitnessHorario(disciplinas,professores);
        this.selection= new BestSelection();
        this.crossover=new TwoPointCrossover();
        this.mutation=new FlipSwapGene();
        this.terminate=new TerminateHorario();
    }
    
    public PopulationFactoryIF getPopulationFactory() {
        return popIF;
    }
    
    public FitnessIF getFitness() {
        return this.fitness;
    }
    
    public SelectionIF getSelection() {
        return this.selection;
    }
    
    public CrossoverIF getCrossover() {
        return this.crossover;
    }
    
    public MutationIF getMutation() {
        return this.mutation;
    }
    
    public TerminateIF getTerminate() {
        return this.terminate;
    }
    
 }


