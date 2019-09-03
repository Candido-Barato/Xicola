/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Formulario;

import Controler.Localizacao_Controler;
import static Controler.Localizacao_Controler.listaBairro;
import static Controler.Localizacao_Controler.listaDistrito;
import static Controler.Localizacao_Controler.listaPais;
import static Controler.Localizacao_Controler.listaProvincia;
import Controler.Pessoa_Controler;
import Model.Pessoa;
import static View.Auxiliar.auxJanela;
import View.Janela;
import datechooser.beans.DateChooserCombo;
import java.awt.Color;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Barato Soft Solution
 */
public class Cadastro_Pessoa extends JPanel implements Janela {

    private JPanel jpCentro, jpPrincipal, jpDadosPessoais, jpDoc, jpNascimento;
    private JTextField jtNome, jtApelido, jtNomePai, jtNomeMae, jtNumero;
    private JButton jbProx, jbVoltar;
    //private J
    private JComboBox jcNacionalidade, jcProv, jcDistrito, jcTipoDoc, jcProvEm, jcDistritoEm;
    private JRadioButton jrMasculino, jrFemenino, jrSolteiro, jrCasado;
    private Pessoa pessoa;
    private Localizacao_Controler lc;
    private DateChooserCombo jdDataNasc;
    JComboBox aux = new JComboBox();
    int cod = 0;

    @Override
    public void Config() {
        Start();
        Evento();
        lc.buscaPais();
        lc.buscaProvincia();
        lc.buscaDistrito();
        comporComb();

        jpDadosPessoais.add(auxJanela.addDoisComponentes(auxJanela.msg("Nome"), auxJanela.msg("Apelido")));
        jpDadosPessoais.add(auxJanela.addDoisComponentes(jtApelido, jtNome));
        jpDadosPessoais.add(auxJanela.addDoisComponentes(auxJanela.msg("Genero"), auxJanela.msg("Estado Civil")));
        jpDadosPessoais.add(auxJanela.addDoisComponentes(auxJanela.addDoisComponentes(jrMasculino, jrFemenino), auxJanela.addDoisComponentes(jrSolteiro, jrCasado)));
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
        jpDoc = auxJanela.jpPanel();
        jpNascimento = auxJanela.jpPanel();
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

        jbProx = auxJanela.ConfigBotao("Proximo");
        jbVoltar = auxJanela.ConfigBotao("Cancelar");
        auxJanela.bagGroundNull(jrMasculino);
        auxJanela.bagGroundNull(jrFemenino);
        auxJanela.bagGroundNull(jrSolteiro);
        auxJanela.bagGroundNull(jrCasado);
        //====Configuracao do painel
        auxJanela.setLayoutBord(this, 10, 10);
        auxJanela.setLayoutGrid(jpDadosPessoais, 8, 1, 10, 10);
        auxJanela.setLayoutGrid(jpDoc, 8, 1, 10, 10);
        auxJanela.setLayoutGrid(jpCentro, 2, 1, 10, 10);
        auxJanela.setLayoutBord(jpPrincipal, 10, 10);

        this.setBackground(Color.DARK_GRAY);
        jbProx.setBackground(Color.GREEN);
        jbVoltar.setBackground(Color.RED);

        auxJanela.configBordaTitulo(this, "Cadastro de Dados Pessoais");
        auxJanela.configBordaTitulo(jpDadosPessoais, "Dados Pessoais");
        auxJanela.configBordaTitulo(jpDoc, "Dados de Nascimento");

        pessoa = new Pessoa();
        lc = new Localizacao_Controler();

    }

    @Override
    public void Evento() {

        jbProx.addActionListener((ae) -> {
            preencher();
            new Pessoa_Controler().addPessoa(pessoa);
        });
        jcNacionalidade.addActionListener((ie) -> {
            boolean achado = false;
            for (int i = 0; i < listaPais.size() && achado == false; i++) {
                achado = listaPais.get(i).getPais().equalsIgnoreCase(jcNacionalidade.getSelectedItem().toString());
                if (achado) {
                    cod = listaPais.get(i).getCodPais();
                }
            }
            // JOptionPane.showMessageDialog(null, cod);
            if (achado) {
                aux.removeAllItems();
                listaProvincia.forEach((t) -> {
                    if (t.getCodPais() == cod) {
                        aux.addItem(t.getProvincia());
                    }
                });

                if (aux.getComponentCount() > 0) {
                    jcProv = aux;
                }
               /* aux.removeAllItems();
                listaDistrito.forEach((t) -> {
                    if (t.getId_Prov() == cod) {
                        aux.addItem(t.getDistrito());
                    }
                });
                if (aux.getComponentCount() > 0) {
                    jcDistrito = aux;
                }*/
            }

        });
        jcProv.addActionListener((ie) -> {
            /* boolean achado = false;
            aux.removeAllItems();
            for (int i = 0; i < listaProvincia.size() && achado == false; i++) {
                achado = listaProvincia.get(i).getProvincia().equalsIgnoreCase(jcProv.getSelectedItem().toString());
                if (achado) {
                    cod = listaProvincia.get(i).getId_Prov();
                }
            }
            if (achado) {
                
            }
            if (aux.getComponentCount() > 0) {
                    jcDistrito = aux;
                }
        });
        jcProv.addItemListener((ie) -> {
            boolean achado = false;
            aux.removeAllItems();
            for (int i = 0; i < listaProvincia.size() && achado == false; i++) {
                achado = listaProvincia.get(i).getProvincia().equalsIgnoreCase(jcProv.getSelectedItem().toString());
                if (achado) {
                    cod = listaProvincia.get(i).getId_Prov();
                }
            }
            if (achado) {
                
                listaDistrito.forEach((t) -> {
                    if (t.getId_Prov() == cod) {
                        aux.addItem(t.getDistrito());
                    }
                });
               
            }
            if (aux.getComponentCount() > 0) {
                    jcDistrito = aux;
                }*/
        });
    }

    public void preencher() {
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

    public void comporComb() {
        listaPais.forEach((t) -> {
            jcNacionalidade.addItem(t.getPais());
        });
        listaProvincia.forEach((t) -> {
            jcProv.addItem(t.getProvincia());
            jcProvEm.addItem(t.getProvincia());
        });
        listaDistrito.forEach((t) -> {
            jcDistrito.addItem(t.getDistrito());
            jcDistritoEm.addItem(t.getDistrito());
        });
        /* listaBairro.forEach((t) -> {
            jcNacionalidade.addItem(t.getPais());
        });*/
    }
}
