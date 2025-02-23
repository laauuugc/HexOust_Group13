package comp20050.hexagonalboard;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;

import static javafx.scene.paint.Color.BLACK;

public class HelloController {

    @FXML
    private StackPane stackPane;

    @FXML
    private Group hexGroup;

    @FXML
    private Label currentPlayer;

    private int numClicks = 0;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Polygon hex1;

    @FXML
    private Polygon hex10;

    @FXML
    private Polygon hex11;

    @FXML
    private Polygon hex110;

    @FXML
    private Polygon hex1101;

    @FXML
    private Polygon hex11010;

    @FXML
    private Polygon hex110101;

    @FXML
    private Polygon hex1101011;

    @FXML
    private Polygon hex1101012;

    @FXML
    private Polygon hex1101013;

    @FXML
    private Polygon hex11010131;

    @FXML
    private Polygon hex11010132;

    @FXML
    private Polygon hex11010133;

    @FXML
    private Polygon hex11010134;

    @FXML
    private Polygon hex11010135;

    @FXML
    private Polygon hex11010136;

    @FXML
    private Polygon hex1102;

    @FXML
    private Polygon hex1103;

    @FXML
    private Polygon hex1104;

    @FXML
    private Polygon hex1105;

    @FXML
    private Polygon hex11051;

    @FXML
    private Polygon hex110510;

    @FXML
    private Polygon hex110511;

    @FXML
    private Polygon hex110512;

    @FXML
    private Polygon hex1105121;

    @FXML
    private Polygon hex11051211;

    @FXML
    private Polygon hex11051212;

    @FXML
    private Polygon hex110512121;

    @FXML
    private Polygon hex1105121211;

    @FXML
    private Polygon hex1105121212;

    @FXML
    private Polygon hex11051212121;

    @FXML
    private Polygon hex11051212122;

    @FXML
    private Polygon hex11051212123;

    @FXML
    private Polygon hex11051212124;

    @FXML
    private Polygon hex110513;

    @FXML
    private Polygon hex110514;

    @FXML
    private Polygon hex11052;

    @FXML
    private Polygon hex11053;

    @FXML
    private Polygon hex11054;

    @FXML
    private Polygon hex11055;

    @FXML
    private Polygon hex11056;

    @FXML
    private Polygon hex11057;

    @FXML
    private Polygon hex110571;

    @FXML
    private Polygon hex1105711;

    @FXML
    private Polygon hex1105712;

    @FXML
    private Polygon hex11057121;

    @FXML
    private Polygon hex110571210;

    @FXML
    private Polygon hex11057122;

    @FXML
    private Polygon hex11057123;

    @FXML
    private Polygon hex11057124;

    @FXML
    private Polygon hex110571241;

    @FXML
    private Polygon hex110571242;

    @FXML
    private Polygon hex110571243;

    @FXML
    private Polygon hex110571244;

    @FXML
    private Polygon hex110571245;

    @FXML
    private Polygon hex11057125;

    @FXML
    private Polygon hex11057126;

    @FXML
    private Polygon hex110571261;

    @FXML
    private Polygon hex110571262;

    @FXML
    private Polygon hex110571263;

    @FXML
    private Polygon hex110571264;

    @FXML
    private Polygon hex110571265;

    @FXML
    private Polygon hex110571266;

    @FXML
    private Polygon hex110571267;

    @FXML
    private Polygon hex11057127;

    @FXML
    private Polygon hex11057128;

    @FXML
    private Polygon hex11057129;

    @FXML
    private Polygon hex1105713;

    @FXML
    private Polygon hex1105714;

    @FXML
    private Polygon hex1105715;

    @FXML
    private Polygon hex1105716;

    @FXML
    private Polygon hex11057161;

    @FXML
    private Polygon hex11057162;

    @FXML
    private Polygon hex11057163;

    @FXML
    private Polygon hex11057164;

    @FXML
    private Polygon hex11057165;

    @FXML
    private Polygon hex110571651;

    @FXML
    private Polygon hex110571652;

    @FXML
    private Polygon hex110571653;

    @FXML
    private Polygon hex110572;

    @FXML
    private Polygon hex110573;

    @FXML
    private Polygon hex110574;

    @FXML
    private Polygon hex1105741;

    @FXML
    private Polygon hex1105742;

    @FXML
    private Polygon hex1105743;

    @FXML
    private Polygon hex1105744;

    @FXML
    private Polygon hex11057441;

    @FXML
    private Polygon hex11057442;

    @FXML
    private Polygon hex11057443;

    @FXML
    private Polygon hex11057444;

    @FXML
    private Polygon hex11058;

    @FXML
    private Polygon hex11059;

    @FXML
    private Polygon hex1106;

    @FXML
    private Polygon hex1107;

