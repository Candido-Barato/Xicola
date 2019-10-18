/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW.Formacao;

import static VIEW.Auxiliar.auxJanela;
import VIEW.JanelaFormularios;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Barato Soft Solution
 */
public class Cadastro_Aluno_Step03 extends JPanel implements JanelaFormularios {
 
    private JTextField jtNomePai, jtNomeMae, jtNomeEnc, jtProfissaoEnc, jtLocalTrabEnc, jtTipoRelacionamento;
    private JFormattedTextField jfContactoPai, jfContactoMae, jfContactoEnc;
    private JComboBox jcRelacionameto;


    @Override
    public void Config() {
        Start();
        Evento();
        ConfigDados();
        //Adicionando componentes Ao Step 02
        this.add(jtNomePai);
        this.add(jfContactoPai);
        this.add(jtNomeMae);
        this.add(jfContactoMae);
        this.add(jcRelacionameto);
        this.add(jtTipoRelacionamento);
        this.add(jtNomeEnc);
        this.add(jfContactoEnc);
        this.add(jtProfissaoEnc);
        this.add(jtLocalTrabEnc);
        
    }

    @Override
    public void Start() {

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


    }

    @Override
    public void Evento() {
        
    }

    @Override
    public void ConfigDados() {
        auxJanela.setLayoutGrid(this, 6, 2, 20, 20);
        auxJanela.configBordaTitulo(this, "Step 03");
        jtTipoRelacionamento.setVisible(false);
        jfContactoEnc.setVisible(false);
        jtLocalTrabEnc.setVisible(false);
        jtProfissaoEnc.setVisible(false);
        jtNomeEnc.setVisible(false);

        this.setBackground(Color.DARK_GRAY);
    }

    public JTextField getJtNomePai() {
        return jtNomePai;
    }

    public void setJtNomePai(JTextField jtNomePai) {
        this.jtNomePai = jtNomePai;
    }

    public JTextField getJtNomeMae() {
        return jtNomeMae;
    }

    public void setJtNomeMae(JTextField jtNomeMae) {
        this.jtNomeMae = jtNomeMae;
    }

    public JTextField getJtNomeEnc() {
        return jtNomeEnc;
    }

    public void setJtNomeEnc(JTextField jtNomeEnc) {
        this.jtNomeEnc = jtNomeEnc;
    }

    public JTextField getJtProfissaoEnc() {
        return jtProfissaoEnc;
    }

    public void setJtProfissaoEnc(JTextField jtProfissaoEnc) {
        this.jtProfissaoEnc = jtProfissaoEnc;
    }

    public JTextField getJtLocalTrabEnc() {
        return jtLocalTrabEnc;
    }

    public void setJtLocalTrabEnc(JTextField jtLocalTrabEnc) {
        this.jtLocalTrabEnc = jtLocalTrabEnc;
    }

    public JTextField getJtTipoRelacionamento() {
        return jtTipoRelacionamento;
    }

    public void setJtTipoRelacionamento(JTextField jtTipoRelacionamento) {
        this.jtTipoRelacionamento = jtTipoRelacionamento;
    }

    public JFormattedTextField getJfContactoPai() {
        return jfContactoPai;
    }

    public void setJfContactoPai(JFormattedTextField jfContactoPai) {
        this.jfContactoPai = jfContactoPai;
    }

    public JFormattedTextField getJfContactoMae() {
        return jfContactoMae;
    }

    public void setJfContactoMae(JFormattedTextField jfContactoMae) {
        this.jfContactoMae = jfContactoMae;
    }

    public JFormattedTextField getJfContactoEnc() {
        return jfContactoEnc;
    }

    public void setJfContactoEnc(JFormattedTextField jfContactoEnc) {
        this.jfContactoEnc = jfContactoEnc;
    }

    public JComboBox getJcRelacionameto() {
        return jcRelacionameto;
    }

    public void setJcRelacionameto(JComboBox jcRelacionameto) {
        this.jcRelacionameto = jcRelacionameto;
    }
    

   

    
    
    
    

}
