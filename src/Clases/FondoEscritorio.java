/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class FondoEscritorio implements Border{
    
    private BufferedImage back;
 
   /* public FondoEscritorio(BufferedImage image){
        this.image=image;}
    
      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
          int x0 = x+ (width-image.getWidth())/2;
          int y0 = y+ (height-image.getHeight())/2;
          g.drawImage(image, x0, y0, null);
      }
      public Insets getBorderInsets(Component c){
          return new Insets (0,0,0,0);

      }  
      public boolean isBorderOpaque(){
          return true;
      }
        
    }*/

        public FondoEscritorio(){
        
        try {
            URL imagePath = new URL(getClass().getResource("../Imagenes/fondo.jpg").toString());
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {            
        }
    }

    /*public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(back, (x + (width - back.getWidth())/2),(y + (height - back.getHeight())/2), null);*/
        
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
          int x0 = x+ (width-back.getWidth())/2;
          int y0 = y+ (height-back.getHeight())/2;
          g.drawImage(back, x0, y0, null);
    }
 
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }
 
    public boolean isBorderOpaque() {
        return false;
    }
 
}
    

