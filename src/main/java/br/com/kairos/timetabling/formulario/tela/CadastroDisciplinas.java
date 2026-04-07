
package br.com.kairos.timetabling.formulario.tela;

 

import javax.swing.JColorChooser;

import br.com.kairos.timetabling.controle.ControleHorario;
import br.com.kairos.timetabling.model.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.*;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

public class CadastroDisciplinas extends javax.swing.JDialog{
    DefaultListModel<String> modelListaProfessor;
    DefaultListModel<String> modelListaTurmas;
    Professor professor;
    TreeMap professores;
    ControleHorario cHorario;
    boolean alterarDisciplina=false;
    Disciplina disciplinaASerAlterada;
    int count=0;
    
    public CadastroDisciplinas(ControleHorario controle) {
        initComponents();
        this.setTitle("Cadastro de Disciplinas");
        this.setModal(true);
        this.cHorario=controle;
        
        modelListaProfessor=new DefaultListModel();
        jListProfessores.setModel(modelListaProfessor);
        
        
        modelListaTurmas=new DefaultListModel();
        jListSemestres.setModel(modelListaTurmas);
        ArrayList turmas=cHorario.getSemestres();
        if(turmas!=null){
            for(int i=0;i<turmas.size();i++){
                String nomeTurma=(String)turmas.get(i);
                if(!modelListaTurmas.contains(nomeTurma)){
                    modelListaTurmas.addElement(nomeTurma);
                }
            }
        }
        
        professores=cHorario.getTodosProfessores();
        Iterator indiceTree=professores.keySet().iterator();
        while(indiceTree.hasNext()){
            professor=(Professor)professores.get(indiceTree.next());
            if(!modelListaProfessor.contains(professor.getNome())){
                modelListaProfessor.addElement(professor.getNome());
            }
        }
        
        
        
        jTextFieldNomeDisciplina.grabFocus();
    }
    public CadastroDisciplinas(ControleHorario controle, Disciplina materia) {
        initComponents();
        alterarDisciplina=true;
        disciplinaASerAlterada=materia;
        this.setTitle("Cadastro de Disciplinas");
        this.setModal(true);
        this.cHorario=controle;
        
        modelListaProfessor=new DefaultListModel();
        jListProfessores.setModel(modelListaProfessor);
        
        
        modelListaTurmas=new DefaultListModel();
        jListSemestres.setModel(modelListaTurmas);
        ArrayList turmas=cHorario.getSemestres();
        if(turmas!=null){
            for(int i=0;i<turmas.size();i++){
                String nomeTurma=(String)turmas.get(i);
                if(!modelListaTurmas.contains(nomeTurma)){
                    modelListaTurmas.addElement(nomeTurma);
                }
            }
        }
        
        professores=cHorario.getTodosProfessores();
        Iterator indiceTree=professores.keySet().iterator();
        while(indiceTree.hasNext()){
            professor=(Professor)professores.get(indiceTree.next());
            if(!modelListaProfessor.contains(professor.getNome())){
                modelListaProfessor.addElement(professor.getNome());
            }
        }      
        
        jTextFieldNomeDisciplina.setText(materia.getNome());
        jTextFieldSiglaDisciplina.setText(materia.getSigla());
        jTextFieldCargaHorariaDisciplina.setText(materia.getCargaHorariaSemanal()+"");
        jLabelCorDisciplina.setBackground(materia.getCor());
        jCheckBoxPrioridade.setSelected(materia.getPrioridade());
        jListProfessores.setSelectedValue(materia.getNomeProfessor(),true);
        jListSemestres.setSelectedValue(materia.getSemestre(),true);
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jButtonCancelar = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNomeDisciplina = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSiglaDisciplina = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCargaHorariaDisciplina = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButtonCorDisciplina = new javax.swing.JButton();
        jLabelCorDisciplina = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProfessores = new javax.swing.JList();
        jCheckBoxPrioridade = new javax.swing.JCheckBox();
        jLabelAdicionaProfessor = new javax.swing.JLabel();
        jLabelRemProfessor = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListSemestres = new javax.swing.JList();
        jLabelAdicionaTurma = new javax.swing.JLabel();

        setResizable(false);
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/cancelar.png")));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/salvar.png")));
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Gerais da Disciplina"));
        jLabel3.setText("Nome");

        jTextFieldNomeDisciplina.setFocusCycleRoot(true);
        jTextFieldNomeDisciplina.setNextFocusableComponent(jTextFieldSiglaDisciplina);

        jLabel5.setText("Sigla");

        jTextFieldSiglaDisciplina.setNextFocusableComponent(jTextFieldCargaHorariaDisciplina);

        jLabel4.setText("Carga Hor\u00e1ria Semanal");

        jTextFieldCargaHorariaDisciplina.setNextFocusableComponent(jListProfessores);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Cor"));
        jButtonCorDisciplina.setText("Cor");
        jButtonCorDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCorDisciplinaActionPerformed(evt);
            }
        });

        jLabelCorDisciplina.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCorDisciplina.setOpaque(true);

        // --- Configuração do jPanel6 ---
        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonCorDisciplina, GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelCorDisciplina, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelCorDisciplina, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCorDisciplina)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

