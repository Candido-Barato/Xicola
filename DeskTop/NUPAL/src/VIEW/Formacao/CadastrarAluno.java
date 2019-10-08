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
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Barato Soft Solution
 */
public class CadastrarAluno extends JPanel implements Janela {

    private JPanel jpCentro, jpPrincipal, jpSuperior;
    private JButton jbVoltar, jbProximo, jbCancelar;
    private JTextField jtNome, jtApelido;
    private JRadioButton fem, mas, solteiro, casado;
    private JComboBox jcSexo, jcEstadoC, jcNac, jcNat;
    private JDateChooser jdDataNasc;

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

    public JComboBox getJcNac() {
        return jcNac;
    }

    public void setJcNac(JComboBox jcNac) {
        this.jcNac = jcNac;
    }

    public JComboBox getJcNat() {
        return jcNat;
    }

    public void setJcNat(JComboBox jcNat) {
        this.jcNat = jcNat;
    }

    public JTextField getJtNome() {
        return jtNome;
    }

    public void setJtNome(JTextField jtNome) {
        this.jtNome = jtNome;
    }

    public JTextField getJtApelido() {
        return jtApelido;
    }

    public void setJtApelido(JTextField jtApelido) {
        this.jtApelido = jtApelido;
    }
    

    
    @Override
    public void Config() {
        Start();
        Evento();
        auxJanela.addCamponenteJanela(this, jpPrincipal, 'C');
        auxJanela.addCamponenteJanela(this, jpSuperior, 'N');
        auxJanela.addCamponenteJanela(jpPrincipal, jpCentro, 'C');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'E');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'W');
        auxJanela.addCamponenteJanela(jpSuperior, jbCancelar, 1, 1, 1, 1);
        jpCentro.add(jtNome);
        jpCentro.add(jtApelido);
        jpCentro.add(jcSexo);
        jpCentro.add(jcEstadoC);
        jpCentro.add(jcNac);
        jpCentro.add(jcNat);
        jpCentro.add(jdDataNasc);
        jpCentro.add(auxJanela.msg(" ", ' '));
        jpCentro.add(auxJanela.addDoisComponentes(jbVoltar, new JLabel()));
        jpCentro.add(auxJanela.addDoisComponentes(new JLabel(), jbProximo));
       
    }

    @Override
    public void Start() {
        jpCentro = auxJanela.jpPanel();
        jpPrincipal = auxJanela.jpPanel();
        jpSuperior = auxJanela.jpPanel();
        auxJanela.configBordaTitulo(this, "Cadastro do Aluno");
        jbCancelar = auxJanela.ConfigBotao("Cancelar");
        jbProximo = auxJanela.ConfigBotao("Proximo");
        jbVoltar = auxJanela.ConfigBotao("Voltar");
        this.setBackground(Color.DARK_GRAY);
        auxJanela.setLayoutBord(this, 10, 10);
        auxJanela.setLayoutBord(jpPrincipal, 10, 10);
        auxJanela.setLayoutGrid(jpCentro, 6, 2, 20, 20);
        auxJanela.setLayoutGridBag(jpSuperior);

        jtNome = new JTextField("Introduza o Nome");
        jtApelido = new JTextField("Introduza o Apelido");
        jtNome.setBackground(null);
        jtNome.setFont(auxJanela.getF());
        jtNome.setForeground(Color.WHITE);
        jtApelido.setBackground(null);
        mas = new JRadioButton("M");
        fem = new JRadioButton("F");
        solteiro = new JRadioButton("Solteiro");
        casado = new JRadioButton("Casado");
        ButtonGroup bg = new ButtonGroup();
        ButtonGroup bg2 = new ButtonGroup();
        bg.add(fem);
        bg.add(mas);
        bg2.add(solteiro);
        bg2.add(casado);
        fem.setBackground(Color.DARK_GRAY);
        jpSuperior.setBackground(auxJanela.getCorBotao());
        mas.setBackground(null);
        solteiro.setBackground(null);
        casado.setBackground(null);
        fem.setFont(auxJanela.getF());
        jcSexo = new JComboBox();
        jcEstadoC = new JComboBox();
        jcNat = new JComboBox();
        jcNac = new JComboBox();
        jcEstadoC = new JComboBox();
        jcSexo.addItem("Masculino");
        jcSexo.addItem("Femenino");
        jcEstadoC.addItem("Solteiro");
        jcEstadoC.addItem("Casado");
        jcNat.addItem("Maputo");
        jcNac.addItem("Mocambique");
        jdDataNasc = new JDateChooser();
        jdDataNasc.setDateFormatString("dd/MM/yyyy");
        Calendar ca = Calendar.getInstance();
        Calendar ca2 = Calendar.getInstance();
        ca.set(ca.get(Calendar.YEAR) - 5, 11, 30);
        ca2.set(ca2.get(Calendar.YEAR) - 100, ca2.get(Calendar.MONTH), ca2.get(Calendar.DAY_OF_MONTH));
        ca.getTime();
        jdDataNasc.setMaxSelectableDate(ca.getTime());
        jdDataNasc.setSelectableDateRange(ca2.getTime(), ca.getTime());
        jdDataNasc.setDate(ca.getTime());
        
        auxJanela.addBordCampo(jtNome, "Introduza o Nome");
        auxJanela.addBordCampo(jtApelido, "Introduza o Apelido");
        auxJanela.addBordCampo(jcEstadoC, "Selecione o Estado Civil");
        auxJanela.addBordCampo(jcSexo, "Selecione o Genero");
        auxJanela.addBordCampo(jcNac, "Selecione a Nacionalidade");
        auxJanela.addBordCampo(jcNat, "Selecione a Naturalidade");
        auxJanela.addBordCampo(jdDataNasc, "Selecione a Data de Nascimento");
        
        
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
       jtNome.addFocusListener(new FocusAdapter() {
           @Override
            public void focusGained(FocusEvent fe) {
                if ( jtNome.getText().equals("Introduza o Nome")) {
                     jtNome.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if ( jtNome.getText().equals("")) {
                     jtNome.setText("Introduza o Nome");
                }
            }
        });


    }

}
