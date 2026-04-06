/*
 * FilterAvaliarConflitos.java
 *
 * Created on 20 de Maio de 2007, 12:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.filter;
 
import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import br.com.kairos.timetabling.cromossomo.CromossomoHorario;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import br.com.kairos.timetabling.objetos.Disciplina;
import br.com.kairos.timetabling.objetos.Professor;

public class FilterAvaliarConflitos implements FilterIF{
    ArrayList disciplinas;
    TreeMap professores;
    TreeMap semestres;
    /** Creates a new instance of FilterAvaliarConflitos */
    public FilterAvaliarConflitos(ArrayList disciplinas, TreeMap professores) {
        this.disciplinas=disciplinas;
        this.professores=professores;
    }
    
    public float execute(ChromosomeIF cromossomo){
        semestres=new TreeMap();
        int limite=cromossomo.getGenes().length/professores.size();
        float fitness=0;
        Iterator iteratorProfessor=professores.keySet().iterator();
        Professor professor=(Professor)professores.get(iteratorProfessor.next());
        Integer[] indisponibilidades=professor.getDisponibilidades();
        int i=0;
        int indiceProfessor=0;
        while(i<cromossomo.getGenes().length){
            Integer codigoDisciplina=(Integer)cromossomo.getGene(i).getAllele();
            if(indisponibilidades[indiceProfessor]!=0&&codigoDisciplina!=0){
                Disciplina disciplina=(Disciplina)disciplinas.get(codigoDisciplina-1);
                Professor profDisciplinaAtual=(Professor)professores.get(disciplina.getNomeProfessor());
                if(professor.getNome().equals(profDisciplinaAtual.getNome())){
                    if(!semestres.containsKey(disciplina.getSemestre())){
                        ArrayList conflitos=new ArrayList();
                        conflitos.add(indiceProfessor);
                        semestres.put(disciplina.getSemestre(),conflitos);
                    }else{
                        ArrayList conflitos=(ArrayList)semestres.get(disciplina.getSemestre());
                        conflitos.add(indiceProfessor);
                    }
                }
            }
            i++;
            indiceProfessor++;
            if(indiceProfessor==limite){
                indiceProfessor=0;
                if(iteratorProfessor.hasNext()){
                    professor=(Professor)professores.get(iteratorProfessor.next());
                    indisponibilidades=professor.getDisponibilidades();
                }
            }
        }
        float conflitos=this.avaliarConflitos();
        if (conflitos==0){
            fitness+=25;
        }else{
            fitness=conflitos;
        }
        semestres.clear();
        return fitness;
    }
    
    public float avaliarConflitos(){
        float valorFitness=0;
        Iterator iteratorSemestres=semestres.keySet().iterator();
        while(iteratorSemestres.hasNext()){
            ArrayList conflitos=(ArrayList)semestres.get(iteratorSemestres.next());
            valorFitness-=this.quantidadeConflitos(conflitos);
        }
        return valorFitness;
    }
    
    public float quantidadeConflitos(ArrayList conflitos){
        int qtdConflitos=0;
        while(!conflitos.isEmpty()){
            Object aux=conflitos.get(0);
            conflitos.remove(0);
            while(conflitos.remove(aux)){
                qtdConflitos++;
            }
        }
        return qtdConflitos*10;
    }
}
