/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import static VIEW.Auxiliar.auxJanela;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Barato Soft Solution
 */
public class Home extends JFrame implements Janela{
    private JPanel jpPrincipal, jpNorte, jpSul, jpEste, jpOeste;
    private static JScrollPane js;
    private static JPanel jpCentro;
    private Superior sp;
    private Menu mm;
    private Inicial inn;
    

    @Override
    public void Config() {
        Start();
        jpSul.add(new JLabel("Sul"));
       
        auxJanela.addCamponenteJanela(jpPrincipal, jpNorte, 'N');
        auxJanela.addCamponenteJanela(jpPrincipal, jpEste, 'W');
        auxJanela.addCamponenteJanela(jpPrincipal,jpCentro, 'C');
        auxJanela.addCamponenteJanela(jpPrincipal,jpSul, 'S');
        JPanel jp = new JPanel();
        jp.add(new JLabel("BEM VINDO"));
        addPainelCentro(inn);
        Evento();
        

    }

    @Override
    public void Start() {
        jpCentro= new JPanel();
        jpPrincipal= new JPanel();
        JPanel pp = new JPanel();
        inn=new Inicial();
        inn.Config();
                
        jpSul= new JPanel();
        jpEste= new JPanel();
        jpOeste= new JPanel();
        js = new JScrollPane();
        sp = new Superior();
        sp.Config();
        jpNorte= sp;
        
        mm = new Menu();
        mm.Config();
        jpEste=mm;
        auxJanela.setLayoutBord(pp, 0,0);
        
        //auxJanela.addCamponenteJanela(pp, new JScrollPane(jpPrincipal), 'C');
        auxJanela.setLayoutBord(jpCentro, 0,0);
        auxJanela.setLayoutBord(jpPrincipal,0,0);
        this.setMaximumSize(auxJanela.dimensionMax());
        this.setMinimumSize(auxJanela.dimensionMin());
        this.getContentPane().add(jpPrincipal);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void Evento() {
    }
    
    public  static void addPainelCentro(JPanel p){
        jpCentro.remove(js);
        js = new JScrollPane(p);
        js.setBackground(null);
        auxJanela.addCamponenteJanela( jpCentro,js, 'C');
        
    }
    
}
