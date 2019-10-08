/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author NAVANE
 */
public class TratarImagem extends JPanel{
   private JLabel imag;
       private JPanel pO;
    
    public static File selecionarImagem(){
        JFileChooser f=new JFileChooser();
        FileNameExtensionFilter filtro=new FileNameExtensionFilter ("Imagens em JPEG e PNG","jpg","png");
        f.addChoosableFileFilter(filtro);
        f.setAcceptAllFileFilterUsed(false);
        f.setDialogType(JFileChooser.OPEN_DIALOG);
        f.setCurrentDirectory(new File("C:"));
        f.showOpenDialog(null);
        return f.getSelectedFile();
    }
    
    
    public ImageIcon abrirImagem(Object source){
        ImageIcon icon=new ImageIcon(getClass().getResource("/Img/Icon/PerfilUser.png"));
        if(source!=null)
        if(source instanceof File){
            File imagem=(File)source ;
            icon=new ImageIcon(imagem.getAbsolutePath());
        }else
            if(source instanceof byte[]){
                icon=new ImageIcon((byte[]) source);
            }
        else
            icon=new ImageIcon(getClass().getResource("/Img/Icon/PerfilUser.png"));
       return icon;
    }
    
    public static void setImagem(JLabel image, ImageIcon icon){
            icon.setImage(icon.getImage().getScaledInstance(image.getWidth(), image.getHeight(), 100));
            image.setIcon(icon);
    }
    
        public static byte[] getImagem(File imagens){
        boolean isPng=false;
        if(imagens!=null){
            isPng=imagens.getName().endsWith("png")||imagens.getName().endsWith("jpg");
            try{
                BufferedImage image=ImageIO.read(imagens);
                ByteArrayOutputStream out=new ByteArrayOutputStream();
                
                int type=BufferedImage.TYPE_INT_RGB;
                
                if(isPng){
                    type=BufferedImage.BITMASK;
                }
                BufferedImage novaImagem=new BufferedImage(75,75,type);
                Graphics2D g=novaImagem.createGraphics();
                g.setComposite(AlphaComposite.Src);
                g.drawImage(image,0,0,75,75, null);
                
                if(isPng){
                    ImageIO.write(novaImagem, "png",out);
                }else{
                    ImageIO.write(novaImagem,"jpg",out);
                }
                out.flush();
                byte[] byteArray=out.toByteArray();
                out.close();
                return byteArray;
                
            }catch(IOException e){
               JOptionPane.showMessageDialog(null,"Ocorreu um erro! Na leitura dos dados","Messagem",JOptionPane.ERROR_MESSAGE); 
            }
        }
        
        return null;
    }
        
    public ImageIcon criarImage(String url, int n, int m){
        ImageIcon im=new ImageIcon();
        try {
           im = new ImageIcon(getClass().getResource(url));
           im.setImage(im.getImage().getScaledInstance(n, m, 100));
        } catch (NullPointerException e) {
            System.out.println("Erro "+e.getMessage());
        }
        return im;
    
    }
    
}
