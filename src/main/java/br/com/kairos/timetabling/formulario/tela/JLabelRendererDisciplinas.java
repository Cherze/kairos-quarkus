/*
 * JLabelRendererDisciplinas.java
 *
 * Created on 4 de Janeiro de 2007, 18:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.formulario.tela;

 
import java.awt.Component;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import javax.swing.BorderFactory;
import java.awt.Color;
import br.com.kairos.timetabling.controle.ControleHorario;
import java.util.ArrayList;

public class JLabelRendererDisciplinas extends JLabel implements TableCellRenderer{
    ControleHorario controle;
    /** Creates a new instance of JlabelRenderer */
    public JLabelRendererDisciplinas(ControleHorario c) {
        controle=c;
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int rowIndex, int vColIndex) {
        ArrayList arrayChoqueDisciplinas = (ArrayList)value;
        if(!arrayChoqueDisciplinas.isEmpty()) {
            if(arrayChoqueDisciplinas.size() == 1) {
                int codigoGA = Integer.valueOf(arrayChoqueDisciplinas.get(0).toString()).intValue();
                setText(controle.getDisciplina(codigoGA).getSigla());
                setToolTipText(controle.getDisciplina(codigoGA).getNome());
                setBorder(BorderFactory.createEtchedBorder());
                setBackground(controle.getDisciplina(codigoGA).getCor());
                setForeground(new Color(0, 0, 0));
            } else {
                setText("CONFLITO");
                String nomeDisciplinasEmConflito="";
                for(int i=0;i<arrayChoqueDisciplinas.size();i++){
                    int codigoGA = Integer.valueOf(arrayChoqueDisciplinas.get(i).toString()).intValue();
                    nomeDisciplinasEmConflito+=controle.getDisciplina(codigoGA).getNome()+" \n ";
                }
                setToolTipText(nomeDisciplinasEmConflito);
                setBorder(BorderFactory.createEtchedBorder());
                setBackground(new Color(255, 0, 0));
                setForeground(new Color(255, 255, 255));
            }
        } else {
            setText("");
            setBorder(BorderFactory.createEtchedBorder());
            setBackground(new Color(255, 255, 255));
            setForeground(new Color(0, 0, 0));
            
        }
        if(isSelected) {
            setBorder(BorderFactory.createLineBorder(new Color(52, 108, 222)));
            setBackground(new Color(221, 225, 233));
            setOpaque(true);
        } else {
            setOpaque(true);
        }
        setHorizontalAlignment(CENTER);
        return this;
        
    }
    
}
