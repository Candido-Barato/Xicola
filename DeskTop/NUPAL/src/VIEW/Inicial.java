/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import static VIEW.Auxiliar.auxJanela;
import static VIEW.Auxiliar.tr;
import VIEW.Formacao.Alunos;
import static VIEW.Home.addPainelCentro;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Barato Soft Solution
 */
public class Inicial extends JPanel implements Janela {

    private JPanel jpCentro;
    private JButton jbAluno, jbFormador, jbTurma, jbServicos, jbCursos, jbNivelAcademico,
            jbMatricula, jbPagamentos, jbDisciplinas, jbAvaliacoes;

    @Override
    public void Config() {
        Start();
        Evento();
        auxJanela.addCamponenteJanela(this, jpCentro, 'C');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'E');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'W');
        jbAluno.setBackground(Color.GREEN);
        jbCursos.setBackground(Color.GREEN);
        jbServicos.setBackground(Color.GREEN);
        jbAluno.setLayout(new GridBagLayout());
        JLabel ic = new JLabel(tr.criarImage("/Img/Icon/menu.png", 50, 50));
        JLabel nr = new JLabel("1");
        nr.setBackground(Color.BLACK);
        nr.setForeground(Color.WHITE);
        auxJanela.addCamponenteJanela(jbAluno, nr,1,1,1,1);
        auxJanela.addCamponenteJanela(jbAluno, new JLabel("Aluno"),1,2,1,1);
        auxJanela.addCamponenteJanela(jbAluno, ic,2,1,1,2);
        auxJanela.addCamponenteJanela(jbAluno, new JLabel("Abrir"),1,3,2,1);
        jpCentro.add(jbServicos);
        jpCentro.add(jbNivelAcademico);
        jpCentro.add(jbMatricula);
        jpCentro.add(jbPagamentos);
        jpCentro.add(jbAluno);
        jpCentro.add(jbFormador);
        jpCentro.add(jbTurma);
        jpCentro.add(jbCursos);
        jpCentro.add(jbDisciplinas);
        jpCentro.add(jbAvaliacoes);
        
        
        
    }

    @Override
    public void Start() {
        jpCentro = auxJanela.jpPanel();
        auxJanela.configBordaTitulo(this, "Painel Principal");
        jbFormador = auxJanela.ConfigBotao("Formador");
        jbAluno = auxJanela.ConfigBotao("");
        jbTurma = auxJanela.ConfigBotao("Turmas");
        jbServicos = auxJanela.ConfigBotao("Servicos");
        jbCursos = auxJanela.ConfigBotao("Cursos");
        jbPagamentos = auxJanela.ConfigBotao("Pagamentos");
        jbNivelAcademico = auxJanela.ConfigBotao("Nivel Academico");
        jbMatricula = auxJanela.ConfigBotao("Matricula");
        jbDisciplinas = auxJanela.ConfigBotao("Disciplinas");
        jbAvaliacoes = auxJanela.ConfigBotao("Avaliacoes");
        jbMatricula = auxJanela.ConfigBotao("Matricula");
        this.setBackground(Color.DARK_GRAY);
        auxJanela.setLayoutBord(this, 10, 10);
        auxJanela.setLayoutGrid(jpCentro, 3, 4, 10, 30);

    }

    @Override
    public void Evento() {
        jbAluno.addActionListener((ae) -> {
            Alunos al = new Alunos();
            al.Config();
            addPainelCentro(al);
        });

    }

}
