package comp20050.hexagonalboard;

import java.awt.*;
import java.net.URL;
import java.util.*;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

import javax.swing.*;

public class HelloController {
    private String namePl1 = "Player 1"; // Default name if not set
    private String namePl2 = "Player 2";
    protected boolean playerTurn = false; // false= red turn true= blue turn

    public static final Color RED = Color.web("#f4727d");
    public static final Color BLUE = Color.web("#86b3d3");

    private final Map<Polygon, Color> boardState = new HashMap<>();

    @FXML
    protected ImageView rulesHelpButton;

    //Set Player Names
    public void setPlayerNames(String player1, String player2) {
        this.namePl1 = player1;
        this.namePl2 = player2;
        updateTurnLabel(); // Update UI with correct player turn
    }

    public String getPlayer1Name(){
        return this.namePl1;
    }
    public String getPlayer2Name(){
        return this.namePl2;
    }
    public Boolean getPlayerTurn(){
        return this.playerTurn;
    }
    public Polygon[] getHexagons() {
        return hexagons;
    }

    private void updateTurnLabel() {
            currentPlayer.setText(playerTurn ? namePl2 + "'s turn" : namePl1 + "'s turn");
            currentPlayer.setStyle(playerTurn ? "-fx-text-fill: #86b3d3;" : "-fx-text-fill: #f4727d;");
            currentCircle.setFill(playerTurn ? BLUE : RED);
        //=======================================
        System.out.println("Turn: " + currentPlayer.getText());
    }

    @FXML
    private StackPane stackPane;

    @FXML
    private Group hexGroup;

    @FXML
    private Label currentPlayer;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Circle currentCircle;

    @FXML
    private Polygon[] hexagons= new Polygon[127];

    protected void fillHexagonsArray(){
            hexagons[0] = hex1;
            hexagons[1] = hex2;
            hexagons[2] = hex3;
            hexagons[3] = hex4;
            hexagons[4] = hex5;
            hexagons[5] = hex6;
            hexagons[6] = hex7;
            hexagons[7] = hex8;
            hexagons[8] = hex9;
            hexagons[9] = hex10;
            hexagons[10] = hex11;
            hexagons[11] = hex12;
            hexagons[12] = hex13;
            hexagons[13] = hex14;
            hexagons[14] = hex15;
            hexagons[15] = hex16;
            hexagons[16] = hex17;
            hexagons[17] = hex18;
            hexagons[18] = hex19;

            hexagons[19] = hex110;
            hexagons[20] = hex1101;
            hexagons[21] = hex1102;
            hexagons[22] = hex1103;
            hexagons[23] = hex1104;
            hexagons[24] = hex1105;
            hexagons[25] = hex1106;
            hexagons[26] = hex1107;
            hexagons[27] = hex1108;
            hexagons[28] = hex1109;
            hexagons[29] = hex11010;
            hexagons[30] = hex110101;
            hexagons[31] = hex1101011;
            hexagons[32] = hex1101012;
            hexagons[33] = hex1101013;
            hexagons[34] = hex11091;
            hexagons[35] = hex11051;
            hexagons[36] = hex110511;
            hexagons[37] = hex110512;

            hexagons[38] = hex1105121;
            hexagons[39] = hex11051211;
            hexagons[40] = hex11051212;
            hexagons[41] = hex11010131;
            hexagons[42] = hex11010132;
            hexagons[43] = hex11010133;
            hexagons[44] = hex11010134;
            hexagons[45] = hex11010135;
            hexagons[46] = hex11010136;
            hexagons[47] = hex110510;
            hexagons[48] = hex110512121;
            hexagons[49] = hex1105121211;
            hexagons[50] = hex1105121212;
            hexagons[51] = hex11051212121;
            hexagons[52] = hex11051212122;
            hexagons[53] = hex11051212123;
            hexagons[54] = hex11051212124;
            hexagons[55] = hex110513;
            hexagons[56] = hex110514;

            hexagons[57] = hex11052;
            hexagons[58] = hex11053;
            hexagons[59] = hex11054;
            hexagons[60] = hex11055;
            hexagons[61] = hex11056;
            hexagons[62] = hex11057;
            hexagons[63] = hex110571;
            hexagons[64] = hex1105711;
            hexagons[65] = hex1105712;
            hexagons[66] = hex11057121;
            hexagons[67] = hex110571210;
            hexagons[68] = hex11057122;
            hexagons[69] = hex11057123;
            hexagons[70] = hex11057124;
            hexagons[71] = hex110571241;
            hexagons[72] = hex110571242;
            hexagons[73] = hex110571243;
            hexagons[74] = hex110571244;
            hexagons[75] = hex110571245;

            hexagons[76] = hex11057125;
            hexagons[77] = hex11057126;
            hexagons[78] = hex110571261;
            hexagons[79] = hex110571262;
            hexagons[80] = hex110571263;
            hexagons[81] = hex110571264;
            hexagons[82] = hex110571265;
            hexagons[83] = hex110571266;
            hexagons[84] = hex110571267;
            hexagons[85] = hex11057127;
            hexagons[86] = hex11057128;
            hexagons[87] = hex11057129;
            hexagons[88] = hex1105713;
            hexagons[89] = hex1105714;
            hexagons[90] = hex1105715;
            hexagons[91] = hex1105716;
            hexagons[92] = hex11057161;
            hexagons[93] = hex11057162;

            hexagons[94] = hex11057163;
            hexagons[95] = hex11057164;
            hexagons[96] = hex11057165;
            hexagons[97] = hex110571651;
            hexagons[98] = hex110571652;
            hexagons[99] = hex110571653;
            hexagons[100] = hex110572;
            hexagons[101] = hex110573;
            hexagons[102] = hex110574;
            hexagons[103] = hex1105741;
            hexagons[104] = hex1105742;
            hexagons[105] = hex1105743;
            hexagons[106] = hex1105744;
            hexagons[107] = hex11057441;
            hexagons[108] = hex11057442;
            hexagons[109] = hex11057443;
            hexagons[110] = hex11057444;
            hexagons[111] = hex11058;

            hexagons[112] = hex11059;
            hexagons[113] = hex110911;
            hexagons[114] = hex1109110;
            hexagons[115] = hex1109111;
            hexagons[116] = hex1109112;
            hexagons[117] = hex1109113;
            hexagons[118] = hex1109114;
            hexagons[119] = hex110912;
            hexagons[120] = hex110913;
            hexagons[121] = hex110914;
            hexagons[122] = hex110915;
            hexagons[123] = hex110916;
            hexagons[124] = hex110917;
            hexagons[125] = hex110918;
            hexagons[126] = hex110919;

    }

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

