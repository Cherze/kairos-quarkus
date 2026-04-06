/*
 * Imprimir.java
 *
 * Created on 26 de Fevereiro de 2007, 15:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.kairos.timetabling.formulario.tela;

import br.com.kairos.timetabling.controle.*;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.io.font.constants.StandardFonts;

import javax.swing.*;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Imprimir {

    public Imprimir() {
    }

    public void imprime(ControleHorario controle, javax.swing.JTable jTableTimetabling) {
        try {
            // Solicita nome do arquivo
            String nomeArquivo = (String) JOptionPane.showInputDialog(null,
                    "Insira um nome para o arquivo a ser gerado.", "Imprimir...", 1,
                    new ImageIcon(getClass().getResource("/timetabling/formulario/icones/atencao.png")),
                    null, "HorarioParaImpressao.pdf");

            if (nomeArquivo == null || nomeArquivo.isEmpty()) return;

            // Inicializa o PDF moderno
            PdfWriter writer = new PdfWriter(new FileOutputStream(nomeArquivo));
            PdfDocument pdf = new PdfDocument(writer);
            Document documento = new Document(pdf, PageSize.A4);
            documento.setMargins(50, 50, 50, 50);

            // Título com fonte moderna
            PdfFont fontBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            Paragraph titulo = new Paragraph("KAIRÓS - Tabela de Horário para impressão:")
                    .setFont(fontBold)
                    .setFontSize(18)
                    .setFontColor(ColorConstants.BLUE)
                    .setMarginBottom(20);
            documento.add(titulo);

            int colunas = controle.getHorario().getDias().length;
            int linhas = controle.getHorario().getPeriodos();
            String[] dias = controle.getHorario().getDias();

            // Tabela de Cabeçalho (Dias)
            Table tabelaDias = new Table(UnitValue.createPercentArray(colunas)).useAllAvailableWidth();
            for (String dia : dias) {
                tabelaDias.addHeaderCell(new Cell()
                        .add(new Paragraph(dia).setFont(fontBold))
                        .setTextAlignment(TextAlignment.CENTER)
                        .setBackgroundColor(ColorConstants.LIGHT_GRAY));
            }
            documento.add(tabelaDias);

            // Tabela de Dados (Horários)
            Table tabelaCorpo = new Table(UnitValue.createPercentArray(colunas)).useAllAvailableWidth();
            tabelaCorpo.setMarginTop(10);

            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    ArrayList aux = (ArrayList) jTableTimetabling.getValueAt(i, j);
                    String conteudo = "";

                    if (aux != null && !aux.isEmpty()) {
                        int codigoGA = Integer.parseInt(aux.get(0).toString());
                        conteudo = controle.getDisciplina(codigoGA).getNome();
                    }

                    tabelaCorpo.addCell(new Cell()
                            .add(new Paragraph(conteudo).setFontSize(10))
                            .setPadding(3));
                }
            }

            documento.add(tabelaCorpo);
            documento.close();

            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar PDF ou horário não gerado.",
                    "Mensagem", JOptionPane.ERROR_MESSAGE,
                    new ImageIcon(getClass().getResource("/timetabling/formulario/icones/pare.png")));
        }
    }
}

