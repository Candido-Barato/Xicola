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
public class Cadastro_Aluno_Step02 extends JPanel implements JanelaFormularios {
   

    private JTextField jtEmail, jtNr_Q, jtNr_C;
    private JFormattedTextField jfContacto;
    private JComboBox jcDistrito, jcBairro, jcProv;

    @Override
    public void Config() {
        Start();
        Evento();
        ConfigDados();

        //Adicionando componentes Ao Step 02
        this.add(jtEmail);
        this.add(jfContacto);
        this.add(jcProv);
        this.add(jcDistrito);
        this.add(jcBairro);
        this.add(auxJanela.msg(" ", ' '));
        this.add(jtNr_Q);
        this.add(jtNr_C);
    }

    @Override
    public void Start() {
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

    @Override
    public void ConfigDados() {
        auxJanela.setLayoutGrid(this, 6, 2, 20, 20);
        auxJanela.configBordaTitulo(this, "Step 02");


        this.setBackground(Color.DARK_GRAY);
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
