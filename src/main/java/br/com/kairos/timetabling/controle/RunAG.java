/*
 * RunAG.java
 *
 * Created on 16 de Janeiro de 2007, 19:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.controle;
 

import java.util.*;
import br.com.kairos.jga.core.TerminateIF;
import br.com.kairos.jga.core.events.Generation;
import br.com.kairos.jga.crossover.CrossoverIF;
import br.com.kairos.jga.mutation.MutationIF;
import br.com.kairos.jga.selection.SelectionIF;
import br.com.kairos.timetabling.formulario.tela.BarraDeProgresso;
import br.com.kairos.jga.core.chromosome.*;
import br.com.kairos.jga.fitness.*;
import br.com.kairos.jga.core.events.NewGenerationEvent;
import br.com.kairos.jga.core.events.NewGenerationListener;
import javax.swing.event.EventListenerList;

public class RunAG {
    protected EventListenerList listenerList = new EventListenerList();
    PopulationIF populacao;
    ConfiguradorGA configuracao;
    ParametrosGA parametro;
    TreeMap listaProfessores;
    ArrayList listaDisciplinas;
    int qtdHorario;
    /** Creates a new instance of RunAG */
    public RunAG(ControleHorario controle){
        listaProfessores=controle.getTodosProfessores();
        listaDisciplinas=controle.getTodasDisciplinas();
        qtdHorario=controle.getQtdHorario();
    }
    
    public List iniciarAG(BarraDeProgresso progresso){
        int genNumber=0;
        configuracao=new ConfiguradorGA(listaProfessores,listaDisciplinas,qtdHorario);
        parametro=new ParametrosGA();
        FitnessIF fitness=configuracao.getFitness();
        SelectionIF selecao=configuracao.getSelection();
        CrossoverIF crossover=configuracao.getCrossover();
        MutationIF mutacao=configuracao.getMutation();
        TerminateIF terminate=configuracao.getTerminate();
        populacao = configuracao.getPopulationFactory().makePopulation(parametro.getPopulationSize());
        fitness.evaluate(populacao);
        this.fireNewGenerationEvent(new NewGenerationEvent(new Generation(genNumber, populacao)));
        do{
            genNumber++;
            progresso.setProgressBarValue(genNumber*100/parametro.getGeracaoTotal());
            populacao=selecao.select(populacao,parametro.getSelectionPercent());
            populacao=crossover.makeOffspring(populacao,populacao.size());
            mutacao.mutate(populacao,parametro.getMutationPercent());
            fitness.evaluate(populacao);
            this.fireNewGenerationEvent(new NewGenerationEvent(new Generation(genNumber, populacao)));
            System.gc();
            Thread.yield();
        }while(!terminate.stop(new Generation(genNumber,populacao))&&!progresso.cancelado());
        List lista=populacao.getAllChromosomes();
        return lista;
    }
    
    public void fireNewGenerationEvent(NewGenerationEvent  evt) {
        Object[] listeners = listenerList.getListenerList();
        for (int i=0; i<listeners.length; i+=2) {
            if (listeners[i]==NewGenerationListener.class) {
                ((NewGenerationListener)listeners[i+1]).notifyNewGeneration(evt);
            }
        }
    }
}
