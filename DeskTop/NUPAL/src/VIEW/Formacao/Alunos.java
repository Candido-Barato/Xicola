

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW.Formacao;

import CONTROLER.AlunoControler;
import VIEW.Auxiliar;
import static VIEW.Auxiliar.auxJanela;
import VIEW.Janela;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Barato Soft Solution
 */
public class Alunos extends JPanel implements Janela{
    private JPanel jpCentro, jpPrincipal, jpTabela, jpSuperior;
    private JScrollPane barraRolagem;
    private JTable jtTabela;
    private DefaultTableModel modelo;
    private AlunoControler ac;

    @Override
    public void Config() {
        Start();
        modelo.addColumn("Codigo Aluno");
        modelo.addColumn("Nome Completo");
        modelo.addColumn("Estado");
        modelo.addColumn("Total de Servicos");
        modelo.addColumn("Data de Ingresso");
        jtTabela.setModel(modelo);
        
        auxJanela.addCamponenteJanela(jpTabela,barraRolagem, 'C');
        auxJanela.addCamponenteJanela(this, jpTabela, 'C');
        auxJanela.addCamponenteJanela(this, jpSuperior, 'N');
        auxJanela.addCamponenteJanela(jpTabela, auxJanela.separador(), 'W');
        auxJanela.addCamponenteJanela(jpTabela, auxJanela.separador(), 'E');
        auxJanela.addCamponenteJanela(jpTabela, auxJanela.separador(), 'S');
        ac.preencherModelo(modelo); //Busca dados dos Alunos
        
        //Configurar a Janela Superior
        auxJanela.addCamponenteJanela(jpSuperior, auxJanela.msg("Voltar",' '), 1, 1, 1, 1);
        
        
        Evento();

    }

    @Override
    public void Start() {
        jpCentro = auxJanela.jpPanel();
        jpPrincipal = auxJanela.jpPanel();
        jpSuperior = auxJanela.jpPanel();
        jpTabela = auxJanela.jpPanel();
        auxJanela.configBordaTitulo(this,"Alunos");
        auxJanela.configBordaTitulo(jpTabela,"Dados de Alunos");
        modelo = new DefaultTableModel();
        jtTabela = new JTable();
        auxJanela.setLayoutBord(this, 10, 10);
        auxJanela.setLayoutBord(jpTabela, 10, 10);
        auxJanela.setLayoutGridBag(jpSuperior);
        barraRolagem = new JScrollPane(jtTabela);
        barraRolagem.setBackground(null);
      
        this.setBackground(Color.DARK_GRAY);
        
        ac = new AlunoControler();
        
        
       
    }

    @Override
    public void Evento() {
    }
    
}
