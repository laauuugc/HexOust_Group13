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
        buttonOK.setName("OK");

        buttonOK.addActionListener(e -> onOK());


        // Call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // Call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


    }



    private void onOK() {
        // Add your code here
        dispose();
    }

    private void onCancel() {
        // Add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Rules dialog = new Rules();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