// --- Configuração do jPanel1 ---
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextFieldCargaHorariaDisciplina, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                                        .addComponent(jTextFieldSiglaDisciplina, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextFieldNomeDisciplina, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldNomeDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldSiglaDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldCargaHorariaDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Professores"));
        jListProfessores.setNextFocusableComponent(jListSemestres);
        jScrollPane1.setViewportView(jListProfessores);

        jCheckBoxPrioridade.setText("Disciplina com prioridade alta para seu professor");
        jCheckBoxPrioridade.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBoxPrioridade.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabelAdicionaProfessor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAdicionaProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/+.png")));
        jLabelAdicionaProfessor.setToolTipText("Adcionar Professor");
        jLabelAdicionaProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdicionaProfessorMouseClicked(evt);
            }
        });

        jLabelRemProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/-.png")));
        jLabelRemProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRemProfessorMouseClicked(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);

        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jCheckBoxPrioridade, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(102, 102, 102))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabelAdicionaProfessor)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jLabelRemProfessor)
                                .addGap(3, 3, 3))
        );

        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelRemProfessor)
                                        .addComponent(jLabelAdicionaProfessor))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxPrioridade))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Semestre"));
        jScrollPane2.setViewportView(jListSemestres);

        jLabelAdicionaTurma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAdicionaTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/+.png")));
        jLabelAdicionaTurma.setToolTipText("Adcionar Professor");
        jLabelAdicionaTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdicionaTurmaMouseClicked(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(116, Short.MAX_VALUE)
                                .addComponent(jLabelAdicionaTurma, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAdicionaTurma)
                                .addGap(23, 23, 23))
        );

