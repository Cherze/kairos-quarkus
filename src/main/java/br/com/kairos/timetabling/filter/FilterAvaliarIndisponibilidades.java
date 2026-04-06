
/*
 * FilterAvaliaIndisponibilidades.java
 *
 * Created on 30 de Outubro de 2006, 17:30
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

public class FilterAvaliarIndisponibilidades implements FilterIF{
    ArrayList disciplinas;
    TreeMap professores;
    
    public FilterAvaliarIndisponibilidades(ArrayList disciplinas, TreeMap professores){
        this.disciplinas=disciplinas;
        this.professores=professores;
    }
    
    public float execute(ChromosomeIF cromossomo){
        int limite=cromossomo.getGenes().length/professores.size();
        float fitness=0;
        Iterator iteratorProfessor=professores.keySet().iterator();
        Professor professor=(Professor)professores.get(iteratorProfessor.next());
        int i=0;
        int indiceDisp=0;
        while(i<cromossomo.getGenes().length){
            Integer codigoDisciplina=(Integer)cromossomo.getGene(i).getAllele();
            if(codigoDisciplina!=0){
                Disciplina disciplina=(Disciplina)disciplinas.get(codigoDisciplina-1);
                Professor profDisciplinaAtual=(Professor)professores.get(disciplina.getNomeProfessor());
                if(professor.getNome().equals(profDisciplinaAtual.getNome())){
                    float valor = this.avaliarIndisponibilidade(disciplina,profDisciplinaAtual, indiceDisp);
                    fitness+=valor;
                }
            }
            i++;
            indiceDisp++;
            if(indiceDisp==limite){
                indiceDisp=0;
                if(iteratorProfessor.hasNext()){
                    professor=(Professor)professores.get(iteratorProfessor.next());
                }
            }
        }
        return fitness;
    }
    
    public float avaliarIndisponibilidade(Disciplina disciplina, Professor professor, int indiceDisp){
        float valor=0;
        Integer[] disponibilidadeProf=professor.getDisponibilidades();
        if(disciplina.getPrioridade()){
            if(disponibilidadeProf[indiceDisp]==2){
                valor+=5;
            }else{
                if(disponibilidadeProf[indiceDisp]==1){
                    valor+=3;
                }else{
                    valor-=2;
                }
            }
        }else{
            if(disponibilidadeProf[indiceDisp]==2){
                valor+=4;
            }else{
                if(disponibilidadeProf[indiceDisp]==1){
                    valor+=2 ;
                }else{
                    valor-=1;
                }
            }
        }
        
        return valor;
    }
    
}
