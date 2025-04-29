/**
 * Dialog window for displaying game rules in the HexOust game.
 * This class creates a modal dialog that presents the rules of the HexOust game
 * to players. The dialog contains a text pane that displays the rule content
 * and an OK button to dismiss the dialog when the player has finished reading.
 * The dialog includes standard dialog behaviors such as:
 * - Proper window close button handling.
 * - Modal display to ensure players acknowledge the rules.
 * The rules content is displayed in a JTextPane component that can be populated
 * with formatted text explaining game mechanics and objectives.
 *
 * @author Cian Latchford, Federica Fucetola & Laura González Calleja
 * @version Final Product
 * @since May 2025
 */
package comp20050.hexagonalboard;

import javax.swing.*;
import java.awt.event.*;

public class Rules extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextPane rules;
    private javax.swing.JPanel JPanel;

    public Rules() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Rules dialog = new Rules();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
