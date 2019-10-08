/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW.Formacao;

import VIEW.*;
import static VIEW.Auxiliar.auxJanela;
import static VIEW.Formacao.Alunos.cr;
import static VIEW.Home.addPainelCentro;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Barato Soft Solution
 */
public class CadastrarAluno_01 extends JPanel implements Janela{
    private JPanel jpCentro, jpPrincipal,jpSuperior;
    private JButton jbVoltar, jbProximo, jbCancelar;
    private JTextField jtNomePai, jtNomeMae, jtNomeEnc, jtProfissaoEnc,jtLocalTrabEnc;
    private JFormattedTextField jfContactoPai,jfContactoMae,jfContactoEnc;

    public JButton getJbVoltar() {
        return jbVoltar;
    }

    public void setJbVoltar(JButton jbVoltar) {
        this.jbVoltar = jbVoltar;
    }

    public JButton getJbProximo() {
        return jbProximo;
    }

    public void setJbProximo(JButton jbProximo) {
        this.jbProximo = jbProximo;
    }

    public JButton getJbCancelar() {
        return jbCancelar;
    }

    public void setJbCancelar(JButton jbCancelar) {
        this.jbCancelar = jbCancelar;
    }

    
    @Override
    public void Config() {
        Start();
        Evento();
        auxJanela.addCamponenteJanela(this, jpPrincipal, 'C');
        auxJanela.addCamponenteJanela( this,jpSuperior, 'N');
        auxJanela.addCamponenteJanela( jpPrincipal,jpCentro, 'C');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'E');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'W');
        auxJanela.addCamponenteJanela( jpSuperior, jbCancelar, 1, 1, 1, 1);
        jpCentro.add(jtNomePai);
        jpCentro.add(jfContactoPai);
        jpCentro.add(jtNomeMae);
        jpCentro.add(jfContactoMae);
        jpCentro.add(jtNomeEnc);
         jpCentro.add(jfContactoEnc);
        jpCentro.add(jtProfissaoEnc);
        jpCentro.add(jtLocalTrabEnc);
        jpCentro.add(auxJanela.addDoisComponentes(jbVoltar, new JLabel()));
        jpCentro.add(auxJanela.addDoisComponentes( new JLabel(),jbProximo));
    }

    @Override
    public void Start() {
        jpCentro=auxJanela.jpPanel();
        jpPrincipal=auxJanela.jpPanel();
        jpSuperior = auxJanela.jpPanel();
        auxJanela.configBordaTitulo(this,"Cadastro do Aluno");
        jbCancelar = auxJanela.ConfigBotao("Cancelar");
        jbProximo = auxJanela.ConfigBotao("Proximo");
        jbVoltar = auxJanela.ConfigBotao("Voltar");
        this.setBackground(Color.DARK_GRAY);
        auxJanela.setLayoutBord(this, 10, 10);
        auxJanela.setLayoutBord(jpPrincipal, 10, 10);
        auxJanela.setLayoutGrid(jpCentro,6,2, 20,20);
        auxJanela.setLayoutGridBag(jpSuperior);
        jfContactoPai =auxJanela.campoFormatado("(+258) #########");
        jfContactoMae =auxJanela.campoFormatado("(+258) #########");
        jfContactoEnc =auxJanela.campoFormatado("(+258) #########");
        
        jtNomePai = new JTextField();
        jtNomeMae = new JTextField();
        jtNomeEnc = new JTextField();
        jtProfissaoEnc= new JTextField();
        jtLocalTrabEnc = new JTextField();
       auxJanela.addBordCampo(jtNomePai, "Introduza o Nome do Pai");
       auxJanela.addBordCampo(jtNomeMae, "Introduza o Nome da Mae");
       auxJanela.addBordCampo(jtNomeEnc, "Introduza o Nome do Encarregado");
       auxJanela.addBordCampo(jtProfissaoEnc, "Introduza a Profissao do Encarregado");
       auxJanela.addBordCampo(jtLocalTrabEnc, "Introduza a Local de Trabalho do Encarregado");
       auxJanela.addBordCampo(jfContactoPai, "Introduza o Cobtacto do Pai");
       auxJanela.addBordCampo(jfContactoMae, "Introduza o Contacto da Mae");
       auxJanela.addBordCampo(jfContactoEnc, "Introduza o Contacto do Encarregado");
        jpSuperior.setBackground(auxJanela.getCorBotao());
         
    }

    @Override
    public void Evento() {
       jbCancelar.addActionListener((ae) -> {
          cr.actionPerformed(ae);
        });
        jbProximo.addActionListener((ae) -> {
            cr.actionPerformed(ae);
        });
        jbVoltar.addActionListener((ae) -> {
            cr.actionPerformed(ae);
        });
       
       
    }
    
}
