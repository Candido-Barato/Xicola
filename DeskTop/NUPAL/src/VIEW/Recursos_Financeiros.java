/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import static VIEW.Auxiliar.auxJanela;
import javax.swing.JPanel;

/**
 *
 * @author Barato Soft Solution
 */
public class Recursos_Financeiros extends JPanel implements Janela{
    private JPanel jpCentro, jpPrincipal, jpNorte, jpSull;

    @Override
    public void Config() {
        Start();
        Evento();
        auxJanela.addCamponenteJanela(this, jpPrincipal, 'C');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'E');
        auxJanela.addCamponenteJanela(this, auxJanela.separador(), 'W');
    }

    @Override
    public void Start() {
        jpCentro=auxJanela.jpPanel();
        jpPrincipal=auxJanela.jpPanel();
        jpNorte=auxJanela.jpPanel();
        jpSull=auxJanela.jpPanel();
        auxJanela.configBordaTitulo(this,"Janela Recursos Financeiros");
        
        auxJanela.setLayoutBord(this, 10, 10);
    }

    @Override
    public void Evento() {
    }
    
}
