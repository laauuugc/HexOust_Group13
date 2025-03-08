package comp20050.hexagonalboard;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //run Swing dialogs on the Swing thread
        SwingUtilities.invokeLater(() -> {
            //launch Rules dialog
            Rules rulesDialog = new Rules();
            rulesDialog.pack();
            rulesDialog.setVisible(true);

            //after Rules dialog closes launch JavaFX app (that will start the Players info before starting the board)
            Platform.runLater(() -> {
                try {
                    //load the JavaFX scene
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    stage.setTitle("HexOust Board");
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
    }


    public static void main(String[] args) {
        launch();
    }
}