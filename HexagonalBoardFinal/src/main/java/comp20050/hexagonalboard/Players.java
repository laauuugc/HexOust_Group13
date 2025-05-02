/**
 * Dialog window for player setup in HexOust game.
 * Creates a modal dialog that allows players to enter their names
 * before starting the game. The dialog assigns fixed colors to each player:
 * "red" for Player 1 and "blue" for Player 2. Once player information is
 * confirmed through the OK button, the dialog stores this information and
 * makes it available through getter methods.
 * The dialog includes:
 * - Text fields for entering player names
 * - Visual labels for players and their colors
 * - An OK button to confirm selections
 * - Standard dialog behaviors (lose button handling)
 *
 * @author Cian Latchford, Federica Fucetola & Laura González Calleja
 * @version Final Product
 * @since May 2025
 */
package comp20050.hexagonalboard;

import javax.swing.*;
import java.awt.event.*;

public class Players extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField name1;
    private JTextField name2;
    private JLabel player1;
    private JLabel player2;
    private JLabel red;
    private JLabel blue;

    // Variables passed and used in the other classes (the main application class)
    private String player1Name;
    private String player2Name;
    private String player1Color;
    private String player2Color;

    public Players() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        // Call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // Call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(),KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public void onOK() {
        player1Name = getName1();
        player1Color = "red";

        player2Name = getName2();
        player2Color = "blue";

        dispose();
    }

    public String getName1(){
        return name1.getText();
    }

    public String getName2(){
        return name2.getText();
    }

    public String getPlayer1Color(){return player1Color;}
    public String getPlayer2Color(){return player2Color;}


    private void onCancel() {
        dispose();
    }


    public static void main(String[] args) {
        Players dialog = new Players();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}