// --- Configuração do Layout Principal (ContentPane) ---
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButtonCadastrar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                // Removi o Alignment.TRAILING de dentro do addComponent e coloquei no ParallelGroup
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonCancelar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonCadastrar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-580)/2, (screenSize.height-551)/2, 700, 600);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jLabelRemProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRemProfessorMouseClicked
        ArrayList disciplinasProfessor=cHorario.getDisciplinasProfessor(jListProfessores.getSelectedValue().toString());
        if(disciplinasProfessor.isEmpty()){
            cHorario.getTodosProfessores().remove(jListProfessores.getSelectedValue());
            modelListaProfessor.removeElement(jListProfessores.getSelectedValue());
        }else{
            int deletaProfessor=JOptionPane.showConfirmDialog(this,"Com a exclusão desse professor, todas as suas disciplinas também serão excluídas.\n Continuar com exclusão?","Excluir Professor",0,2,new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/atencao.png")));
            if(deletaProfessor==0){
                ArrayList disciplinas=cHorario.getTodasDisciplinas();
                disciplinas.removeAll(disciplinasProfessor);
                cHorario.getTodosProfessores().remove(jListProfessores.getSelectedValue());
                modelListaProfessor.removeElement(jListProfessores.getSelectedValue());
            }
        }
    }//GEN-LAST:event_jLabelRemProfessorMouseClicked
    
    private void jButtonCorDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCorDisciplinaActionPerformed
        JColorChooser paletaCor=new JColorChooser();
        Color corDisciplina= JColorChooser.showDialog(null, "Cor da Disciplina", jLabelCorDisciplina.getBackground());
        if(corDisciplina!=null){
            jLabelCorDisciplina.setBackground(corDisciplina);
        }else{
            jLabelCorDisciplina.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jButtonCorDisciplinaActionPerformed
    
    private void jLabelAdicionaTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdicionaTurmaMouseClicked
        String nomeTurma="";
        try{
            nomeTurma=JOptionPane.showInputDialog(this,"Informe o nome da turma.","CadastrarTurma",1,new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/atencao.png")),null,null).toString();
            modelListaTurmas.addElement(nomeTurma);
            cHorario.cadastrarSemestre(nomeTurma);
        }catch(Exception e){}
    }//GEN-LAST:event_jLabelAdicionaTurmaMouseClicked
    
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed
    
    private void jLabelAdicionaProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdicionaProfessorMouseClicked
        String nomeProfessor="";
        try{
            nomeProfessor=JOptionPane.showInputDialog(this,"Informe o nome do professor.","Cadastrar Professor",1,new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/atencao.png")),null,null).toString();
            modelListaProfessor.addElement(nomeProfessor);
            cHorario.cadastrarProfessor(nomeProfessor);
        }catch(Exception e){}
    }//GEN-LAST:event_jLabelAdicionaProfessorMouseClicked
    
    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        String prof=(String)jListProfessores.getSelectedValue();
        String semestre=(String)jListSemestres.getSelectedValue();
        if(prof==null){
            JOptionPane.showMessageDialog(this,"Escolha um professor para a disciplina.","Mensagem",1,new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/pare.png")));
        }else{
            if(semestre==null){
                JOptionPane.showMessageDialog(this,"Escolha uma turma para a disciplina.","Mensagem",1,new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/pare.png")));
            }else{
                try{
                    Disciplina disciplina = new Disciplina(jTextFieldNomeDisciplina.getText(),
                            jTextFieldSiglaDisciplina.getText(),
                            prof,
                            jTextFieldCargaHorariaDisciplina.getText(),
                            jCheckBoxPrioridade.isSelected(),
                            semestre, jLabelCorDisciplina.getBackground());
                    if(!alterarDisciplina){
                        cHorario.cadastrarDisciplina(disciplina);
                    }else{
                        cHorario.alterarDisciplina(disciplinaASerAlterada.getCodigoGA(),disciplina);
                    }
                    this.dispose();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,"O campo Carga Horária deve ser numérico.","Mensagem",1,new javax.swing.ImageIcon(getClass().getResource("/timetabling/formulario/icones/pare.png")));
                }
            }
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCorDisciplina;
    private javax.swing.JCheckBox jCheckBoxPrioridade;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAdicionaProfessor;
    private javax.swing.JLabel jLabelAdicionaTurma;
    private javax.swing.JLabel jLabelCorDisciplina;
    private javax.swing.JLabel jLabelRemProfessor;
    private javax.swing.JList jListProfessores;
    private javax.swing.JList jListSemestres;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldCargaHorariaDisciplina;
    private javax.swing.JTextField jTextFieldNomeDisciplina;
    private javax.swing.JTextField jTextFieldSiglaDisciplina;
    // End of variables declaration//GEN-END:variables
    
}
