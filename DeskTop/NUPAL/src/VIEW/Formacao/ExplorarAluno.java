/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW.Formacao;

import static VIEW.Auxiliar.auxJanela;
import VIEW.Janela;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Barato Soft Solution
 */
public class ExplorarAluno extends JPanel implements Janela{
    public JTextField jtCodigo, jtNome;
    public JList jlServico;
    

    @Override
    public void Config() {
        Start();
        auxJanela.addCamponenteJanela(this,auxJanela.msg("Pick",' '), 1, 1, 1, 1);
        auxJanela.addCamponenteJanela(this, jtCodigo,1, 2, 1, 1);
        auxJanela.addCamponenteJanela(this, jtNome,1, 3, 1, 1);
        auxJanela.addCamponenteJanela(this,auxJanela.msg("Lista de Servicos",' '), 1, 4, 1, 1);
        auxJanela.addCamponenteJanela(this, jlServico,1, 5, 1, 1);
        Evento();
        this.setVisible(false);
    }

    @Override
    public void Start() {
        jtCodigo = new JTextField("Codigo",10);
        jtNome = new JTextField("Nome Completo",10);
        jlServico = new JList(new Object[]{"Explicacao", "Preparacao de Exames","Cursos de Ingles","Curso de Informatica"});
        this.setBackground(null);
        auxJanela.setLayoutGridBag(this);
        this.setSize(new Dimension(100,100));
        this.setBorder( javax.swing.BorderFactory.createEtchedBorder());
    }

    @Override
    public void Evento() {

    }

    public JTextField getJtCodigo() {
        return jtCodigo;
    }

    public void setJtCodigo(JTextField jtCodigo) {
        this.jtCodigo = jtCodigo;
    }

    public JTextField getJtNome() {
        return jtNome;
    }

    public void setJtNome(JTextField jtNome) {
        this.jtNome = jtNome;
    }

    public JList getJlServico() {
        return jlServico;
    }

    public void setJlServico(JList jlServico) {
        this.jlServico = jlServico;
    }
    
    
}
