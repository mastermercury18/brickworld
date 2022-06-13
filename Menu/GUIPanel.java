import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class GUIPanel extends JPanel{

   private FlowerPanel pPanel;
   private JButton start;
  // private ImagePanel iPanel;
   
      
   public GUIPanel(){
      setLayout(new BorderLayout());

      JPanel south = new JPanel();
      south.setLayout(new FlowLayout(FlowLayout.CENTER));

      JPanel north = new JPanel();
      north.setLayout(new FlowLayout(FlowLayout.CENTER));
      
      JButton startMenuButton = new JButton("Start Menu");
      startMenuButton.addActionListener(new MenuButtonListener());
      south.add(startMenuButton);

      start = new JButton("Start");
      start.addActionListener(new GUIPanel.StartListener());
      north.add(start);
      
      add(south, BorderLayout.SOUTH);
      add(north, BorderLayout.NORTH);
      
      pPanel = new FlowerPanel();
      add(pPanel);
      //iPanel = new ImagePanel();
      //add(iPanel);
      
   }
   //when the Start Menu button is pressed, it opens a JOptionPane
   private class MenuButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //JComboBoxes (drop downs) for colors
         String[] characters = {"Kirby","Link","Pikachu","Pacman"};
         JComboBox player_one_list = new JComboBox(characters);
         player_one_list.setSelectedIndex(0);
         
         String[] characters_two ={"Kirby","Link","Pikachu","Pacman"};
         JComboBox player_two_list = new JComboBox(characters_two);
         player_two_list.setSelectedIndex(0);
         
         String[] maps ={"Battlefield","EarthBound","Final Destination","Wii"};
         JComboBox map_list = new JComboBox(maps);
         map_list.setSelectedIndex(0);
      
      
         //Panel that will be displayed in the JOptionPane
         JPanel myPanel = new JPanel();
         myPanel.setLayout(new GridLayout(3,2));
         myPanel.add(new JLabel("Player 1"));
         myPanel.add(player_one_list);
         myPanel.add(new JLabel("Player 2"));
         myPanel.add(player_two_list);
         myPanel.add(new JLabel("Map"));
         myPanel.add(map_list);
      
      
      //Creates a JOptionPane with  "OK" and "Cancel" options
      //JOptionPane will automatically close itself when either "OK" or "Cancel" is pressed
         int result = JOptionPane.showConfirmDialog(null, myPanel,"Start Menu", JOptionPane.OK_CANCEL_OPTION);
        
        //what happens when "OK" is clicked in the JOptionPane
         if (result == JOptionPane.OK_OPTION) {
            
            //gets color options from the two JComboBoxes
            String c_one = (String)player_one_list.getSelectedItem();
            String c_two = (String)player_two_list.getSelectedItem();
            String map = (String)map_list.getSelectedItem();
            if(c_one.equals("Kirby")){
               //pPanel.changeBackground(new Color(142,125,190));
              //iPanel
               pPanel.changeName("kirby");
            }
            else if(c_one.equals("Link")){
               //pPanel.setFlowerColor(new Color(216,140,154));
               pPanel.changeName("link");
            }
            else if(c_one.equals("Pikachu")){
               //pPanel.setFlowerColor(new Color(133,173,205));
               pPanel.changeName("pikachu");
            }
            else if(c_one.equals("Pacman")){
               //pPanel.setFlowerColor(new Color(40,123,205));
               pPanel.changeName("pacman");
            }
            
            if(c_two.equals("Kirby")){
               pPanel.changePlayer2Name("kirby");
            }
            else if(c_two.equals("Link")){
               pPanel.changePlayer2Name("link");
            }
            else if(c_two.equals("Pikachu")){
               pPanel.changePlayer2Name("pikachu");
            }
            else if(c_two.equals("Pacman")){
               pPanel.changePlayer2Name("pacman");
            }
            
            if(map.equals("Battlefield")){
               pPanel.changeBackground("Battlefield");
            }
            else if(map.equals("EarthBound")){
               pPanel.changeBackground("EarthBound");
            }
            else if(map.equals("Final Destination")){
               pPanel.changeBackground("Final Destination");
            }
            else if(map.equals("Wii")){
               pPanel.changeBackground("Wii");
            
            }
            pPanel.update();
         
         //if "Cancel" is clicked, nothing changes on the FlowerPanel

         }
      }
   }

   private class StartListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         pPanel.begin();
         pPanel.requestFocusInWindow();

      }
   }
}