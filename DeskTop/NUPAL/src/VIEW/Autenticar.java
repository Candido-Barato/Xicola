/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import CONTROLER.AutenticarControler;
import static VIEW.Auxiliar.auxJanela;
import static VIEW.Auxiliar.tr;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Barato Soft Solution
 */
public class Autenticar extends JDialog implements Janela {

    private JButton entrar, sair,esqueceu;
    private JTextField jtUsername;
    private JPasswordField jpSenha;
    private JPanel jpPrincipal, jpCentro, jpSul, jpNorte;
    private JLabel fundoImagem;
    private JLabel logotipo;

    @Override
    public void Config() {
        Start();
        auxJanela.setLayoutBord(jpPrincipal, 10, 10);
        auxJanela.setLayoutGridBag(fundoImagem);
        fundoImagem.setIcon(tr.criarImage("/Img/personas-sentadasEd.jpg", auxJanela.dimensionMin().width, auxJanela.dimensionMin().height));
        logotipo.setIcon(tr.criarImage("/Img/personas-sentadasEd.jpg", auxJanela.dimensionMin().width, 75));
        auxJanela.addCamponenteJanela(jpPrincipal, fundoImagem, 'C');
        auxJanela.addCamponenteJanela(fundoImagem, auxJanela.msg("Username",' '), 1, 3, 3, 1);
        auxJanela.addCamponenteJanela(fundoImagem, jtUsername, 1, 4, 3, 1);
        auxJanela.addCamponenteJanela(fundoImagem, auxJanela.msg("Senha",' '), 1, 5, 3, 1);
        auxJanela.addCamponenteJanela(fundoImagem, jpSenha, 1, 6, 3, 1);
        auxJanela.addCamponenteJanela(fundoImagem, auxJanela.separador(), 1, 7, 1, 1);
        auxJanela.addCamponenteJanela(fundoImagem, auxJanela.msg("Se esqueceu palavra passe clique aqui",'C'),2, 8, 1, 1);
        auxJanela.addCamponenteJanela(fundoImagem, auxJanela.msg("*                          ",'C'),3, 8, 1, 1);
        auxJanela.addCamponenteJanela(fundoImagem, auxJanela.msg("                          *",'C'),1, 8, 1, 1);
        auxJanela.addCamponenteJanela(fundoImagem, sair, 1, 9, 1, 1);
        auxJanela.addCamponenteJanela(fundoImagem, entrar, 3, 9, 1, 1);
        
        this.setVisible(true);
        this.setMaximumSize(auxJanela.dimensionMax());
        this.setMinimumSize(auxJanela.dimensionMin());
        this.setResizable(false);
        Evento();

    }

    @Override
    public void Start() {
        entrar = auxJanela.ConfigBotao("Entrar");
        sair = auxJanela.ConfigBotao("Cancelar");
        jtUsername = new JTextField(50);
        jpSenha = new JPasswordField(10);
        jpPrincipal = auxJanela.jpPanel();
        jpCentro = auxJanela.jpPanel();
        this.getContentPane().add(jpPrincipal);
        fundoImagem = new JLabel();
        logotipo = new JLabel();
        entrar.setBackground(Color.GREEN);
        sair.setBackground(Color.ORANGE);

    }

    @Override
    public void Evento() {
        entrar.addActionListener((ae) -> {
            AutenticarControler autC = new AutenticarControler();
            String senha=new String(jpSenha.getPassword());
            if(autC.login(jtUsername.getText(), senha)){
                Home hm = new Home();
                hm.Config();
                this.dispose();
                hm.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Acesso Down "+senha+" "+jtUsername.getText());
            }
        });
        sair.addActionListener((ae) -> {
            System.exit(1);
        });

    }

   

}
