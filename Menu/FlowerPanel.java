import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class FlowerPanel extends JPanel {
   public static final int FRAME = 400;
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Color background = Color.GRAY;
   private ImageIcon i;
   private String mapname;
   private String avatarname;
   private String avatar2name;
   private Avatar character;
   private Avatar character2;
   private Avatar bird;
   private PewPew nerf;
   private PewPew nerf2;
   private Timer t;
   private boolean space;
   private boolean e_key;
   private boolean has_won;
   public int ko;
   public int ko2;

   public FlowerPanel(){
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(background);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      
      myBuffer.setColor(Color.BLACK);
      myBuffer.drawString("Press Start Menu",10,100); 
      //ImageIcon me = new ImageIcon("maps/kirby.png");

      //kirby = new Avatar(100, 140, me);

      addKeyListener(new FlowerPanel.Key());
      setFocusable(true);
      t = new Timer(5, new FlowerPanel.AnimationListener());

      nerf = new PewPew(0, -9);
      nerf.resetSquare(0,-9);

      nerf2 = new PewPew(0, -9);
      nerf2.resetSquare(0,-9);

      space = false;
      e_key = false;
      has_won = false;

   }

   public void changeBackground(String map){
      mapname = map;
   }

   public void changeName(String name){
      avatarname = name;
   }

   public void changePlayer2Name(String name){
      avatar2name = name;
   }

   public void setFlowerColor(Color c){
      //myFlower.setPetalColor(c);
   }

   public boolean getHasWon(){
      return has_won;
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
            character.setdy(2);

         }
         else if(e.getKeyCode()==KeyEvent.VK_UP){
            character.setdy(-2);

         }
         else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            character.setdx(-2);

         }
         else if(e.getKeyCode()==KeyEvent.VK_RIGHT ){
            character.setdx(2);

         }
         else if(e.getKeyCode()==KeyEvent.VK_SPACE && !space && nerf.getMyX() > 0) {
            //animate();
            nerf.resetSquare(character.getX() + 4, character.getY() + 30);
            space = true;
         }


         // character2 key codes
         if(e.getKeyCode() == KeyEvent.VK_S ){
            character2.setdy(2);

         }
         else if(e.getKeyCode()==KeyEvent.VK_W){
            character2.setdy(-2);

         }
         else if(e.getKeyCode()==KeyEvent.VK_A){
            character2.setdx(-2);

         }
         else if(e.getKeyCode()==KeyEvent.VK_D){
            character2.setdx(2);

         }
         else if(e.getKeyCode()==KeyEvent.VK_E && !e_key && nerf2.getMyX() > 0) {
            //animate();
            nerf2.resetSquare(character2.getX() + 4, character2.getY() + 30);
            e_key = true;
         }
      }
      public void keyReleased(KeyEvent e)  //Note keyReleased is called when... a key is released!
      {
         if(e.getKeyCode() == KeyEvent.VK_DOWN){
            character.setdy(0);

         }
         else if(e.getKeyCode()==KeyEvent.VK_UP){
            character.setdy(0);

         }
         else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            character.setdx(0);

         }
         else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            character.setdx(0);
         }
         else if(e.getKeyCode()==KeyEvent.VK_SPACE){
            space = false;
         }
         // character2 released
         if(e.getKeyCode() == KeyEvent.VK_S ){
            character2.setdy(0);

         }
         else if(e.getKeyCode()==KeyEvent.VK_W){
            character2.setdy(0);

         }
         else if(e.getKeyCode()==KeyEvent.VK_A){
            character2.setdx(0);

         }
         else if(e.getKeyCode()==KeyEvent.VK_D){
            character2.setdx(0);

         }
         else if(e.getKeyCode()==KeyEvent.VK_E){
            e_key = false;
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
      //repaint();
      //myBuffer.setColor(background);
      //myBuffer.fillRect(0,0,FRAME,FRAME);

      String path = "menu/" + "maps/" + mapname + ".jpeg";
      i = new ImageIcon(path);
      myBuffer.drawImage(i.getImage(),0,0,400,400,null);

      ImageIcon me2 = new ImageIcon("menu/maps/bird.png");
      for (int x = 20; x < 380; x+=60){
         bird = new Avatar(x, 10, me2);
         bird.draw(myBuffer);
      }

      character.move();
      character.draw(myBuffer);
      character2.move();
      character2.draw(myBuffer);


      nerf.draw(myBuffer);
      nerf.move();

      nerf2.draw(myBuffer);
      nerf2.move();

      if(character2.collision(nerf)){
         character2.setX(-100);
         character2.setY(-100);
         character2.draw(myBuffer);
         has_won = true;
         JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("GAME OVER!"));

        int result = JOptionPane.showConfirmDialog(null, myPanel,"Not So Super Smash Bros", JOptionPane.OK_CANCEL_OPTION);
         //if (result == JOptionPane.OK_OPTION) {
           // return;
      }
      if(character.collision(nerf2)){
         character.setX(-100);
         character.setY(-100);
         character.draw(myBuffer);
         has_won = true;
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("GAME OVER!"));

         int result = JOptionPane.showConfirmDialog(null, myPanel,"Not So Super Smash Bros", JOptionPane.OK_CANCEL_OPTION);
         //if (result == JOptionPane.OK_OPTION) {
           // return;
      }

      repaint();

   }


   public void update(){
     // repaint();
      String path = "menu/" + "maps/" + mapname + ".jpeg";
      i = new ImageIcon(path);
      myBuffer.drawImage(i.getImage(),0,0,400,400,null);
      ImageIcon me = new ImageIcon("menu/" + "maps/" + avatarname + ".png");
      ImageIcon me3 = new ImageIcon("menu/" + "maps/" + avatar2name + ".png");
      character = new Avatar(100, 140, me);
      character.draw(myBuffer);
      character2 = new Avatar(300, 140, me3);
      character2.draw(myBuffer);
      ImageIcon me2 = new ImageIcon("menu/maps/bird.png");
      for (int x = 20; x < 380; x+=60) {
         for (int y = 20; y < 380; y += 60){
            bird = new Avatar(x, y, me2);
            bird.draw(myBuffer);
         }
      }
      //animate();
      repaint();
   }

}