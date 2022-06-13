import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//  w ww.  j av  a2  s .  co m
public class JOptionPaneTester {
    public static void main(String[] args) {

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("GAME OVER!"));

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Not So Super Smash Bros", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return;
        }

    }
}