    //checks that the current player has been set to player 1
    private boolean initializeCheck1=false;
    //checks that the window scale is set
    private boolean initializeCheck2=false;
    //checks that the listeners are added
    private boolean initializeCheck3=false;
    //checks that the hexagons have been inserted
    private boolean initializeCheck4=false;

    public boolean getInitializeCheck1() {return initializeCheck1;}
    public boolean getInitializeCheck2() {return initializeCheck2;}
    public boolean getInitializeCheck3() {return initializeCheck3;}
    public boolean getInitializeCheck4() {return initializeCheck4;}

    @FXML
    private void handleRulesHelpButtonClick(MouseEvent event){
        SwingUtilities.invokeLater(() -> {
            Rules dialog = new Rules();
            dialog.pack();
            dialog.setVisible(true);
        });
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        //Image image = new Image(getClass().getResource("/comp20050/hexagonalboard/logo.png"));
        //rulesHelpButton.setImage(image);

        fillHexagonsArray();
        currentPlayer.setText(namePl1 + "'s turn");
        initializeCheck1=true;
        //currentPlayer.setStyle("-fx-text-fill: red;"); // don't really need this line

        // Bind scale based on the smaller of the width or height to keep aspect ratio
        ChangeListener<Number> sizeListener = (observable, oldValue, newValue) -> {
            double width = stackPane.getWidth();
            double height = stackPane.getHeight();

            // Calculate the scale based on the smaller dimension
            double scale = Math.min(width, height) / 1200; // 1200 is your reference size

            // Apply the same scale to both X and Y to maintain aspect ratio
            hexGroup.setScaleX(scale);
            hexGroup.setScaleY(scale);
            initializeCheck2=true;
        };
        // Add listeners to both width and height
        stackPane.widthProperty().addListener(sizeListener);
        stackPane.heightProperty().addListener(sizeListener);
        initializeCheck3=true;

        assertHexagons();
        initializeCheck4=true;

        //=======================================
        System.out.println("Board Initialized");
    }

    private boolean checkAssertHexagons=false;
    public boolean getCheckAssertHexagons() {return checkAssertHexagons;}

    private void assertHexagons() {
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

        checkAssertHexagons=true;
    }

    @FXML
    void getHexID(MouseEvent event) {
        Polygon hexagon = (Polygon) event.getSource();
        if (boardState.containsKey(hexagon)) showErrorPopup(); //already placed a stone

        //determine player's turn
        Color playerColor = playerTurn ? BLUE : RED;
        Color opponentColor = playerTurn ? RED : BLUE;

        List<Polygon> adjacent = getNeighbours(hexagon);
        //check own stones
        boolean connectsToOwn = adjacent.stream().anyMatch(h -> boardState.get(h) == playerColor);
        //check opponent's stones
        boolean connectsToOpponent = adjacent.stream().anyMatch(h -> boardState.get(h) == opponentColor);

        if (connectsToOwn && !connectsToOpponent) {
            //only next to player's own stones not valid
            showErrorPopup();
            return;
        }

        placeStone(hexagon, playerColor);

        if (connectsToOwn && connectsToOpponent)
            isCapturingMove(hexagon, playerColor);
        else {
            playerTurn = !playerTurn; // End turn on non-capturing move
            //=======================================
            System.out.println("Non-Capturing Move");
        }

        updateTurnLabel();
    }

