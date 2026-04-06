/*
 * FilterAvaliarSequenciaDeDisciplinas.java
 *
 * Created on 25 de Maio de 2007, 16:13
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

public class FilterAvaliarSequenciaDeDisciplinas implements FilterIF{
    ArrayList disciplinas;
    TreeMap professores;
    /** Creates a new instance of FilterAvaliarSequenciaDeDisciplinas */
    public FilterAvaliarSequenciaDeDisciplinas(ArrayList disciplinas, TreeMap professores) {
        this.disciplinas=disciplinas;
        this.professores=professores;
    }
    
    public float execute(ChromosomeIF cromossomo){
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
                    if(indiceProfessor%2==0&& cromossomo.getGene(indiceProfessor+1).getAllele() ==codigoDisciplina){
                        fitness+=5;
                    }else{
                        fitness-=5;
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
        return fitness;
    }
}
