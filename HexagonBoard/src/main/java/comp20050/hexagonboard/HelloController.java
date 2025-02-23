package comp20050.hexagonboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label currentPlayer;

    private int numClicks=0;

    //change to cmouse click when combining with hexboard
    @FXML
    protected void onHelloButtonClick() {
        if(numClicks%2==0) {
            currentPlayer.setText("[PLAYER 1 NAME]'s turn");
            currentPlayer.setStyle("-fx-text-fill: red;");
        }else{
            currentPlayer.setText("[PLAYER 2 NAME]'s turn");
            currentPlayer.setStyle("-fx-text-fill: blue;");
        }
        numClicks++;
    }
}