    private void showErrorPopup() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Move");
        alert.setHeaderText("Invalid, choose another hexagon!");
        alert.setContentText("We don't want cheaters in this game...");
        alert.showAndWait();

        //=======================================
        System.out.println("Error Detected");
    }

    private void placeStone(Polygon hexagon, Color color) {
        double centerX = hexagon.getLayoutX();
        double centerY = hexagon.getLayoutY();

        Circle stone = new Circle(centerX, centerY, 20); // Radius 20 for a nice fit
        stone.setFill(color);
        stone.setStroke(Color.BLACK);
        stone.setStrokeWidth(2);

        hexGroup.getChildren().add(stone); // Add the stone to the board
        boardState.put(hexagon, color);

        //=======================================
        System.out.println("Stone placed");
    }

    private void removeStones(Polygon start, Color color) {
        Set<Polygon> toRemove = new HashSet<>();
        searchHexagonToRemove(start, color, toRemove);
        List<Circle> stonesToRemove = new ArrayList<>();

        for (Polygon hex : toRemove) {
            boardState.remove(hex);
            hex.setFill(Color.rgb(216, 176, 238)); //make empty(purple)

            //remove the stone(circle)
            for (var node : hexGroup.getChildren()) {
                if (node instanceof Circle stone) {
                    if (stone.getCenterX() == hex.getLayoutX() && stone.getCenterY() == hex.getLayoutY()) {
                        stonesToRemove.add(stone);
                        break;
                    }
                }
            }
        }
        //remove all captured stones from board
        hexGroup.getChildren().removeAll(stonesToRemove);

        //=======================================
        System.out.println("Stones removed ");
    }

    //returns list of neighbor hexagons
    private List<Polygon> getNeighbours(Polygon hexagon) {
        List<Polygon> neighbors = new ArrayList<>(); //empty list to store neighbors
        double x = hexagon.getLayoutX();
        double y = hexagon.getLayoutY();

        //loop through every hexagon on board checking if it’s neighbor
        for (Polygon neighbor : hexagons) {
            double nx = neighbor.getLayoutX(); //neighbour position
            double ny = neighbor.getLayoutY(); //neighbour position

            if ((x == nx && y + 90 == ny) || (x == nx && y - 90 == ny) || (x + 75 == nx && y - 45 == ny) || (x + 75 == nx && y + 45 == ny) || (x - 75 == nx && y - 45 == ny) || (x - 75 == nx && y + 45 == ny))
                neighbors.add(neighbor);
        }
        return neighbors;
    }

    //counts number connected hexagons of same color
    private int countGroupSize(Polygon start, Color color) {
        Set<Polygon> visited = new HashSet<>(); //keep track of visited hexagons
        return visitNeighbouringHexagons(start, color, visited);
    }

    //explores all hexagons connected to the starting one
    private int visitNeighbouringHexagons(Polygon hexagon, Color color, Set<Polygon> visited) {
        //already visited or not the right color, stop and return 0
        if (visited.contains(hexagon) || boardState.get(hexagon) != color)
            return 0;
        visited.add(hexagon); //mark as visited

        int count = 1; //starts from 1 (hexagon itself is part of group)
        //for every neighbour hexagon, calls dfsCount again to check if connected and same color
        for (Polygon neighbor : getNeighbours(hexagon)) {
            count += visitNeighbouringHexagons(neighbor, color, visited);
        }
        return count;
    }

    private void isCapturingMove(Polygon placedHex, Color playerColor) {
        List<Polygon> opponentGroupsToRemove = new ArrayList<>(); //list store opponent groups to remove
        Color opponentColor = (playerColor == RED) ? BLUE : RED; //get opponent's color

        int newGroupSize = countGroupSize(placedHex, playerColor); //count size new group after placing stone

        //check each neighbor
        for (Polygon neighbor : getNeighbours(placedHex)) {
            if (boardState.get(neighbor) == opponentColor) {
                int opponentGroupSize = countGroupSize(neighbor, opponentColor);
                if (opponentGroupSize < newGroupSize) { //if capturing move
                    //=======================================
                    System.out.println("Is Capturing Move");

                    opponentGroupsToRemove.add(neighbor); //remove opponent's stones
                }
            }
        }

        for (Polygon opponentStone : opponentGroupsToRemove) {
            removeStones(opponentStone, opponentColor);
        }
    }

    private void searchHexagonToRemove(Polygon hexagon, Color color, Set<Polygon> toRemove) {
        if (toRemove.contains(hexagon) || boardState.get(hexagon) != color)
            return;
        toRemove.add(hexagon);

        for (Polygon neighbor : getNeighbours(hexagon)) {
            searchHexagonToRemove(neighbor, color, toRemove);
        }
    }

    private void displayWinnerInterface(String winnerName, Color playerColor) {
        SwingUtilities.invokeLater(() -> {
            Winner dialog = new Winner();
            dialog.pack();
            dialog.centerWindow(dialog);
            dialog.displayWinner(winnerName,playerColor);
            dialog.setVisible(true);
        });
    }
}