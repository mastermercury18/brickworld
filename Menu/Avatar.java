import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Avatar{
   private int x;
   private int y;
   private int dx,dy;
   private ImageIcon myImage;

   public Avatar(int x1, int y1, ImageIcon i){
      x=x1;
      y=y1;
      myImage=i;
      dx=0;
      dy=0;
   
   }
   public void move(){
      x+=dx;
      y+=dy;
   }
   public void setdx(int x){
      dx=x;
   }
   public void setdy(int y){
      dy=y;
   }

   public int getX(){
      return x;
   }

   public int getY(){
      return y;
   }

   public void setX(int my_x){
      x = my_x;
   }

   public void setY(int my_y){
      y = my_y;
   }

   public void draw(Graphics g){
   //draws the image with upper left corner (x,y) using original size
     // g.drawImage(myImage.getImage(),x,y,null);
      
      //draws image with upper left corner (x,y) scaled to 25 pixels wide, 75 tall
       g.drawImage(myImage.getImage(),x, y, 75, 75,null);
   }

   public boolean collision(PewPew p){
      int blockx = p.getMyX();
      int blocky = p.getMyY();

      if (blockx>x&&blockx<x+75){
         if(blocky>y&&blocky<y+75) {
            return true;
         }
      }
      return false;

   }
   public void jumpTo(int newX, int newY){
      x = newX;
      y = newY;
   }
}