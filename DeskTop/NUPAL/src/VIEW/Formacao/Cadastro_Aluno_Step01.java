/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW.Formacao;

import static VIEW.Auxiliar.auxJanela;
import VIEW.JanelaFormularios;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Barato Soft Solution
 */
public class Cadastro_Aluno_Step01 extends JPanel implements JanelaFormularios {

    private JTextField jtNome, jtApelido;
    private JRadioButton fem, mas, solteiro, casado;
    private JComboBox jcSexo, jcEstadoC, jcNac, jcNat;
    private JDateChooser jdDataNasc,jdDataEmissao;
    private JTextField jtNr_Doc;
    private JComboBox jcTipoDoc, jcLocEmissao;
    


    @Override
    public void Config() {
        Start();
        Evento();
        ConfigDados();

        this.add(jtNome);
        this.add(jtApelido);
        this.add(jtNome);
        this.add(jtApelido);
        this.add(jcSexo);
        this.add(jcEstadoC);
        this.add(jcNac);
        this.add(jcNat);
        this.add(jdDataNasc);
        this.add(auxJanela.msg("", ' '));
        this.add(jcTipoDoc);
        this.add(jtNr_Doc);
        this.add(jcLocEmissao);
        this.add(jdDataEmissao);
    }

    @Override
    public void Start() {
        jtNome = new JTextField();
        jtApelido = new JTextField();

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

        jcSexo = new JComboBox();
        jcEstadoC = new JComboBox();
        jcNat = new JComboBox();
        jcNac = new JComboBox();
        jcEstadoC = new JComboBox();
        
        jdDataNasc = new JDateChooser();
        jdDataNasc.setDateFormatString("dd/MM/yyyy");
        Calendar ca = Calendar.getInstance();
        Calendar ca2 = Calendar.getInstance();
        ca.set(ca.get(Calendar.YEAR) - 5, 11, 30);
        ca2.set(ca2.get(Calendar.YEAR) - 100, ca2.get(Calendar.MONTH), ca2.get(Calendar.DAY_OF_MONTH));
        jdDataNasc.setMaxSelectableDate(ca.getTime());
        jdDataNasc.setSelectableDateRange(ca2.getTime(), ca.getTime());
        jdDataNasc.setDate(ca.getTime());

        jtNr_Doc = new JTextField();
        jcTipoDoc = new JComboBox();
        jcLocEmissao = new JComboBox();
        jdDataEmissao = new JDateChooser();
        jdDataEmissao.setDateFormatString("dd/MM/yyyy");
        

        auxJanela.addBordCampo(jtNome, "Introduza o Nome");
        auxJanela.addBordCampo(jtApelido, "Introduza o Apelido");
        auxJanela.addBordCampo(jcEstadoC, "Selecione o Estado Civil");
        auxJanela.addBordCampo(jcSexo, "Selecione o Genero");
        auxJanela.addBordCampo(jcNac, "Selecione a Nacionalidade");
        auxJanela.addBordCampo(jcNat, "Selecione a Naturalidade");
        auxJanela.addBordCampo(jdDataNasc, "Selecione a Data de Nascimento");

        auxJanela.addBordCampo(jcTipoDoc, "Seleciona o tipo de Documento");
        auxJanela.addBordCampo(jtNr_Doc, "Introduza o numero");
        auxJanela.addBordCampo(jcLocEmissao, "Seleciona o local de emissao");
        auxJanela.addBordCampo(jdDataEmissao, "Introduza a data d emissao");

    }

    @Override
    public void Evento() {
        
    }

    @Override
    public void ConfigDados() {
        auxJanela.setLayoutGrid(this, 6, 2, 20, 20);
        auxJanela.configBordaTitulo(this, "Step 01");
        jtNome.setBackground(null);
        jtNome.setFont(auxJanela.getF());
        jtNome.setForeground(Color.WHITE);
        jtApelido.setBackground(null);
        fem.setBackground(Color.DARK_GRAY);
        mas.setBackground(null);
        solteiro.setBackground(null);
        casado.setBackground(null);
        fem.setFont(auxJanela.getF());
        jtNr_Doc.setVisible(false);
        jcLocEmissao.setVisible(false);
        jdDataEmissao.setVisible(false);
        this.setBackground(Color.DARK_GRAY);
    }


    public JTextField getJtNome() {
        return jtNome;
    }

    public JTextField getJtApelido() {
        return jtApelido;
    }

    public JRadioButton getFem() {
        return fem;
    }

    public JRadioButton getMas() {
        return mas;
    }

    public JRadioButton getSolteiro() {
        return solteiro;
    }

    public JRadioButton getCasado() {
        return casado;
    }

    public JComboBox getJcSexo() {
        return jcSexo;
    }

    public JComboBox getJcEstadoC() {
        return jcEstadoC;
    }

    public JComboBox getJcNac() {
        return jcNac;
    }

    public JComboBox getJcNat() {
        return jcNat;
    }

    public JDateChooser getJdDataNasc() {
        return jdDataNasc;
    }

    public JTextField getJtNr_Doc() {
        return jtNr_Doc;
    }

    public JComboBox getJcTipoDoc() {
        return jcTipoDoc;
    }

    public JComboBox getJcLocEmissao() {
        return jcLocEmissao;
    }

    public JDateChooser getJdDataEmissao() {
        return jdDataEmissao;
    }

    
    
    
    

}
