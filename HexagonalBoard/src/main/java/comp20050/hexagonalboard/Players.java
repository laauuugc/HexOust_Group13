package comp20050.hexagonalboard;

import javax.swing.*;
import java.awt.event.*;

public class Players extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField name1;
    private JTextField name2;
    private JComboBox color2;
    private JComboBox color1;
    private JLabel player1;
    private JLabel player2;

    private String name;
    private String color;

    public Players() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        color1.setModel(new DefaultComboBoxModel(new String[] {"Red", "Blue"}));
        color2.setModel(new DefaultComboBoxModel(new String[] {"Blue", "Red"}));

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

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


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public static void main(String[] args) {
        Players dialog = new Players();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
