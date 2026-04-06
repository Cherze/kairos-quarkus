/*
 * ParametrosGA.java
 *
 * Created on 11 de Novembro de 2006, 18:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.controle;
 
import br.com.kairos.jga.core.GAParameterIF;
import java.io.BufferedReader;
import java.io.FileReader;

public class ParametrosGA implements GAParameterIF {
    FileReader reader;
    BufferedReader leitor;
    int popNum, geraNum;
    float selectPerc, mutaPerc, elitePerc;
    /** Creates a new instance of ParametrosGA */
    public ParametrosGA() {
        try{
            reader = new FileReader("Parametros.inf");
            leitor = new BufferedReader(reader);
            String linha;
            int numLinha=0;
            while ((linha = leitor.readLine()) != null) {
                if(numLinha==0){
                    popNum=Integer.parseInt(linha);
                }else if(numLinha==1){
                    selectPerc=Float.parseFloat(linha);
                }else if(numLinha==2){
                    mutaPerc=Float.parseFloat(linha);
                }else if(numLinha==3){
                    elitePerc=Float.parseFloat(linha);
                }else if(numLinha==4){
                    geraNum=Integer.parseInt(linha);
                }
                numLinha++;
            }
        }catch(Exception e){
            
        }
    }
    
    public int getPopulationSize() {
        return popNum;
    }
    
    public float getSelectionPercent() {
        return selectPerc;
    }
    
    public float getMutationPercent() {
        return mutaPerc;
    }
    
    public float getNumeroElitismo(){
        return elitePerc;
    }
    public int getGeracaoTotal(){
        return geraNum;
    }
}
