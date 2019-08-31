/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Formulario;

import Controler.Pessoa_Controler;
import Model.Pessoa;
import static View.Auxiliar.auxJanela;
import View.Janela;
import datechooser.beans.DateChooserCombo;
import java.awt.Color;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Barato Soft Solution
 */
public class Cadastro_Pessoa extends JPanel implements Janela{
    private JPanel jpCentro,  jpPrincipal, jpDadosPessoais, jpDoc, jpNascimento;
    private JTextField jtNome, jtApelido, jtNomePai, jtNomeMae, jtNumero;
    private JButton jbProx, jbVoltar;
    //private J
    private JComboBox jcNacionalidade, jcProv, jcDistrito, jcTipoDoc, jcProvEm, jcDistritoEm;
    private JRadioButton jrMasculino, jrFemenino, jrSolteiro, jrCasado;
    private  Pessoa pessoa;
    private DateChooserCombo jdDataNasc;
    @Override
    public void Config() {
        Start();
        Evento();
        jpDadosPessoais.add(auxJanela.addDoisComponentes(auxJanela.msg("Nome"), auxJanela.msg("Apelido")));
        jpDadosPessoais.add(auxJanela.addDoisComponentes(jtApelido, jtNome));
        jpDadosPessoais.add(auxJanela.addDoisComponentes(auxJanela.msg("Genero"), auxJanela.msg("Estado Civil")));
        jpDadosPessoais.add(auxJanela.addDoisComponentes(auxJanela.addDoisComponentes(jrMasculino,jrFemenino),auxJanela.addDoisComponentes(jrSolteiro,jrCasado)));
        jpDadosPessoais.add(auxJanela.addDoisComponentes(auxJanela.msg("Nacionalidade"), auxJanela.msg("Provincia")));
        jpDadosPessoais.add(auxJanela.addDoisComponentes(jcNacionalidade, jcProv));
        jpDadosPessoais.add(auxJanela.addDoisComponentes(auxJanela.msg("Distrito"), auxJanela.msg("Data de Nascimento")));
        jpDadosPessoais.add(auxJanela.addDoisComponentes(jcDistrito, jdDataNasc));
        
        //Dados de filiacao
        jpDoc.add(auxJanela.addDoisComponentes(auxJanela.msg("Nome do Pai"), auxJanela.msg("Nome da Mae")));
        jpDoc.add(auxJanela.addDoisComponentes(jtNomePai, jtNomeMae));
        jpDoc.add(auxJanela.addDoisComponentes(auxJanela.msg("Tipo de Documento "), auxJanela.msg("Numero do Documento")));
        jpDoc.add(auxJanela.addDoisComponentes(jcTipoDoc, jtNumero));
        jpDoc.add(auxJanela.addDoisComponentes(auxJanela.msg("Provincia de Emissao"), auxJanela.msg("Distrito Emissao")));
        jpDoc.add(auxJanela.addDoisComponentes(jcProvEm, jcDistritoEm));
        jpDoc.add(auxJanela.addDoisComponentes(auxJanela.msg("Data de Emissao"), auxJanela.msg("")));
        jpDoc.add(auxJanela.addDoisComponentes(auxJanela.msg("Data"), auxJanela.msg("")));
        jpCentro.add(jpDadosPessoais);
        jpCentro.add(jpDoc);
        
        auxJanela.addCamponenteJanela(jpPrincipal, jpCentro, 'C');
        auxJanela.addCamponenteJanela(this, jpPrincipal, 'C');
        auxJanela.addCamponenteJanela(jpPrincipal, auxJanela.separador(), 'N');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'W');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'E');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'S');
        auxJanela.addCamponenteJanela(jpPrincipal, auxJanela.addDoisComponentes(jbVoltar, jbProx), 'S');
    
    
    }

    @Override
    public void Start() {
        jpCentro = auxJanela.jpPanel();
        jpPrincipal = auxJanela.jpPanel();
        jpDadosPessoais = auxJanela.jpPanel();
        jpDoc= auxJanela.jpPanel();
        jpNascimento= auxJanela.jpPanel();
        jtNome = new JTextField();
        jtApelido = new JTextField();
        jtNomePai = new JTextField();
        jtNomeMae = new JTextField();
        jtNumero = new JTextField();
        jcNacionalidade = new JComboBox();
        jcProv = new JComboBox();
        jcDistrito = new JComboBox();
        jcTipoDoc = new JComboBox();
        jcProvEm = new JComboBox();
        jcDistritoEm = new JComboBox();
        jrMasculino = new JRadioButton("Masculino");
        jrFemenino = new JRadioButton("Femenino");
        jrSolteiro = new JRadioButton("Solteiro");
        jrCasado = new JRadioButton("Casado");
        jdDataNasc = new DateChooserCombo();
        
        jbProx= auxJanela.ConfigBotao("Proximo");
        jbVoltar= auxJanela.ConfigBotao("Cancelar");
        auxJanela.bagGroundNull(jrMasculino);
        auxJanela.bagGroundNull(jrFemenino);
        auxJanela.bagGroundNull(jrSolteiro);
        auxJanela.bagGroundNull(jrCasado);
        //====Configuracao do painel
        auxJanela.setLayoutBord(this,10,10);
        auxJanela.setLayoutGrid(jpDadosPessoais, 8,1,10,10);
        auxJanela.setLayoutGrid(jpDoc, 8,1,10,10);
        auxJanela.setLayoutGrid(jpCentro, 2,1,10,10);
        auxJanela.setLayoutBord(jpPrincipal,10,10);
      
        this.setBackground(Color.DARK_GRAY);
        jbProx.setBackground(Color.GREEN);
        jbVoltar.setBackground(Color.RED);
        
        auxJanela.configBordaTitulo(this,"Cadastro de Dados Pessoais");
        auxJanela.configBordaTitulo(jpDadosPessoais,"Dados Pessoais");
        auxJanela.configBordaTitulo(jpDoc,"Dados de Nascimento");
        
        pessoa = new Pessoa();
        
    }

    @Override
    public void Evento() {
        
        jbProx.addActionListener((ae) -> {
            preencher();
            new Pessoa_Controler().addPessoa(pessoa);
        });
    }
    
    public void preencher(){
        pessoa.setApelido(jtApelido.getText());
        pessoa.setNome(jtNome.getText());
       // pessoa.setDataNasc(jtApelido.getText());
        pessoa.setEstadoCivil("Solteiro");
        pessoa.setEmail(jtApelido.getText());
       // pessoa.setSexo('M');
        pessoa.setDataNasc(new Date());
/*        pessoa.getNatural().setDistrito(jcDistrito.getSelectedItem().toString());
        pessoa.getNatural().setProvincia(jcProv.getSelectedItem().toString());
        pessoa.getNatural().setPais(jcNacionalidade.getSelectedItem().toString());
        JOptionPane.showMessageDialog(this,"Chegou");*/
    }
    
}
