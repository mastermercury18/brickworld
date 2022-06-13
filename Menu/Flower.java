import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Flower{
   private int x;
   private int y;
   private Color petalColor;
   
   public Flower(int x1, int y1, Color p){
      x=x1;
      y=y1;
      petalColor = p;
   }
   public void setPetalColor(Color p){
      petalColor=p;
   }
   public void draw(Graphics g){
   
      g.setColor(petalColor);
      g.fillOval(x-25, y-25,50,50);
      g.fillOval(x+25, y-25,50,50);
      g.fillOval(x+25, y+25,50,50);
      g.fillOval(x-25, y+25,50,50);
      
      g.setColor(new Color(255,214,57));
      g.fillOval(x, y, 50,50);
   
   }


}