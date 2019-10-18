/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.BO;

import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ValidarCampo {
    private String textoErro;
    public ValidarCampo() {
    }
    
    public boolean validString(String tx,byte min, byte max){
        boolean a = tx.length()>min && tx.length()<max && !tx.isEmpty();
        textoErro = "";
        if(tx.isEmpty()){
            textoErro = "Nao Pode ser Vazio";
        }
        if(!(tx.length()>min && tx.length()<max)){
        textoErro += "/n Deve conter entre ["+min+" e "+max+"] Caracteres";
        }
        return a;
    }

    public String getTextoErro() {
        return textoErro;
    }

    public void setTextoErro(String textoErro) {
        this.textoErro = textoErro;
    }
    
    
    public boolean validarB(JFormattedTextField tx){
         boolean a = true;
        if(tx.getText().isEmpty()){
            tx.setToolTipText("O Campo nao deve fica vazio");
        }else{
        if(tx.getText().length()!=16){
            tx.setToolTipText("Verifica o tamanho do texto caracteres");
            a=false;
        }}
        return a;}
    
    public int validarInt(JTextField tx, int min, int max){
        int a=-1;
        try {
            a=Integer.parseInt(tx.getText());
            if(a<min || a>max){
                a=-1;
                tx.setToolTipText("Verifica o campo! deve estar entre ["+min+" - "+max+"]");
            }else{
                tx.setBorder(null);
                tx.setToolTipText(null); 
            }
        } catch (NumberFormatException e) {
            tx.setToolTipText("Verifica o campo! Nao sao aceites caracteres so digitos");
        }
        return a;
    }
    
    public static String dat(Date d) {
        Calendar ca;
        ca=Calendar.getInstance();
		ca.setTime(d);
            return String.format("%2d/%2d/%4d", ca.get(Calendar.DAY_OF_MONTH),1+ca.get(Calendar.MONTH),ca.get(Calendar.YEAR));
	}
    
    public static String dias(){
        Calendar ca;
        ca=Calendar.getInstance();
		ca.setTime(dataatual());
            return String.format("%2d-%2d-%4d-%2d:%2d:%2d", ca.get(Calendar.DAY_OF_MONTH),1+ca.get(Calendar.MONTH),ca.get(Calendar.YEAR),ca.get(Calendar.HOUR),ca.get(Calendar.MINUTE),ca.get(Calendar.SECOND));
    
    }
    
    public void preencherNUIT(JFormattedTextField jt, String nuit){
        if(nuit!=null)
        if(nuit.length()==16){
        try{
            int a1 = Integer.parseInt(nuit.substring(0, 4));
            int a2 = Integer.parseInt(nuit.substring(5,9));
            int a3 = Integer.parseInt(nuit.substring(10, 14));
        jt.setText(a1+""+a2+""+a3+nuit.substring(15));
        }catch(NumberFormatException ex){
        }
    }}
    
    public boolean validBI(JFormattedTextField tx){
        JOptionPane.showMessageDialog(null, tx.getText().length()+"Tamanho");
        
        if(tx.getText().length()!=16){
            JOptionPane.showMessageDialog(null, "Ivalido");
        }
        return (tx.getText().length()==16);
    }
    
    public int preencherNtel(JFormattedTextField jt,int min, int max){
        String x = jt.getText();
        int j=-1;
        if(x!=null){
        if(x.length()==18){
            try{
                j=Integer.parseInt(x.substring(7, 10)+""+x.substring(11, 14)+""+x.substring(15, 18));
                System.out.println(j);
                if(j<min || j>max){
                    j=-1;
                    jt.setToolTipText("Verifica o campo! deve estar entre ["+min+" - "+max+"]");
                }
                else{
                    jt.setToolTipText(null);
                }
            }catch(NumberFormatException ex){
                 jt.setToolTipText("Verifica o campo! Nao sao aceites caracteres so digitos");
                 j=-1;
            }}}
        return j;
    }
    
    public static java.util.Date dataatual(){
        Date day = new Date();
        day.setTime(new Date().getTime());
        return day;
    }
    
    public void preencherDate(JFormattedTextField jt, Date d){
        Calendar ca= Calendar.getInstance();
        Date day = new Date(new Date().getTime());
        String x="";
            if(d!=null)
                ca.setTime(d);
            else{
                ca.setTime(day);
            }
            int mes=1+ca.get(Calendar.MONTH);
            int dia=ca.get(Calendar.DAY_OF_MONTH);
            int ano=ca.get(Calendar.YEAR);
                    if(dia<10)
                        x+=0+""+dia+"";
                    else
                        x+=dia+"";
                    if(mes<10)
                        x+=0+""+mes+"";
                    else
                        x+=mes+"";
                    x+=ano;
                      jt.setText(x);
                }
    
   
    
    
     public Date validarData(JFormattedTextField jt){
        DateFormat df;
        Calendar calendar;
        Calendar ca;
        calendar=new GregorianCalendar();
        ca=Calendar.getInstance();

        df=new SimpleDateFormat("dd/MM/yyyy");
            Date da = null;
            int ano;
            boolean f;
            df.setLenient(false);	
            f=true;
                try{
                    da=df.parse(jt.getText());
                    calendar.setTime(da);
                }catch(NullPointerException nf){
                            
		}catch(ParseException pr){
                    f=false;}
            ano=calendar.get(Calendar.YEAR); //Obtem-se o ano 	
            if(ano<1960 || ano>ca.get(Calendar.YEAR) || f==false){
                jt.setToolTipText("Data Invalida");
            }
            else{
                jt.setBorder(null);
                jt.setToolTipText(null);
            }
                        
	return 	da;
	}
    public static java.sql.Date dataSQL(java.util.Date dia){
    return new java.sql.Date(dia.getTime());
    }
    
   public static java.util.Date  dataUtil(java.sql.Date dia){
    return new java.util.Date(dia.getTime());
    }
   
   public static java.util.Date  dataUtilG(JDateChooser dia){
    return new java.util.Date(dia.getDate().getTime());
    }
    
    public java.time.Year converAno(JFormattedTextField f){
        return Year.parse(f.getText()+"");
    }
    
}
