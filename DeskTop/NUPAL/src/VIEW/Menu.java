/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import static VIEW.Auxiliar.auxJanela;
import static VIEW.Auxiliar.tr;
import static VIEW.Home.addPainelCentro;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Barato Soft Solution
 */
public class Menu extends JPanel implements Janela {

    private JButton jbMenu, jbHome, jbSair, jbConf, jbAluno, jbFormador, jbAdmin,
            jbMatricula, jbPagamento, jbRH;
    private JPanel jpCentro;

    @Override
    public void Config() {
        Start();
        Evento();
        auxJanela.addCamponenteJanela(this, jbMenu, 'N');
        auxJanela.addCamponenteJanela(this, jbSair, 'S');
        auxJanela.addCamponenteJanela(this, jpCentro, 'C');
        jpCentro.add(jbHome);
        //  jpCentro.add(jbAluno);
        // jpCentro.add(jbFormador);
        jpCentro.add(jbAdmin);
        jpCentro.add(jbMatricula);
        jpCentro.add(jbPagamento);
        jpCentro.add(jbRH);
        jpCentro.add(jbConf);

    }

    @Override
    public void Start() {
        jpCentro = new JPanel();
        auxJanela.setLayoutGrid(jpCentro, 8, 1, 0, 0);
        auxJanela.setLayoutBord(this, 10, 10);
        this.setBackground(new Color(22, 59, 67));
        jpCentro.setBackground(null);
        jbSair = auxJanela.ConfigBotao("Sair");
        jbMenu = auxJanela.ConfigBotao("Menu");
        jbHome = auxJanela.ConfigBotao("Home");
        jbFormador = auxJanela.ConfigBotao("Formador");
        jbAluno = auxJanela.ConfigBotao("Aluno");
        jbAdmin = auxJanela.ConfigBotao("Administracao");
        jbMatricula = auxJanela.ConfigBotao("Formacao");
        jbPagamento = auxJanela.ConfigBotao("Recursos Financeiros");
        jbRH = auxJanela.ConfigBotao("Recursos Humanos");
        jbConf = auxJanela.ConfigBotao("Definicoes");

        jbMenu.setIcon(tr.criarImage("/Img/Icon/menu.png", 40, 40));
        jbHome.setIcon(tr.criarImage("/Img/Icon/Home_1.png", 40, 40));
        jbConf.setIcon(tr.criarImage("/Img/Icon/config.png", 40, 40));
        jbAdmin.setIcon(tr.criarImage("/Img/Icon/Admin.png", 40, 40));
        jbAluno.setIcon(tr.criarImage("/Img/Icon/Aluno.png", 40, 40));
        jbMatricula.setIcon(tr.criarImage("/Img/Icon/Formacao.png", 40, 40));
        jbFormador.setIcon(tr.criarImage("/Img/Icon/Prof.png", 40, 40));
        jbPagamento.setIcon(tr.criarImage("/Img/Icon/config.png", 40, 40));
        jbRH.setIcon(tr.criarImage("/Img/Icon/Admin.png", 40, 40));

    }

    @Override
    public void Evento() {
        jbHome.addActionListener((ae) -> {
            Inicial inn =new Inicial();
            inn.Config();
            addPainelCentro(inn);
        });
        jbMenu.addActionListener((ae) -> {

            if (this.getSize().width == 50) {
                this.setPreferredSize(new Dimension(250, (int) this.getSize().getHeight()));
            } else {
                this.setPreferredSize(new Dimension(50, (int) this.getSize().getHeight()));
            }

        });
        jbSair.addActionListener((ae) -> {
            int op = JOptionPane.showConfirmDialog(this, "Deseja Sair", "Mensagem de Sair do Sistema", JOptionPane.YES_NO_OPTION);
            if (op == JOptionPane.YES_OPTION) {
                System.exit(op);
            }
        });
        jbAdmin.addActionListener((ae) -> {
            Administracao admin = new Administracao();
            admin.Config();
            addPainelCentro(admin);
        });
        jbPagamento.addActionListener((ae) -> {
            Recursos_Financeiros admin = new Recursos_Financeiros();
            admin.Config();
            addPainelCentro(admin);
        });
        jbRH.addActionListener((ae) -> {
            Recursos_Humanos admin = new Recursos_Humanos();
            admin.Config();
            addPainelCentro(admin);
        });
        jbMatricula.addActionListener((ae) -> {
            Formacaoo fm = new Formacaoo();
            fm.Config();
            addPainelCentro(fm);
        });

    }

}
