/*
 * FilterAvaliarCargaHoraria.java
 *
 * Created on 30 de Outubro de 2006, 18:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.filter;
 
import br.com.kairos.jga.core.chromosome.ChromosomeIF;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import br.com.kairos.timetabling.objetos.Disciplina;
import br.com.kairos.timetabling.objetos.Professor;

public class FilterAvaliarCargaHoraria implements FilterIF{
    ArrayList disciplinas;
    TreeMap professores;
    TreeMap cargaHorariaSemanal;
    
    
    public FilterAvaliarCargaHoraria(ArrayList disciplinas, TreeMap professores){
        this.disciplinas=disciplinas;
        this.professores=professores;
    }
    
    public float execute(ChromosomeIF cromossomo){
        cargaHorariaSemanal=new TreeMap();
        int limite=cromossomo.getGenes().length/professores.size();
        float fitness=0;
        Iterator iteratorProfessor=professores.keySet().iterator();
        Professor professor=(Professor)professores.get(iteratorProfessor.next());
        Integer[] indisponibilidades=professor.getDisponibilidades();
        int i=0;
        int indiceDisp=0;
        while(i<cromossomo.getGenes().length){
            Integer codigoDisciplina=(Integer)cromossomo.getGene(i).getAllele();
            if(indisponibilidades[indiceDisp]!=0&&codigoDisciplina!=0){
                Disciplina disciplina=(Disciplina)disciplinas.get(codigoDisciplina-1);
                Professor profDisciplinaAtual=(Professor)professores.get(disciplina.getNomeProfessor());
                if(professor.getNome().equals(profDisciplinaAtual.getNome())){
                    fitness+=15;
                    this.definirCargaUtilizada(disciplina);
                }
            }
            i++;
            indiceDisp++;
            if(indiceDisp==limite){
                indiceDisp=0;
                if(iteratorProfessor.hasNext()){
                    professor=(Professor)professores.get(iteratorProfessor.next());
                    indisponibilidades=professor.getDisponibilidades();
                }
                fitness+=this.avaliarHorarioSemanal();
            }
        }
        return fitness;
    }
    
    public float avaliarHorarioSemanal(){
        float valorFitness=0;
        for(int i=0; i<disciplinas.size();i++){
            Disciplina disciplina = (Disciplina) disciplinas.get(i);
            if(cargaHorariaSemanal.containsKey(disciplina.getCodigoGA())){
                if ((Integer) cargaHorariaSemanal.get(disciplina.getCodigoGA())==disciplina.getCargaHorariaSemanal() ){
                    valorFitness += 10;
                }else{
                    if ((Integer) cargaHorariaSemanal.get(disciplina.getCodigoGA())>disciplina.getCargaHorariaSemanal() ){
                        valorFitness -= 15;
                    }else{
                        valorFitness -= 10;
                    }
                }
            }
        }
        cargaHorariaSemanal.clear();
        return valorFitness;
    }
    
    public void definirCargaUtilizada(Disciplina disciplina){
        int cargaHorariaUtilizada;
        if(cargaHorariaSemanal.get(disciplina.getCodigoGA())==null){
            cargaHorariaSemanal.put(disciplina.getCodigoGA(),1);
        }else{
            cargaHorariaUtilizada=(Integer)cargaHorariaSemanal.get(disciplina.getCodigoGA());
            cargaHorariaSemanal.put(disciplina.getCodigoGA(),(cargaHorariaUtilizada+1));
        }
    }
    
}
