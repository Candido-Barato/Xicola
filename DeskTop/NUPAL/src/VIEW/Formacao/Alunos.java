/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW.Formacao;

import CONTROLER.AlunoControler;
import CONTROLER.Cadastro_Aluno_Controler;
import static VIEW.Auxiliar.auxJanela;
import static VIEW.Auxiliar.tr;
import VIEW.Formacaoo;
import static VIEW.Home.addPainelCentro;
import VIEW.Janela;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Barato Soft Solution
 */
public class Alunos extends JPanel implements Janela {

    private JPanel jpCentro, jpPrincipal, jpTabela, jpSuperior, jpBotao, jpPesquisa, jpExplore, jpVer;
    private JScrollPane barraRolagem;
    private JTable jtTabela;
    private DefaultTableModel modelo;
    private AlunoControler ac;
    private JButton jbPrint, jbCadastrar, jbVoltar, jbFiltrar, jbPesquisa;
    private JTextField jtPesquisa;
    private ExplorarAluno exp;
    public static Cadastro_Aluno_Controler cr;

    @Override
    public void Config() {
        Start();
        modelo.addColumn("Codigo Aluno");
        modelo.addColumn("Nome Completo");
        modelo.addColumn("Estado");
        modelo.addColumn("Total de Servicos");
        modelo.addColumn("Data de Ingresso");
        jtTabela.setModel(modelo);

        auxJanela.addCamponenteJanela(this, jpTabela, 'C');
        auxJanela.addCamponenteJanela(this, jpSuperior, 'N');
        auxJanela.addCamponenteJanela(this, jpExplore, 'E');
        auxJanela.addCamponenteJanela(jpTabela, barraRolagem, 'C');
        auxJanela.addCamponenteJanela(jpTabela, exp, 'W');
        auxJanela.addCamponenteJanela(jpTabela, auxJanela.separador(), 'E');
        auxJanela.addCamponenteJanela(jpTabela, auxJanela.separador(), 'S');
        ac.preencherModelo(modelo); //Busca dados dos Alunos

        //Configurar a Janela Superior
        auxJanela.addCamponenteJanela(jpBotao, jbPrint, 3, 1, 1, 1);
        auxJanela.addCamponenteJanela(jpBotao, jbCadastrar, 5, 1, 1, 1);
        auxJanela.addCamponenteJanela(jpBotao, jbFiltrar, 7, 1, 1, 1);
        auxJanela.addCamponenteJanela(jpPesquisa, jtPesquisa, 1, 1, 1, 1);
        auxJanela.addCamponenteJanela(jpPesquisa, jbPesquisa, 2, 1, 1, 1);

        auxJanela.addCamponenteJanela(jpSuperior, jpBotao, 'C');
        auxJanela.addCamponenteJanela(jpSuperior, jbVoltar, 'W');
        auxJanela.addCamponenteJanela(jpSuperior, jpPesquisa, 'E');

        jpExplore.add(auxJanela.msg("Filtrar", ' '));

        Evento();

    }

    @Override
    public void Start() {
        jpCentro = auxJanela.jpPanel();
        jpPrincipal = auxJanela.jpPanel();
        jpBotao = auxJanela.jpPanel();
        jpSuperior = auxJanela.jpPanel();
        jpPesquisa = auxJanela.jpPanel();
        jpTabela = auxJanela.jpPanel();
        jpExplore = auxJanela.jpPanel();
        jpVer = auxJanela.jpPanel();
        jtTabela = new JTable();
        jtPesquisa = new JTextField("Pesquisar", 20);
        auxJanela.configBordaTitulo(this, "Alunos");
        auxJanela.configBordaTitulo(jpTabela, "Dados de Alunos");
        modelo = new DefaultTableModel();

        auxJanela.setLayoutBord(this, 10, 10);
        auxJanela.setLayoutBord(jpTabela, 10, 10);
        auxJanela.setLayoutBord(jpSuperior, 0, 0);
        auxJanela.setLayoutGridBag(jpBotao);
        auxJanela.setLayoutGridBag(jpVer);
        auxJanela.setLayoutGridBag(jpPesquisa);
        auxJanela.setLayoutGrid(jpExplore, 2, 1, 5, 5);

        barraRolagem = new JScrollPane(jtTabela);
        barraRolagem.setBackground(null);

        jbVoltar = auxJanela.ConfigBotao("Voltar");
        jbPesquisa = auxJanela.ConfigBotao("");
        jbFiltrar = auxJanela.ConfigBotao("Filtrar");
        jbPrint = auxJanela.ConfigBotao("Imprimir");
        jbCadastrar = auxJanela.ConfigBotao("Cadastrar");
        jbPrint.setIcon(tr.criarImage("/IMG/Componentes/impresora_icono-200x200.png", 50, 50));
        jbCadastrar.setIcon(tr.criarImage("/IMG/Componentes/AddTrab.png", 50, 50));
        jbFiltrar.setIcon(tr.criarImage("/IMG/Componentes/Filtro.png", 50, 50));
        jbPesquisa.setIcon(tr.criarImage("/IMG/Componentes/Pesquisa.png", 50, 50));
        this.setBackground(Color.DARK_GRAY);
        jpSuperior.setBackground(auxJanela.getCorBotao());
        exp = new ExplorarAluno();
        exp.Config();
        ac = new AlunoControler();
        

    }

    @Override
    public void Evento() {
        jbVoltar.addActionListener((ae) -> {
            Formacaoo form = new Formacaoo();
            form.Config();
            addPainelCentro(form);
        });
        jbCadastrar.addActionListener((ae) -> {
            cr = new Cadastro_Aluno_Controler();
            addPainelCentro(cr.getCadastrarAluno());
            
        });
        jbPrint.addActionListener((ae) -> {
        });
        jbFiltrar.addActionListener((ae) -> {
        });
        jbPesquisa.addActionListener((ae) -> {
        });
        jtPesquisa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                /* if(jtPesquisa.getText().equals("Pesquisar")){
                jtPesquisa.setText("");
                }*/
            }

            @Override
            public void mouseExited(MouseEvent me) {
                /* if (jtPesquisa.getText().equals("")) {
                    jtPesquisa.setText("Pesquisar");
                }*/
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                /*if (jtPesquisa.getText().equals("Pesquisar")) {
                    jtPesquisa.setText("A");
                }*/
            }
        });
        jtPesquisa.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                if (jtPesquisa.getText().equals("Pesquisar")) {
                    jtPesquisa.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (jtPesquisa.getText().equals("")) {
                    jtPesquisa.setText("Pesquisar");
                }
            }

        });

        jtTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int linha = jtTabela.getSelectedRow();

                if (linha != -1) {
                    exp.getJtCodigo().setText(jtTabela.getValueAt(linha, 0).toString());
                    exp.getJtNome().setText(jtTabela.getValueAt(linha, 1).toString());
                    exp.setVisible(true);

                }
            }
        });
        jtTabela.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                int linha = jtTabela.getSelectedRow();
                if (linha != -1) {
                    exp.getJtCodigo().setText(jtTabela.getValueAt(linha, 0).toString());
                    exp.getJtNome().setText(jtTabela.getValueAt(linha, 1).toString());
                    exp.setVisible(true);

                }
            }
        });
    }

}