    @FXML
    private Polygon hex1108;

    @FXML
    private Polygon hex1109;

    @FXML
    private Polygon hex11091;

    @FXML
    private Polygon hex110911;

    @FXML
    private Polygon hex1109110;

    @FXML
    private Polygon hex1109111;

    @FXML
    private Polygon hex1109112;

    @FXML
    private Polygon hex1109113;

    @FXML
    private Polygon hex1109114;

    @FXML
    private Polygon hex110912;

    @FXML
    private Polygon hex110913;

    @FXML
    private Polygon hex110914;

    @FXML
    private Polygon hex110915;

    @FXML
    private Polygon hex110916;

    @FXML
    private Polygon hex110917;

    @FXML
    private Polygon hex110918;

    @FXML
    private Polygon hex110919;

    @FXML
    private Polygon hex12;

    @FXML
    private Polygon hex13;

    @FXML
    private Polygon hex14;

    @FXML
    private Polygon hex15;

    @FXML
    private Polygon hex16;

    @FXML
    private Polygon hex17;

    @FXML
    private Polygon hex18;

    @FXML
    private Polygon hex19;

    @FXML
    private Polygon hex2;

    @FXML
    private Polygon hex3;

    @FXML
    private Polygon hex4;

    @FXML
    private Polygon hex5;

    @FXML
    private Polygon hex6;

    @FXML
    private Polygon hex7;

    @FXML
    private Polygon hex8;

    @FXML
    private Polygon hex9;

