/**
 * Main application class for HexOust Board game.
 * This class manages the start sequence of the game, including:
 *   Displaying the splash screen with the game logo
 *   Showing the rules dialog to inform players about game mechanics
 *   Collecting player names through a player information dialog
 *   Launching the main game board interface
 * The application uses a combination of Swing components for initial dialogs
 * and JavaFX for the main game interface. Thread management ensures proper
 * synchronization between Swing and JavaFX components.
 * @author Cian Latchford, Federica Fucetola & Laura González Calleja
 * @version Final Product
 * @since May 2025
 */
package comp20050.hexagonalboard;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // Run Swing dialogs on the Swing thread
        SwingUtilities.invokeLater(() -> {
            // Show logo screen first
            displayLogo(() -> {
                // Launch Rules dialog
                Rules rulesDialog = new Rules();
                rulesDialog.setResizable(false);
                rulesDialog.pack();
                centerWindow(rulesDialog);
                rulesDialog.setVisible(true);

                // After Rules dialog closes, launch Players dialog
                Players playersDialog = new Players();
                playersDialog.setResizable(false);
                playersDialog.pack();
                centerWindow(playersDialog);
                playersDialog.setVisible(true);

                // Retrieve player names
                String name1 = playersDialog.getName1().trim();
                String name2 = playersDialog.getName2().trim();

                // Ensure default names if fields are empty
                if (name1.isEmpty()) name1 = "Player 1";
                if (name2.isEmpty()) name2 = "Player 2";

                // Final variables for use inside the Platform.runLater() lambda
                String finalName1 = name1;
                String finalName2 = name2;

                // After Rules dialog closes launch JavaFX app (that will start the Players info before starting the board)
                Platform.runLater(() -> {
                    try {
                        // Load the JavaFX scene
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        stage.setTitle("HexOust Board");
                        stage.setScene(scene);
                        stage.setWidth(850);
                        stage.setHeight(750);
                        stage.show();

                        // Pass player names to HelloController
                        HelloController controller = fxmlLoader.getController();
                        controller.setPlayerNames(finalName1,finalName2);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            });
        });
    }

    /**
     * Displays a logo screen in the center of the screen,
     * then runs the provided callback after 4 seconds.
     */
    private void displayLogo(Runnable afterSplash) {
        JDialog splash = new JDialog();
        splash.setUndecorated(true);

        ImageIcon logoIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/comp20050/hexagonalboard/logo.png")));

        // Resize image
        int width = 700;
        int height = 700;
        Image scaledImage = logoIcon.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        JLabel logoLabel = new JLabel(resizedIcon);
        splash.getContentPane().add(logoLabel);

        splash.setSize(width,height);
        splash.setLocationRelativeTo(null); // Center on screen
        splash.setVisible(true);

        // Create a new thread to wait and then display
        new Thread(() -> {
            try {
                Thread.sleep(4000); //  Wait for 4 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SwingUtilities.invokeLater(() -> {
                splash.dispose(); // Close splash
                afterSplash.run(); // Continue
            });
        }).start();
    }

    private void centerWindow(Dialog dialog) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension rulesDialogSize = dialog.getSize();
        int xRules = (screenSize.width - rulesDialogSize.width)/2;
        int yRules = (screenSize.height - rulesDialogSize.height)/2;
        dialog.setLocation(xRules,yRules);
    }


    public static void main(String[] args) {
        launch();
    }
}