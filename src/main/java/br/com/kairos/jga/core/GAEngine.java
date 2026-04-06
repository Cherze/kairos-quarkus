/*
 * GAEngine.java
 *
 * Created on 12 de Mar  ço de 2006, 22:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.jga.core;

import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import br.com.kairos.jga.core.chromosome.PopulationIF;
import br.com.kairos.jga.core.events.Generation;
import br.com.kairos.jga.core.events.NewGenerationEvent;
import br.com.kairos.jga.core.events.NewGenerationListener;
import br.com.kairos.jga.crossover.CrossoverIF;
import br.com.kairos.jga.fitness.FitnessIF;
import br.com.kairos.jga.mutation.MutationIF;
import br.com.kairos.jga.selection.SelectionIF;

import javax.swing.event.EventListenerList;


public class GAEngine {
    
    /** Creates a new instance of GAEngine */
    
    private final GAConfiguratorIF gaConfiguratorIF;
    private final GAParameterIF gaParameterIF;
    private PopulationIF pop;
    
    protected EventListenerList listenerList = new EventListenerList();
    
    
    public GAEngine(GAConfiguratorIF gaConfiguratorIF, GAParameterIF gaParameterIF) {
        this.gaConfiguratorIF = gaConfiguratorIF;
        this.gaParameterIF = gaParameterIF;
    }
    
    
    public void run(){
        int genNumber=1;
        FitnessIF fitness = gaConfiguratorIF.getFitness();
        SelectionIF selection = gaConfiguratorIF.getSelection();
        CrossoverIF crossover = gaConfiguratorIF.getCrossover();
        MutationIF mutation = gaConfiguratorIF.getMutation();
        TerminateIF terminate = gaConfiguratorIF.getTerminate();
        pop = gaConfiguratorIF.getPopulationFactory().makePopulation(gaParameterIF.getPopulationSize());
        fitness.evaluate(pop);
        this.fireNewGenerationEvent(new NewGenerationEvent(new Generation(genNumber, pop)));
        do{
            PopulationIF selected = selection.select(pop, gaParameterIF.getSelectionPercent());
            pop = crossover.makeOffspring(pop, gaParameterIF.getPopulationSize());
            mutation.mutate(pop, gaParameterIF.getMutationPercent());
            fitness.evaluate(pop);
            genNumber++;
            this.fireNewGenerationEvent(new NewGenerationEvent(new Generation(genNumber, pop)));
            System.gc();
            Thread.yield();
        }while(!terminate.stop(new Generation(genNumber, pop)));
        
    }
    
    public PopulationIF getPopulation(){
        return this.pop;
    }
    
    public ChromosomeIF getBestSolution(){
        this.pop.sort();
        return this.pop.getChromosome(0);
    }
    
    
    public void addNewGenerationListener(NewGenerationListener listener){
         listenerList.add(NewGenerationListener.class, listener);
    }
    
    
    public void removeNewGenerationListener(NewGenerationListener listener){  
        listenerList.remove(NewGenerationListener.class, listener);
    }
    
    public void fireNewGenerationEvent(NewGenerationEvent  evt) {
            Object[] listeners = listenerList.getListenerList();
            // Each listener occupies two elements - the first is the listener class
            // and the second is the listener instance
            for (int i=0; i<listeners.length; i+=2) {
                if (listeners[i]==NewGenerationListener.class) {
                    ((NewGenerationListener)listeners[i+1]).notifyNewGeneration(evt);
                }
            }
    }        
    
}
