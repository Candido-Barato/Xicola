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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Barato Soft Solution
 */
public class Cadastro_Aluno extends JPanel implements JanelaFormularios {

    protected JPanel jpPrincipal, jpSuperior, jpSuperiorE, jpStep_01, jpStep_02, jpStep_03;
    protected JButton jbVoltar, jbProximo, jbCancelar;
    private JTextField jtNome, jtApelido;
    private JRadioButton fem, mas, solteiro, casado;
    private JComboBox jcSexo, jcEstadoC, jcNac, jcNat;
    private JDateChooser jdDataNasc;
   
    private JTextField jtNr_Doc;
    private JComboBox jcTipoDoc, jcLocEmissao;
    private JDateChooser jdDataEmissao;
    private JTextField jtNomePai, jtNomeMae, jtNomeEnc, jtProfissaoEnc, jtLocalTrabEnc, jtTipoRelacionamento;
    private JFormattedTextField jfContactoPai, jfContactoMae, jfContactoEnc;
    private JComboBox jcRelacionameto;
   

    private JTextField jtEmail, jtNr_Q, jtNr_C;
    private JFormattedTextField jfContacto;
    private JComboBox jcDistrito, jcBairro, jcProv;

    @Override
    public void Config() {
        Start();
        Evento();
        ConfigDados();

        addPainelCentro(jpStep_01);
        auxJanela.addCamponenteJanela(this, jpPrincipal, 'C');
        auxJanela.addCamponenteJanela(this, jpSuperior, 'N');
        auxJanela.addCamponenteJanela(this, jpSuperiorE, 'S');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'E');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'W');
        auxJanela.addCamponenteJanela(jpSuperiorE, jbVoltar, 'W');
        auxJanela.addCamponenteJanela(jpSuperiorE, jbProximo, 'E');
        auxJanela.addCamponenteJanela(jpSuperior, jbCancelar, 1, 1, 1, 1);

        //Adicionando componentes Ao Step 01
        jpStep_01.add(jtNome);
        jpStep_01.add(jtApelido);
        jpStep_01.add(jtNome);
        jpStep_01.add(jtApelido);
        jpStep_01.add(jcSexo);
        jpStep_01.add(jcEstadoC);
        jpStep_01.add(jcNac);
        jpStep_01.add(jcNat);
        jpStep_01.add(jdDataNasc);
        jpStep_01.add(auxJanela.msg("", ' '));
        jpStep_01.add(jcTipoDoc);
        jpStep_01.add(jtNr_Doc);
        jpStep_01.add(jcLocEmissao);
        jpStep_01.add(jdDataEmissao);
        //Adicionando componentes Ao Step 02
        jpStep_02.add(jtNomePai);
        jpStep_02.add(jfContactoPai);
        jpStep_02.add(jtNomeMae);
        jpStep_02.add(jfContactoMae);
        jpStep_02.add(jcRelacionameto);
        jpStep_02.add(jtTipoRelacionamento);
        jpStep_02.add(jtNomeEnc);
        jpStep_02.add(jfContactoEnc);
        jpStep_02.add(jtProfissaoEnc);
        jpStep_02.add(jtLocalTrabEnc);
        //Adicionando componentes Ao Step 02
        jpStep_03.add(jtEmail);
        jpStep_03.add(jfContacto);
        jpStep_03.add(jcProv);
        jpStep_03.add(jcDistrito);
        jpStep_03.add(jcBairro);
        jpStep_03.add(auxJanela.msg(" ", ' '));
        jpStep_03.add(jtNr_Q);
        jpStep_03.add(jtNr_C);
    }

    @Override
    public void Start() {
        jpPrincipal = auxJanela.jpPanel();
        jpSuperior = auxJanela.jpPanel();
        jpStep_01 = auxJanela.jpPanel();
        jpStep_02 = auxJanela.jpPanel();
        jpStep_03 = auxJanela.jpPanel();
        jpSuperiorE = auxJanela.jpPanel();
        jtNome = new JTextField("Introduza o Nome");
        jtApelido = new JTextField("Introduza o Apelido");
        jbCancelar = auxJanela.ConfigBotao("Cancelar");
        jbProximo = auxJanela.ConfigBotao("Proximo");
        jbVoltar = auxJanela.ConfigBotao("Voltar");

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
        ca.getTime();
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

        //Step_02
        jfContactoPai = auxJanela.campoFormatado("(+258) #########");
        jfContactoMae = auxJanela.campoFormatado("(+258) #########");
        jfContactoEnc = auxJanela.campoFormatado("(+258) #########");
        jtNomePai = new JTextField();
        jtNomeMae = new JTextField();
        jtNomeEnc = new JTextField();
        jtProfissaoEnc = new JTextField();
        jtLocalTrabEnc = new JTextField();
        jtTipoRelacionamento = new JTextField();
        jcRelacionameto = new JComboBox();

        auxJanela.addBordCampo(jtNomePai, "Introduza o Nome do Pai");
        auxJanela.addBordCampo(jtNomeMae, "Introduza o Nome da Mae");
        auxJanela.addBordCampo(jtNomeEnc, "Introduza o Nome do Encarregado");
        auxJanela.addBordCampo(jtProfissaoEnc, "Introduza a Profissao do Encarregado");
        auxJanela.addBordCampo(jtLocalTrabEnc, "Introduza a Local de Trabalho do Encarregado");
        auxJanela.addBordCampo(jfContactoPai, "Introduza o Cobtacto do Pai");
        auxJanela.addBordCampo(jfContactoMae, "Introduza o Contacto da Mae");
        auxJanela.addBordCampo(jfContactoEnc, "Introduza o Contacto do Encarregado");
        auxJanela.addBordCampo(jcRelacionameto, "Relacionamento com Encarregado");
        auxJanela.addBordCampo(jtTipoRelacionamento, "Introduza o tipo de relacionamento");

        jtEmail = new JTextField();
        jtNr_Q = new JTextField();
        jtNr_C = new JTextField();
        jcDistrito = new JComboBox();
        jcProv = new JComboBox();
        jcBairro = new JComboBox();

        jfContacto = auxJanela.campoFormatado("(+258) #########");
        auxJanela.addBordCampo(jfContacto, "Introduza o Contacto Pessoal");
        auxJanela.addBordCampo(jtEmail, "Introduza o Email Pessoal");
        auxJanela.addBordCampo(jcProv, "Seleciona o Provincia de Residencia");
        auxJanela.addBordCampo(jcDistrito, "Seleciona o Distrito de Residencia");
        auxJanela.addBordCampo(jcBairro, "Seleciona o Bairro de Residencia");
        auxJanela.addBordCampo(jtNr_C, "Introduza o Numero da Casa ");
        auxJanela.addBordCampo(jtNr_Q, "Introduza o Numero do Quarterao");

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
        auxJanela.setLayoutGrid(jpStep_01, 6, 2, 20, 20);
        auxJanela.setLayoutGrid(jpStep_02, 6, 2, 20, 20);
        auxJanela.setLayoutGrid(jpStep_03, 6, 2, 20, 20);
        auxJanela.setLayoutBord(jpSuperiorE, 10, 10);
        auxJanela.setLayoutBord(jpPrincipal, 10, 10);
        auxJanela.configBordaTitulo(this, "Cadastro do Aluno");
        auxJanela.configBordaTitulo(jpStep_01, "Step 01");
        auxJanela.configBordaTitulo(jpStep_02, "Step 02");
        auxJanela.configBordaTitulo(jpStep_03, "Step 03");
        auxJanela.setLayoutBord(this, 10, 10);

        jpSuperior.setBackground(auxJanela.getCorBotao());
        jtNome.setBackground(null);
        jtNome.setFont(auxJanela.getF());
        jtNome.setForeground(Color.WHITE);
        jtApelido.setBackground(null);
        fem.setBackground(Color.DARK_GRAY);
        jpSuperior.setBackground(auxJanela.getCorBotao());
        jpSuperiorE.setBackground(auxJanela.getCorBotao());
        mas.setBackground(null);
        solteiro.setBackground(null);
        casado.setBackground(null);
        fem.setFont(auxJanela.getF());

        jtNr_Doc.setEnabled(false);
        jcLocEmissao.setEnabled(false);
        jdDataEmissao.setEnabled(false);
         
        jpSuperior.setBackground(auxJanela.getCorBotao());
        jtTipoRelacionamento.setVisible(false);
        jfContactoEnc.setVisible(false);
        jtLocalTrabEnc.setVisible(false);
        jtProfissaoEnc.setVisible(false);
        jtNomeEnc.setVisible(false);

        this.setBackground(Color.DARK_GRAY);
    }

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

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public JPanel getJpSuperior() {
        return jpSuperior;
    }

    public JPanel getJpSuperiorE() {
        return jpSuperiorE;
    }

    public JPanel getJpStep_01() {
        return jpStep_01;
    }

    public JPanel getJpStep_02() {
        return jpStep_02;
    }

    public JPanel getJpStep_03() {
        return jpStep_03;
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

    public JTextField getJtNomePai() {
        return jtNomePai;
    }

    public JTextField getJtNomeMae() {
        return jtNomeMae;
    }

    public JTextField getJtNomeEnc() {
        return jtNomeEnc;
    }

    public JTextField getJtProfissaoEnc() {
        return jtProfissaoEnc;
    }

    public JTextField getJtLocalTrabEnc() {
        return jtLocalTrabEnc;
    }

    public JTextField getJtTipoRelacionamento() {
        return jtTipoRelacionamento;
    }

    public JFormattedTextField getJfContactoPai() {
        return jfContactoPai;
    }

    public JFormattedTextField getJfContactoMae() {
        return jfContactoMae;
    }

    public JFormattedTextField getJfContactoEnc() {
        return jfContactoEnc;
    }

    public JComboBox getJcRelacionameto() {
        return jcRelacionameto;
    }

   

    public JTextField getJtEmail() {
        return jtEmail;
    }

    public JTextField getJtNr_Q() {
        return jtNr_Q;
    }

    public JTextField getJtNr_C() {
        return jtNr_C;
    }

    public JFormattedTextField getJfContacto() {
        return jfContacto;
    }

    public JComboBox getJcDistrito() {
        return jcDistrito;
    }

    public JComboBox getJcBairro() {
        return jcBairro;
    }

    public JComboBox getJcProv() {
        return jcProv;
    }
    
    
    
    
    

}