    @FXML
    void getHexID(MouseEvent event) {
        Polygon hexagon = (Polygon) event.getSource();
        hexagon.setFill(BLACK);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

        // Bind scale based on the smaller of the width or height to keep aspect ratio
        ChangeListener<Number> sizeListener = (observable, oldValue, newValue) -> {
            double width = stackPane.getWidth();
            double height = stackPane.getHeight();

            // Calculate the scale based on the smaller dimension
            double scale = Math.min(width, height) / 1200; // 1200 is your reference size

            // Apply the same scale to both X and Y to maintain aspect ratio
            hexGroup.setScaleX(scale);
            hexGroup.setScaleY(scale);
        };

        // Set initial player turn
        currentPlayer.setText("PLAYER 1 NAME's turn");
        currentPlayer.setStyle("-fx-text-fill: red;");

        // Add listeners to both width and height
        stackPane.widthProperty().addListener(sizeListener);
        stackPane.heightProperty().addListener(sizeListener);

        assert hex1 != null : "fx:id=\"hex1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex10 != null : "fx:id=\"hex10\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11 != null : "fx:id=\"hex11\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex12 != null : "fx:id=\"hex12\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex13 != null : "fx:id=\"hex13\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex14 != null : "fx:id=\"hex14\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex15 != null : "fx:id=\"hex15\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex16 != null : "fx:id=\"hex16\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex17 != null : "fx:id=\"hex17\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex18 != null : "fx:id=\"hex18\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex19 != null : "fx:id=\"hex19\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex2 != null : "fx:id=\"hex2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex3 != null : "fx:id=\"hex3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex4 != null : "fx:id=\"hex4\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex5 != null : "fx:id=\"hex5\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex6 != null : "fx:id=\"hex6\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex7 != null : "fx:id=\"hex7\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex8 != null : "fx:id=\"hex8\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex9 != null : "fx:id=\"hex9\" was not injected: check your FXML file 'hello-view.fxml'.";

        assert hex110 != null : "fx:id=\"hex1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1101 != null : "fx:id=\"hex10\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1102 != null : "fx:id=\"hex11\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1103 != null : "fx:id=\"hex12\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1104 != null : "fx:id=\"hex13\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105 != null : "fx:id=\"hex14\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1106 != null : "fx:id=\"hex15\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1107 != null : "fx:id=\"hex16\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1108 != null : "fx:id=\"hex17\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1109 != null : "fx:id=\"hex18\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11010 != null : "fx:id=\"hex19\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110101 != null : "fx:id=\"hex2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1101011 != null : "fx:id=\"hex3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1101012 != null : "fx:id=\"hex4\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1101013 != null : "fx:id=\"hex5\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11091 != null : "fx:id=\"hex6\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11051 != null : "fx:id=\"hex7\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110511 != null : "fx:id=\"hex8\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110512 != null : "fx:id=\"hex9\" was not injected: check your FXML file 'hello-view.fxml'.";

        assert hex1105121 != null : "fx:id=\"hex1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11051211 != null : "fx:id=\"hex10\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11051212 != null : "fx:id=\"hex11\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11010131 != null : "fx:id=\"hex12\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11010132 != null : "fx:id=\"hex13\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11010133 != null : "fx:id=\"hex14\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11010134 != null : "fx:id=\"hex15\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11010135 != null : "fx:id=\"hex16\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11010136 != null : "fx:id=\"hex17\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110510 != null : "fx:id=\"hex18\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110512121 != null : "fx:id=\"hex19\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105121211 != null : "fx:id=\"hex2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105121212 != null : "fx:id=\"hex3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11051212121 != null : "fx:id=\"hex4\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11051212122 != null : "fx:id=\"hex5\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11051212123 != null : "fx:id=\"hex6\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11051212124 != null : "fx:id=\"hex7\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110513 != null : "fx:id=\"hex8\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110514 != null : "fx:id=\"hex9\" was not injected: check your FXML file 'hello-view.fxml'.";

        assert hex11052 != null : "fx:id=\"hex1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11053 != null : "fx:id=\"hex10\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11054 != null : "fx:id=\"hex11\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11055 != null : "fx:id=\"hex12\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11056 != null : "fx:id=\"hex13\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057 != null : "fx:id=\"hex14\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571 != null : "fx:id=\"hex15\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105711 != null : "fx:id=\"hex16\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105712 != null : "fx:id=\"hex17\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057121 != null : "fx:id=\"hex18\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571210 != null : "fx:id=\"hex19\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057122 != null : "fx:id=\"hex2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057123 != null : "fx:id=\"hex3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057124 != null : "fx:id=\"hex4\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571241 != null : "fx:id=\"hex5\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571242 != null : "fx:id=\"hex6\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571243 != null : "fx:id=\"hex7\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571244 != null : "fx:id=\"hex8\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571245 != null : "fx:id=\"hex9\" was not injected: check your FXML file 'hello-view.fxml'.";

        assert hex11057125 != null : "fx:id=\"hex10\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057126 != null : "fx:id=\"hex11\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571261 != null : "fx:id=\"hex12\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571262 != null : "fx:id=\"hex13\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571263 != null : "fx:id=\"hex14\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571264 != null : "fx:id=\"hex15\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571265 != null : "fx:id=\"hex16\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571266 != null : "fx:id=\"hex17\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571267 != null : "fx:id=\"hex18\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057127 != null : "fx:id=\"hex19\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057128 != null : "fx:id=\"hex2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057129 != null : "fx:id=\"hex3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105713 != null : "fx:id=\"hex4\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105714 != null : "fx:id=\"hex5\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105715 != null : "fx:id=\"hex6\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105716 != null : "fx:id=\"hex7\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057161 != null : "fx:id=\"hex8\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057162 != null : "fx:id=\"hex9\" was not injected: check your FXML file 'hello-view.fxml'.";

        assert hex11057163 != null : "fx:id=\"hex10\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057164 != null : "fx:id=\"hex11\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057165 != null : "fx:id=\"hex12\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571651 != null : "fx:id=\"hex13\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571652 != null : "fx:id=\"hex14\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110571653 != null : "fx:id=\"hex15\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110572 != null : "fx:id=\"hex16\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110573 != null : "fx:id=\"hex17\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110574 != null : "fx:id=\"hex18\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105741 != null : "fx:id=\"hex19\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105742 != null : "fx:id=\"hex2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105743 != null : "fx:id=\"hex3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1105744 != null : "fx:id=\"hex4\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057441 != null : "fx:id=\"hex5\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057442 != null : "fx:id=\"hex6\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057443 != null : "fx:id=\"hex7\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11057444 != null : "fx:id=\"hex8\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex11058 != null : "fx:id=\"hex9\" was not injected: check your FXML file 'hello-view.fxml'.";

        assert hex11059 != null : "fx:id=\"hex18\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110911 != null : "fx:id=\"hex19\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1109110 != null : "fx:id=\"hex2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1109111 != null : "fx:id=\"hex3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1109112 != null : "fx:id=\"hex4\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1109113 != null : "fx:id=\"hex5\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex1109114 != null : "fx:id=\"hex6\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110912 != null : "fx:id=\"hex7\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110913 != null : "fx:id=\"hex8\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110914 != null : "fx:id=\"hex9\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110915 != null : "fx:id=\"hex5\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110916 != null : "fx:id=\"hex6\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110917 != null : "fx:id=\"hex7\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110918 != null : "fx:id=\"hex8\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert hex110919 != null : "fx:id=\"hex9\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

    // Method for the Hello Button click to switch player turns
    @FXML
    protected void onHelloButtonClick() {
        if (numClicks % 2 == 0) {
            currentPlayer.setText("PLAYER 2 NAME's turn");
            currentPlayer.setStyle("-fx-text-fill: blue;");
        } else {
            currentPlayer.setText("PLAYER 1 NAME's turn");
            currentPlayer.setStyle("-fx-text-fill: red;");
        }
        numClicks++;
    }

}
