/*
 * BancoOO.java
 *
 * Created on 16 de Janeiro de 2007, 18:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.objetos;
 
import java.io.File;
import com.db4o.*;
import br.com.kairos.timetabling.controle.ControleHorario;
import br.com.kairos.jga.core.chromosome.ChromosomeIF;
public class BancoOO {
    ObjectContainer db;
    String nomeArquivoBanco="";
    String nomeArquivoHorario="";
    /** Creates a new instance of BancoOO */
    public BancoOO() {
    }
    public void salvarDados(ControleHorario controle){
            new File(nomeArquivoBanco).delete();
            db=Db4o.openFile(nomeArquivoBanco);
            try{
                db.set(controle);
            }finally{
                db.close();
            }
    }
    public void salvarHorario(ChromosomeIF cromossomoBest){
        new File(nomeArquivoHorario).delete();
        db=Db4o.openFile(nomeArquivoHorario);
        try{
            db.set(cromossomoBest);
        }finally{
            db.close();
        }
    }
    public ControleHorario restaurarBaseDados(){
        db=Db4o.openFile(nomeArquivoBanco);
        ControleHorario controle;
        try{
            ObjectSet result=db.get(ControleHorario.class);
            controle=(ControleHorario)result.next();
        }finally{
            db.close();
        }
        return controle;
    }
    public ChromosomeIF restaurarHorario(){
        db=Db4o.openFile(nomeArquivoHorario);
        ChromosomeIF cromossomoBest;
        try{
            ObjectSet result=db.get(ChromosomeIF.class);
            cromossomoBest=(ChromosomeIF)result.next();
        }finally{
            db.close();
        }
        return cromossomoBest;
    }
    public void setNomeArquivoBanco(String nome){
        if(!nome.equals("")){
            this.nomeArquivoBanco=nome;
        }else{
            this.nomeArquivoBanco="NovoArquivoBanco.kdb";
        }
    }
    public void setNomeArquivoHorario(String nome){
        if(!nome.equals("")){
            this.nomeArquivoHorario=nome;
        }else{
            this.nomeArquivoHorario="NovoArquivoHorario.krs";
        }
    }
    public String getNomeArquivoBanco(){
        return this.nomeArquivoBanco;
    }
    public String getNomeArquivoHorario(){
        return this.nomeArquivoHorario;
    }
}
