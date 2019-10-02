/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import static VIEW.Auxiliar.auxJanela;
import VIEW.Formacao.Alunos;
import static VIEW.Home.addPainelCentro;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Barato Soft Solution
 */
public class Formacaoo extends JPanel implements Janela{
    private JPanel jpCentro, jpPrincipal;
    private JButton jbAluno, jbFormador, jbTurma, jbServicos;
    private JTextField jtNome, jtApelido, jtNomePai, jtNomeMae;

    @Override
    public void Config() {
        Start();
        Evento();
        auxJanela.addCamponenteJanela(this, jpPrincipal, 'C');
        auxJanela.addCamponenteJanela( jpPrincipal,jpCentro, 'N');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'E');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'W');
        
        jpCentro.add(jbAluno);
        jpCentro.add(jbFormador);
        jpCentro.add(jbTurma);
        jpCentro.add(jbServicos);
        jpCentro.add(jtApelido);
        jpCentro.add(jtNome);
        jpCentro.add(jtNomeMae);
        jpCentro.add(jtNomePai);
    }

    @Override
    public void Start() {
        jpCentro=auxJanela.jpPanel();
        jpPrincipal=auxJanela.jpPanel();
        auxJanela.configBordaTitulo(this,"Formacao");
        jbFormador = auxJanela.ConfigBotao("Formador");
        jbAluno = auxJanela.ConfigBotao("Aluno");
        jbTurma = auxJanela.ConfigBotao("Turmas");
        jbServicos = auxJanela.ConfigBotao("Cursos");
        this.setBackground(Color.DARK_GRAY);
        auxJanela.setLayoutBord(this, 10, 10);
        auxJanela.setLayoutBord(jpPrincipal, 10, 10);
        auxJanela.setLayoutGrid(jpCentro,4,2, 20,20);
        
         jtNome = new JTextField();
        jtApelido = new JTextField();
        jtNomePai = new JTextField();
        jtNomeMae = new JTextField();
    }

    @Override
    public void Evento() {
        jbAluno.addActionListener((ae) -> {
            Alunos al = new Alunos();
            al.Config();
            addPainelCentro(al);
          /*  Cadastro_Pessoa  cp = new Cadastro_Pessoa();
            cp.Config();
              
        */
        });
       
    }
    
}
