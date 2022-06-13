import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class ImageIconDriver{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Avatar Demo");
      frame.setSize(400, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new GUIImageIcon());
      frame.setVisible(true);
   }

}