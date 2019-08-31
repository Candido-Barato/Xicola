/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author bdb
 */
public class ConfigJanela {
private  Font f = new java.awt.Font("Times New Roman", 2, 18);
    

    public void addCamponenteJanela(JPanel dest, JComponent comp,
            int gx, int gy, int lx, int ly) {
      GridBagConstraints   gbc = new GridBagConstraints();
        gbc.gridx = gx;
        gbc.gridy = gy;
        gbc.gridwidth = lx;
        gbc.gridheight = ly;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        
        dest.add(comp,gbc);
    }

    public void setLayoutGridBag(JComponent comp) {
        comp.setLayout(new GridBagLayout());
    }

    public void setLayoutBord(JComponent comp, int x, int y) {
        comp.setLayout(new BorderLayout(x, y));
    }
    public void setLayoutGrid(JComponent comp, int x, int y, int xl, int yl) {
        comp.setLayout(new GridLayout(x, y,xl,yl));
    }

    public void addCamponenteJanela(JPanel jp, JComponent comp, char loc) {
        String x=loc+"";
        loc=x.toUpperCase().charAt(0);
        switch (loc) {
            case 'C':
                jp.add(comp, BorderLayout.CENTER);
                break;
            case 'S':
                jp.add(comp, BorderLayout.SOUTH);
                break;
            case 'E' :
                jp.add(comp, BorderLayout.EAST);
                break;
            case 'W' :
                jp.add(comp, BorderLayout.WEST);
                break;
            case 'N':
                jp.add(comp, BorderLayout.NORTH);
                break;

        }

    }

    public Dimension dimensionMax(){
        int largura = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int altura = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    return new Dimension(largura, altura);
    }
    
   
    
    public Dimension dimensionMin(){
        int largura = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.75);
        int altura = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.75);
    return new Dimension(largura, altura);
    }
    
    
    public  JButton ConfigBotao(String sms) {
        JButton b = new JButton();
        b.setText(sms);
        b.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        b.setForeground(Color.WHITE);
        b.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        b.setBackground(null);
        b.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        return b;

    }
    
    public  JLabel msg(String ms) {
        JLabel msg = new JLabel(ms);
        msg.setFont(new Font("Times New Roman", 1, 20));
        msg.setForeground(new Color(255, 255, 255));
        msg.setBackground(null);
        return msg;
    }
    
    public void componetFormat(JComponent comp){
        comp.setFont(new Font("Times New Roman", 1, 20));
        comp.setForeground(new Color(255, 255, 255));
        comp.setBackground(null);
    }
    
    public JPanel jpPanel(){
        JPanel p = new JPanel();
        p.setBackground(null);
        return p;
    }
    
    public  JLabel separador() {
        JLabel l = new JLabel();
       // l.setSize(50, 50);
        l.setPreferredSize(new Dimension(30, 50));
        l.setBackground(null);
        return l;
    }
    
    public Dimension dimensionComponente(){
       return new Dimension(100,25);
    
    }
    
    public  String dataString(Date d) {
        Calendar ca;
        ca = Calendar.getInstance();
        ca.setTime(d);
        return String.format("%2s/%2s/%4d", s(ca.get(Calendar.DAY_OF_MONTH)), s(1 + ca.get(Calendar.MONTH)), ca.get(Calendar.YEAR));
    }
    public  String s(int j) {
        if (j >= 10) {
            return j + "";
        } else {
            return "0" + j;
        }
    }
    
    public void configBordaTitulo(JPanel jp, String tt){
    jp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, tt, 
                javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP,
                f, Color.GREEN));
    }
    
    public void bagGroundNull(JComponent jc){
        jc.setBackground(null);
        jc.setForeground(Color.WHITE);
    }
    
    public JPanel addDoisComponentes(JComponent jc1,JComponent jc2){
        JPanel p = jpPanel();
        setLayoutGrid(p, 1, 2, 20, 5);
        p.add(jc1);
        p.add(jc2);
        
        return p;
    }
}
