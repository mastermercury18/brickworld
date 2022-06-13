import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class GUIImageIcon extends JPanel{
   private JButton start;
   private ImagePanel iPanel;
   
   public GUIImageIcon(){
      setLayout(new BorderLayout());
      
      JPanel subnorth = new JPanel();
      subnorth.setLayout(new FlowLayout());
      subnorth.setLayout(new FlowLayout(FlowLayout.CENTER));
      start = new JButton("Start");
      start.addActionListener(new StartListener());
      subnorth.add(start);
      
      add(subnorth, BorderLayout.NORTH);
      
      iPanel = new ImagePanel();
      add(iPanel);
      
   
   }
   private class StartListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         iPanel.begin();
         iPanel.requestFocusInWindow();
      
      }
   }

}