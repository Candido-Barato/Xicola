/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.Auxiliar.auxJanela;
import static View.Auxiliar.tr;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;




/**
 *
 * @author NAVANE
 */
public class Superior extends JPanel implements Janela{
    private JPanel jpLatDir, jpLatEsque, jpCentro;
    private JLabel log;
    private JComboBox jcAdmin, jcConta, jcIdioma;
    private JLabel relogio;
    private JButton jbMenuControler;
   
    
    
    @Override
    public void Config() {
        Start();
        auxJanela.addCamponenteJanela(jpLatDir, jcAdmin, 1,1,1,1);
        auxJanela.addCamponenteJanela(jpLatDir, auxJanela.separador(), 2,1,1,1);
        auxJanela.addCamponenteJanela(jpLatDir, jcIdioma, 3,1,1,1);
        auxJanela.addCamponenteJanela(jpLatDir, auxJanela.separador(), 4,1,1,1);
        auxJanela.addCamponenteJanela(jpLatDir, jcConta, 5,1,1,1);
        auxJanela.addCamponenteJanela(jpLatDir, auxJanela.separador(), 6,1,1,1);
        
        auxJanela.addCamponenteJanela(jpLatEsque, log, 1,1,1,1);
        //auxJanela.addCamponenteJanela(jpLatEsque, jbMenuControler, 1,2,1,1);
        configCentro();
        auxJanela.addCamponenteJanela(jpCentro, relogio, 1,1,1,1);
        
        auxJanela.addCamponenteJanela(this, jpLatEsque, 'W');
        auxJanela.addCamponenteJanela(this, jpLatDir, 'E');
        auxJanela.addCamponenteJanela(this, jpCentro, 'C');
        Evento();
        
    }

    @Override
    public void Start() {
        jpLatDir = new JPanel();
        jpLatEsque = new JPanel();
        jpCentro = new JPanel();
        auxJanela.setLayoutBord(this, 10,10);
        auxJanela.setLayoutGridBag(jpLatDir);
        auxJanela.setLayoutGridBag(jpLatEsque);
       // jbMenuControler= auxJanela.ConfigBotao("");
        //jbMenuControler.setIcon(tr.criarImage("/Img/Icon/Menu-Down.png", 40, 20));
        jcAdmin = new JComboBox(new Object[]{"Administrador","Configurar"});
        jcConta = new JComboBox(new Object[]{"Usuario","LogOut","Change"});
        jcIdioma = new JComboBox(new Object[]{"Portugues","Ingles",});
        
        jcAdmin.setPreferredSize(auxJanela.dimensionComponente());
        jcConta.setPreferredSize(auxJanela.dimensionComponente());
        jcIdioma.setPreferredSize(auxJanela.dimensionComponente());
        log = auxJanela.msg("Logotipo");
        relogio = auxJanela.msg("");
        log.setPreferredSize(auxJanela.dimensionComponente());
        
        this.setBackground(new Color(22, 59, 67));
        jpLatDir.setBackground(null);
        jpLatEsque.setBackground(null);
        jpCentro.setBackground(null);
    }

    @Override
    public void Evento() {
       
    }
    
    //Configuracao do painel de horas
    public void configCentro(){
        ActionListener t = (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hora();
            }
        });
        Timer time = new Timer(1000, t);
        time.start();
    
    }
    public void hora() {
        int hh, mm, ss;
        String np;
        Calendar hora = Calendar.getInstance();
        hh = hora.get(Calendar.HOUR_OF_DAY);
        mm = hora.get(Calendar.MINUTE);
        ss = hora.get(Calendar.SECOND);
        DecimalFormat formato = new DecimalFormat("00");
        if(hh>=18)
            np="( PM )";
        else
            np="( AM )";
         
            
        relogio.setText(String.format("%2s %s %2s %s %2s %4s", formato.format(hh % 12),":",formato.format(mm),":",formato.format(ss),np));
       
    }
    


}
