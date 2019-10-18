/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW.Formacao;

import static VIEW.Auxiliar.auxJanela;
import VIEW.JanelaFormularios;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Barato Soft Solution
 */
public class Cadastro_Aluno extends JPanel implements JanelaFormularios {
    private Cadastro_Aluno_Step01 jpStep_01;
    private Cadastro_Aluno_Step02 jpStep_02;
    private Cadastro_Aluno_Step03 jpStep_03;
    protected JPanel jpPrincipal, jpSuperior, jpSuperiorE;
    protected JButton jbVoltar, jbProximo, jbCancelar;
 
    @Override
    public void Config() {
        Start();
        Evento();
        ConfigDados();
        auxJanela.addCamponenteJanela(this, jpPrincipal, 'C');
        auxJanela.addCamponenteJanela(this, jpSuperior, 'N');
        auxJanela.addCamponenteJanela(this, jpSuperiorE, 'S');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'E');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'W');
        auxJanela.addCamponenteJanela(jpSuperiorE, jbVoltar, 'W');
        auxJanela.addCamponenteJanela(jpSuperiorE, jbProximo, 'E');
        auxJanela.addCamponenteJanela(jpSuperior, jbCancelar, 1, 1, 1, 1);
       
    }

    @Override
    public void Start() {
        jpPrincipal = auxJanela.jpPanel();
        jpSuperior = auxJanela.jpPanel();
        jpStep_01 = new Cadastro_Aluno_Step01();
        jpStep_01.Config();
        jpStep_02 = new Cadastro_Aluno_Step02();
        jpStep_02.Config();
         jpStep_03 = new Cadastro_Aluno_Step03();
        jpStep_03.Config();
        jpSuperiorE = auxJanela.jpPanel();
        jbCancelar = auxJanela.ConfigBotao("Cancelar");
        jbProximo = auxJanela.ConfigBotao("Proximo");
        jbVoltar = auxJanela.ConfigBotao("Voltar");


    }

    @Override
    public void Evento() {
        
    }

    public void addPainelCentro(JPanel p) {
        jpPrincipal.removeAll();
        auxJanela.addCamponenteJanela(jpPrincipal, p, 'C');
        jpPrincipal.repaint();
    }

    @Override
    public void ConfigDados() {
        //Configurar Estrutura dos JPanel
        auxJanela.setLayoutGridBag(jpSuperior);
        auxJanela.setLayoutBord(jpSuperiorE, 10, 10);
        auxJanela.setLayoutBord(jpPrincipal, 10, 10);
        auxJanela.configBordaTitulo(this, "Cadastro do Aluno");
        auxJanela.setLayoutBord(this, 10, 10);

        jpSuperior.setBackground(auxJanela.getCorBotao());
               
        jpSuperior.setBackground(auxJanela.getCorBotao());
        this.setBackground(Color.DARK_GRAY);
    }

    public Cadastro_Aluno_Step01 getJpStep_01() {
        return jpStep_01;
    }

    public Cadastro_Aluno_Step02 getJpStep_02() {
        return jpStep_02;
    }

    public Cadastro_Aluno_Step03 getJpStep_03() {
        return jpStep_03;
    }

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public JPanel getJpSuperior() {
        return jpSuperior;
    }

    public JPanel getJpSuperiorE() {
        return jpSuperiorE;
    }

    public JButton getJbVoltar() {
        return jbVoltar;
    }

    public JButton getJbProximo() {
        return jbProximo;
    }

    public JButton getJbCancelar() {
        return jbCancelar;
    }
    

    
    
    
    

}
