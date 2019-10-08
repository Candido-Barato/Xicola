/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW.Formacao;

import VIEW.*;
import static VIEW.Auxiliar.auxJanela;
import static VIEW.Formacao.Alunos.cr;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Barato Soft Solution
 */
public class CadastrarAluno_02 extends JPanel implements Janela{
    private JPanel jpCentro, jpPrincipal,jpSuperior;
    private JButton jbVoltar, jbProximo, jbCancelar;
    private JTextField jtEmail, jtNr_Q, jtNr_C;
    private JFormattedTextField jfContacto;
    private JComboBox jcDistrito, jcBairro, jcProv;

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
        jpCentro.add(jtEmail);
        jpCentro.add(jfContacto);
        jpCentro.add(jcProv);
        jpCentro.add(jcDistrito);
        jpCentro.add(jcBairro);
        jpCentro.add(auxJanela.msg(" ",' '));
        jpCentro.add(jtNr_Q);
        jpCentro.add(jtNr_C);
        
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
        jfContacto =auxJanela.campoFormatado("(+258) #########");
        
        jtEmail = new JTextField();
        jtNr_Q = new JTextField();
        jtNr_C = new JTextField();
        jcDistrito= new JComboBox();
        jcProv= new JComboBox();
        jcBairro= new JComboBox();
        jcDistrito.addItem("Distrito");
        jcProv.addItem("Provincia");
        jcBairro.addItem("Bairro");
       auxJanela.addBordCampo(jfContacto, "Introduza o Contacto Pessoal");
       auxJanela.addBordCampo(jtEmail, "Introduza o Email Pessoal");
       auxJanela.addBordCampo(jcProv, "Seleciona o Provincia de Residencia");
       auxJanela.addBordCampo(jcDistrito, "Seleciona o Distrito de Residencia");
       auxJanela.addBordCampo(jcBairro, "Seleciona o Bairro de Residencia");
       auxJanela.addBordCampo(jtNr_C, "Introduza o Numero da Casa ");
       auxJanela.addBordCampo(jtNr_Q, "Introduza o Numero do Quarterao");
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
