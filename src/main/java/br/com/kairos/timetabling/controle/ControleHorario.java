/*
 * ControleHorario.java
 *
 * Created on 9 de Setembro de 2006, 09:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.controle;
 

import java.util.*;
import br.com.kairos.timetabling.objetos.*;

public class ControleHorario {
    ArrayList grupoDisciplinas = new ArrayList();
    ArrayList listaDisciplinas=new ArrayList();
    ArrayList listaSemestres=new ArrayList();
    TreeMap listaProfessores=new TreeMap();
    private final Horario horario=new Horario();
    
    public ControleHorario() {
        
    }
    
    public void cadastrarProfessor(String nome){
        Professor professor=new Professor(nome);
        professor.zeraDisponibilidades(horario.getNumeroHorarios());
        listaProfessores.put(nome,professor);
    }
    
    public int getQtdProfessor(){
        return listaProfessores.size();
    }
    
    public void cadastrarDisciplina(Disciplina disciplina){
        int codigoGA=listaDisciplinas.size();
        codigoGA++;
        disciplina.setCodigoGA(codigoGA);
        listaDisciplinas.add(disciplina);
    }
    
    public void setSemestre(String semestre, String nomeDisciplina){
        Disciplina disciplina=(Disciplina)listaDisciplinas.get(0);
        int i=1;
        while((i<listaDisciplinas.size())&&(!disciplina.getNome().equalsIgnoreCase(nomeDisciplina))){
            disciplina=(Disciplina)listaDisciplinas.get(i);
            i++;
        }
        if(disciplina.getNome().equalsIgnoreCase(nomeDisciplina)){
            disciplina.setSemestre(semestre);
        }
    }
    
    public ArrayList getGrupos(){
        return grupoDisciplinas;
    }
    
    public int getQtdDisciplinas(){
        return listaDisciplinas.size();
    }
    
    public Horario getHorario(){
        return horario;
    }
    
    public int getQtdHorario(){
        return horario.getNumeroHorarios();
    }
    
    public TreeMap getTodosProfessores(){
        return listaProfessores;
    }
    
    public ArrayList getTodasDisciplinas(){
        return listaDisciplinas;
    }
    
    public Professor getProfessor(String nome){
        return (Professor)listaProfessores.get(nome);
    }
    
    public Disciplina getDisciplina(int codigoGA){
        return (Disciplina)listaDisciplinas.get(codigoGA-1);
    }
    
    public Disciplina getDisciplina(String nome){
        Disciplina disciplina;
        int i=0;
        disciplina=(Disciplina)listaDisciplinas.get(i);
        while((i<listaDisciplinas.size())&&(!disciplina.getNome().equalsIgnoreCase(nome))){
            i++;
            disciplina=(Disciplina)listaDisciplinas.get(i);
        }
        if(disciplina.getNome().equalsIgnoreCase(nome)){
            return disciplina;
        }
        return null;
    }
    
    public void cadastrarSemestre(String nomeSemestre){
        listaSemestres.add(nomeSemestre);
    }
    
    public ArrayList getSemestres(){
        return listaSemestres;
    }
    
    public void alterarDisciplina(int codigo,Disciplina d){
        d.setCodigoGA(codigo);
        getTodasDisciplinas().set(codigo-1,d);
    }
    
    public int getOrdemProfessorNoCromossomo(String nomeProfessor){
        int posicao=0;
        Iterator professores=this.getTodosProfessores().keySet().iterator();
        Professor professor = (Professor)this.getTodosProfessores().get(professores.next());
        while((professores.hasNext())&&(!professor.getNome().equals(nomeProfessor))){
            posicao++;
            professor = (Professor)this.getTodosProfessores().get(professores.next());
        }
        return posicao;
    }
    
    public ArrayList getDisciplinasProfessor(String nomeProfessor){
        ArrayList disciplinasProfessor=new ArrayList();
        for(int i=0;i<this.getTodasDisciplinas().size();i++){
            Disciplina disciplina=(Disciplina)this.getTodasDisciplinas().get(i);
            if(disciplina.getNomeProfessor().equals(nomeProfessor)){
                disciplinasProfessor.add(disciplina);
            }
        }
        return disciplinasProfessor;
    }
}
