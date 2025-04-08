package comp20050.hexagonalboard;

import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Winner extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel winnerMessage;
    private JLabel winnerIcon;

    public static final Color RED = Color.web("#f4727d");
    public static final Color BLUE = Color.web("#86b3d3");

    public Winner() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    private void displayWinner (String PlayerName,  Color color){
        ImageIcon icon;
        int width = 100;
        int height = 100;

        if(color.equals(BLUE)){
            icon = new ImageIcon(getClass().getResource("/comp20050/hexagonalboard/blueSmiley.png"));
        }
        else {
            icon = new ImageIcon(getClass().getResource("/comp20050/hexagonalboard/redSmiley.png"));
        }

        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        winnerIcon.setIcon(resizedIcon);


        if(color.equals(BLUE))
            winnerMessage.setForeground(java.awt.Color.decode("#86b3d3"));
        else
            winnerMessage.setForeground(java.awt.Color.decode("#f4727d"));
        String winnerSentence = PlayerName + " WINS !!!";
        winnerMessage.setText(winnerSentence);
    }

    private void centerWindow(Dialog dialog) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension rulesDialogSize = dialog.getSize();
        int xRules = (screenSize.width - rulesDialogSize.width)/2;
        int yRules = (screenSize.height - rulesDialogSize.height)/2;
        dialog.setLocation(xRules, yRules);
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
