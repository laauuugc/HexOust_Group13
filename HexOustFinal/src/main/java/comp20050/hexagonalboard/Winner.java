/**
 * Dialog window that displays the winner of HexOust game.
 * This class creates a modal dialog that shows the winning player's name along with
 * a colored smiley icon that matches the player's color (red or blue). The winner's
 * name is displayed in the corresponding color to provide visual cohesiveness.
 * The dialog includes:
 * - A label displaying the winner's name in the appropriate color
 * - A smiley icon matching the winner's color (red or blue)
 * - An OK button to dismiss the dialog
 * - Standard dialog behaviors (window close button handling)
 * The dialog appearance is fixed size and non-resizable for consistent presentation.
 *
 * @author Cian Latchford, Federica Fucetola & Laura Gonzalez Calleja
 * @version Final Product
 * @since May 2025
 */
package comp20050.hexagonalboard;

import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Winner extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel winnerMessage;
    private JLabel winnerIcon;

    protected static final Color RED = Color.web("#f4727d");
    protected static final Color BLUE = Color.web("#86b3d3");

    public Winner() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });


        // Call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // Call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0),JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    protected void displayWinner (String PlayerName,Color color){
        ImageIcon icon;
        int width = 100;
        int height = 100;

        if(color.equals(BLUE)){
            icon = new ImageIcon(getClass().getResource("/comp20050/hexagonalboard/blueSmiley.png"));
        }
        else {
            icon = new ImageIcon(getClass().getResource("/comp20050/hexagonalboard/redSmiley.png"));
        }

        Image scaledImage = icon.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        winnerIcon.setIcon(resizedIcon);


        if(color.equals(BLUE))
            winnerMessage.setForeground(java.awt.Color.decode("#86b3d3"));
        else
            winnerMessage.setForeground(java.awt.Color.decode("#f4727d"));
        String winnerSentence = PlayerName + " WINS !!!";
        winnerMessage.setText(winnerSentence);
    }

    public String getWinnerMessage (){return winnerMessage.getText();}

    public String setWinnerMessage (String playerName){ return playerName+" WINS !!!";}

    protected void centerWindow(Dialog dialog) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension rulesDialogSize = dialog.getSize();
        int xRules = (screenSize.width - rulesDialogSize.width)/2;
        int yRules = (screenSize.height - rulesDialogSize.height)/2;
        dialog.setLocation(xRules,yRules);
    }

    public static void main(String[] args) {
        Winner dialog = new Winner();
        dialog.pack();
        dialog.setResizable(false);
        dialog.centerWindow(dialog);
        dialog.setVisible(true);
        System.exit(0);
    }
}