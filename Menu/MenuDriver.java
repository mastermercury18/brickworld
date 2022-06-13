import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class MenuDriver{
   public static void main(String[] args) throws IOException
   {
      JFrame frame = new JFrame("Not So Super Smash Bros");
      frame.setSize(500, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new GUIPanel());
      frame.setVisible(true); 
   }

}