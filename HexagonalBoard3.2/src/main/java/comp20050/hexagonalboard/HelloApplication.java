package comp20050.hexagonalboard;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // Run Swing dialogs on the Swing thread
        SwingUtilities.invokeLater(() -> {
            // Launch Rules dialog
            Rules rulesDialog = new Rules();
            rulesDialog.setResizable(false);
            centerRulesWindow(rulesDialog);
            rulesDialog.pack();
            rulesDialog.setVisible(true);

            // After Rules dialog closes, launch Players dialog
            Players playersDialog = new Players();
            playersDialog.setResizable(false);
            centerPlayersWindow(playersDialog);
            playersDialog.pack();
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

            //after Rules dialog closes launch JavaFX app (that will start the Players info before starting the board)
            Platform.runLater(() -> {
                try {
                    //load the JavaFX scene
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    stage.setTitle("HexOust Board");
                    stage.setScene(scene);
                    stage.setWidth(850);
                    stage.setHeight(750);
                    stage.show();

                    // Pass player names to HelloController
                    HelloController controller = fxmlLoader.getController();
                    controller.setPlayerNames(finalName1, finalName2);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
    }

    private void centerRulesWindow(Rules rulesDialog) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension rulesDialogSize = rulesDialog.getSize();
        int xRules = (screenSize.width - rulesDialogSize.width)/3;
        int yRules = rulesDialogSize.height;
        rulesDialog.setLocation(xRules, yRules);
    }

    private void centerPlayersWindow(Players playersDialog) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension playersDialogSize = playersDialog.getSize();
        int xPlayer = (screenSize.width - playersDialogSize.width) / 3;
        int yPlayer = (screenSize.height - playersDialogSize.height) / 3;
        playersDialog.setLocation(xPlayer, yPlayer);
    }

    public static void main(String[] args) {
        launch();
    }
}