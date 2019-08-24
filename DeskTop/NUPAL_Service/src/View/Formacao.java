/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.Auxiliar.auxJanela;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Barato Soft Solution
 */
public class Formacao extends JPanel implements Janela{
    private JPanel jpCentro, jpPrincipal, jpNorte, jpSull;
    private JButton jbAluno, jbFormador, jbTurma, jbServicos;

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
    }

    @Override
    public void Start() {
        jpCentro=auxJanela.jpPanel();
        jpPrincipal=auxJanela.jpPanel();
        jpNorte=auxJanela.jpPanel();
        jpSull=auxJanela.jpPanel();
        auxJanela.configBordaTitulo(this,"Janela Formacao");
        jbFormador = auxJanela.ConfigBotao("Formador");
        jbAluno = auxJanela.ConfigBotao("Aluno");
        jbTurma = auxJanela.ConfigBotao("Turmas");
        jbServicos = auxJanela.ConfigBotao("Servicos");
        this.setBackground(Color.DARK_GRAY);
        auxJanela.setLayoutBord(this, 10, 10);
        auxJanela.setLayoutBord(jpPrincipal, 10, 10);
        auxJanela.setLayoutGrid(jpCentro,2,4, 20,20);
    }

    @Override
    public void Evento() {
    }
    
}
