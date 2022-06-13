import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class ImagePanel extends JPanel{
   public static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(29, 49, 173);

   private BufferedImage myImage;
   private Graphics myBuffer;
   private Avatar myAvatar;
   private Timer t;
   
   public ImagePanel()
   {
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      
      //the file you want to use needs to be saved in the same folder
      //can use jpg,jpeg, gif, or png
      ImageIcon me = new ImageIcon("maps/kirby.png");
      
      myAvatar = new Avatar(0,0,me);
      myAvatar.draw(myBuffer);
      
      addKeyListener(new Key());   
      setFocusable(true); 
      
      t = new Timer(5, new AnimationListener());
   
   }
   public void begin(){
      t.start();
   }

   public void paintComponent(Graphics g)  //Required method to paint to the screen
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field
   }
   private class Key extends KeyAdapter  //This subpanel must have focus for keyboard input to register (see above)
   {
      public void keyPressed(KeyEvent e)  //We override this method; "e" contains a lot of information...
      {
         if(e.getKeyCode() == KeyEvent.VK_DOWN ){
            myAvatar.setdy(2);
           
         }
         else if(e.getKeyCode()==KeyEvent.VK_UP){
            myAvatar.setdy(-2);
            
         }
         else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            myAvatar.setdx(-2);
            
         }
         else if(e.getKeyCode()==KeyEvent.VK_RIGHT ){
            myAvatar.setdx(2);
            
         }
      }
      public void keyReleased(KeyEvent e)  //Note keyReleased is called when... a key is released!
      {
         if(e.getKeyCode() == KeyEvent.VK_DOWN){
            myAvatar.setdy(0);
            
         }
         else if(e.getKeyCode()==KeyEvent.VK_UP){
            myAvatar.setdy(0);
            
         }
         else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            myAvatar.setdx(0);
           
         }
         else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            myAvatar.setdx(0);
            
         }
      }
   }
   private class AnimationListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)  //Gets called over and over by the Timer
      {
         animate();  //...hence animation!
      }
   }
   public void animate()
   {
      
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);

      myAvatar.move();
      myAvatar.draw(myBuffer);
      
      repaint();
   }

}