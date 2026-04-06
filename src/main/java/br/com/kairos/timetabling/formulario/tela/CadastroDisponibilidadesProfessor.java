
/*
 * CadastroDisponibilidadesProfessor.java
 *
 * Created on 25 de Agosto de 2006, 23:09
 */

package br.com.kairos.timetabling.formulario.tela;
 
import java.awt.Component;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import br.com.kairos.timetabling.objetos.*;
import br.com.kairos.timetabling.controle.*;
import java.util.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

public class CadastroDisponibilidadesProfessor extends javax.swing.JDialog {
    private final Horario horario;
    private final ControleHorario controle;
    private final DefaultListModel modelListaProfessores=new DefaultListModel();
    private final DefaultTableModel modelTabelaDisponibilidades=new DefaultTableModel(){
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }};
        private Integer[] disponibilidades;
        
        
        /** Creates new form CadastroDisponibilidadesProfessor */
        public CadastroDisponibilidadesProfessor(ControleHorario c) {
            initComponents();
            this.setTitle("Disponibilidades do Professor");
            this.setBounds(100,100, 600, 430);
            this.setModal(true);
            this.horario=c.getHorario();
            this.controle=c;
            
            jListProfessores.setModel(modelListaProfessores);
            Professor professor;
            Iterator professores=controle.getTodosProfessores().keySet().iterator();
            while(professores.hasNext()){
                professor = (Professor)controle.getTodosProfessores().get(professores.next());
                modelListaProfessores.addElement(professor.getNome());
            }
            
            jTableDisponibilidades.setModel(modelTabelaDisponibilidades);
            String[] dias=new String[horario.getDias().length+1];
            String[] diasHorario=horario.getDias();
            dias[0]="Horário";
            System.arraycopy(diasHorario, 0, dias, 1, dias.length - 1);
            modelTabelaDisponibilidades.setColumnCount(dias.length);
            modelTabelaDisponibilidades.setNumRows(horario.getPeriodos());
            modelTabelaDisponibilidades.setColumnIdentifiers(dias);
            for(int i=1;i<jTableDisponibilidades.getColumnCount();i++){
                if(i<=jTableDisponibilidades.getRowCount()){
                    modelTabelaDisponibilidades.setValueAt(i,i-1,0);
                }
            }
            jTableDisponibilidades.setRowHeight(30);
            jTableDisponibilidades.setEnabled(false);
        }
        
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisponibilidades = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListProfessores = new javax.swing.JList();

        setAlwaysOnTop(true);
        setResizable(false);
        jTableDisponibilidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            final boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDisponibilidades.setCellSelectionEnabled(true);
        jTableDisponibilidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDisponibilidadesMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(jTableDisponibilidades);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14));
        jLabel1.setText("Selecione o Professor:");

        jButtonOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/salvar.png")));
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/cancelar.png")));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("LEGENDA:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/NaoPode.png")));
        jLabel3.setText("- N\u00e2o Pode");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/Pode.png")));
        jLabel4.setText("- Pode");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/Quer.png")));
        jLabel5.setText("- Quer");

        jListProfessores.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jListProfessores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListProfessoresKeyReleased(evt);
            }
        });
        jListProfessores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProfessoresMouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(jListProfessores);

        // --- Configuração do Layout do ContentPane ---
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                                                                .addComponent(jButtonOK, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(62, 62, 62)))
                                .addContainerGap())
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonOK, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-630)/2, (screenSize.height-354)/2, 630, 354);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jListProfessoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListProfessoresKeyReleased
        String nomeProfessor =(String)jListProfessores.getSelectedValue();
        Professor professor=controle.getProfessor(nomeProfessor);
        for(int i=1;i<jTableDisponibilidades.getColumnCount();i++){
            jTableDisponibilidades.getColumn(jTableDisponibilidades.getColumnName(i)).setCellRenderer(
                    new JlabelRendererDisponibilidades());
            for(int j=0;j<jTableDisponibilidades.getRowCount();j++){
                modelTabelaDisponibilidades.setValueAt(professor.getDisponibilidade((i*jTableDisponibilidades.getRowCount()+j)-jTableDisponibilidades.getRowCount()),j,i);
            }
        }
    }//GEN-LAST:event_jListProfessoresKeyReleased
    
    private void jListProfessoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProfessoresMouseClicked
        jTableDisponibilidades.setEnabled(true);
        String nomeProfessor =(String)jListProfessores.getSelectedValue();
        Professor professor=controle.getProfessor(nomeProfessor);
        for(int i=1;i<jTableDisponibilidades.getColumnCount();i++){
            jTableDisponibilidades.getColumn(jTableDisponibilidades.getColumnName(i)).setCellRenderer(
                    new JlabelRendererDisponibilidades());
            for(int j=0;j<jTableDisponibilidades.getRowCount();j++){
                modelTabelaDisponibilidades.setValueAt(professor.getDisponibilidade((i*jTableDisponibilidades.getRowCount()+j)-jTableDisponibilidades.getRowCount()),j,i);
            }
        }
    }//GEN-LAST:event_jListProfessoresMouseClicked
    
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed
    
    private void jTableDisponibilidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDisponibilidadesMouseClicked
        int linha=jTableDisponibilidades.rowAtPoint(evt.getPoint());
        int coluna=jTableDisponibilidades.columnAtPoint(evt.getPoint());
        int opcao=(Integer)jTableDisponibilidades.getValueAt(linha,coluna);
        if(coluna!=0){
            if(opcao==0){
                jTableDisponibilidades.setValueAt(1,linha,coluna);
            }else{
                if(opcao==1){
                    jTableDisponibilidades.setValueAt(2,linha,coluna);
                }else{
                    jTableDisponibilidades.setValueAt(0,linha,coluna);
                }
            }
        }
    }//GEN-LAST:event_jTableDisponibilidadesMouseClicked
    
    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        Professor prof=null;
        String nomeProfessor =(String)jListProfessores.getSelectedValue();
        disponibilidades=new Integer[(jTableDisponibilidades.getColumnCount()-1)*jTableDisponibilidades.getRowCount()];
        int aux=0;
        prof= controle.getProfessor(nomeProfessor);
        for(int i=1;i<jTableDisponibilidades.getColumnCount();i++){
            for(int j=0;j<jTableDisponibilidades.getRowCount();j++){
                disponibilidades[aux]=(Integer)jTableDisponibilidades.getValueAt(j,i);
                if(disponibilidades[aux]!=0){
                    jTableDisponibilidades.setValueAt(0,j,i);
                }
                aux++;
            }
        }
        prof.addDisponibilidades(disponibilidades);
        jTableDisponibilidades.transferFocusBackward();
        
    }//GEN-LAST:event_jButtonOKActionPerformed
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jListProfessores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDisponibilidades;
    // End of variables declaration//GEN-END:variables
    
}
