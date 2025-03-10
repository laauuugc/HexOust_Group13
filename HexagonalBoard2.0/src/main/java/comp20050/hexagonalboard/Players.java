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

    // variables to pass and use in the other classes
    private String player1Name;
    private String player2Name;
    private String player1Color;
    private String player2Color;

    public Players() {
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

    private void centerFrame(Players players) {
    }

    public void onOK() {
        player1Name= getname1();
        player1Color= "red";

        player2Name= getname2();
        player2Color= "blue";

        dispose();
    }

    public String getname1(){
        return name1.getText();
    }

    public String getname2(){
        return name2.getText();
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    public static void main(String[] args) {
        Players dialog = new Players();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
