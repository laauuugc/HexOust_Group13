package comp20050.hexagonalboard;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    private HelloController tester;

    private static boolean javafxInitialized = false;

    @BeforeAll
    public static void initJavaFX() throws Exception {
        if (!javafxInitialized) {
            javafxInitialized = true;
            Platform.startup(() -> {
                // No-op lambda just to init toolkit
            });
            Platform.setImplicitExit(false);
        }
    }

    @BeforeEach
    public void setUp() throws Exception {
        tester = new HelloController();

        injectField("stackPane", new StackPane());
        injectField("hexGroup", new Group());
        injectField("currentPlayer", new Label());
        injectField("currentCircle", new Circle());
        //injectField("resources", HelloApplication.class.getResource("hello-view.fxml"));

        Polygon[] hexes = new Polygon[127];
        for (int i = 0; i < hexes.length; i++) {
            Polygon hex = new Polygon();
            hex.setLayoutX(100 + i);
            hex.setLayoutY(100 + i);
            hexes[i] = hex;
        }
        injectField("hexagons", hexes);
    }

    void injectField(String name, Object value) {
        try {
            Field field = HelloController.class.getDeclaredField(name);
            field.setAccessible(true);
            field.set(tester, value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to inject field: " + name, e);
        }
    }

    Object getPrivateField(String name) {
        try {
            Field field = HelloController.class.getDeclaredField(name);
            field.setAccessible(true);
            return field.get(tester);
        } catch (Exception e) {
            throw new RuntimeException("Failed to access field: " + name, e);
        }
    }

    @Test
    void testPlayerNames() {
        tester.setPlayerNames("Cian", "Federica");
        assertEquals("Cian", tester.getPlayer1Name());
        assertEquals("Federica", tester.getPlayer2Name());
    }

    @Test
    void getPlayerTurn() {
        //false is red player, and they should be initialized to start first
        assertEquals(false, tester.getPlayerTurn());
    }

    @Test
    void testHexagonsFilled() {
        //checks that the array of hexagons for the board is completely full
        assertEquals(127, tester.getHexagons().length);
    }

    @Test
    void testInitializeSetsFlags() {
        assertFalse(tester.getInitializeCheck1());
        assertFalse(tester.getInitializeCheck2());
        assertFalse(tester.getInitializeCheck3());
        assertFalse(tester.getInitializeCheck4());
        assertFalse(tester.getCheckAssertHexagons());
    }

    @Test
    void testPlaceStoneAddsCircle() throws Exception {
        Polygon testHex = tester.getHexagons()[0];
        testHex.setLayoutX(100);
        testHex.setLayoutY(100);

        Method placeStone = HelloController.class.getDeclaredMethod("placeStone", Polygon.class, Color.class);
        placeStone.setAccessible(true);
        placeStone.invoke(tester, testHex, HelloController.RED);

        @SuppressWarnings("unchecked")
        Map<Polygon, Color> boardState = (Map<Polygon, Color>) getPrivateField("boardState");

        assertEquals(HelloController.RED, boardState.get(testHex));
    }

    @Test
    void testGetNeighbours() throws Exception {
        Polygon center = new Polygon();
        center.setLayoutX(100);
        center.setLayoutY(100);

        Polygon neighbor = new Polygon();
        neighbor.setLayoutX(100);
        neighbor.setLayoutY(190); // Vertical neighbor (y + 90)

        Polygon[] testHexes = new Polygon[]{center, neighbor};
        injectField("hexagons", testHexes);

        Method method = HelloController.class.getDeclaredMethod("getNeighbours", Polygon.class);
        method.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<Polygon> result = (List<Polygon>) method.invoke(tester, center);

        assertEquals(1, result.size());
        assertTrue(result.contains(neighbor));
    }

    @Test
    void testCapturingMoveRemovesOpponent() throws Exception {
        Polygon p1 = tester.getHexagons()[0];
        Polygon p2 = tester.getHexagons()[1];

        // Place RED on p1
        Method placeStone = HelloController.class.getDeclaredMethod("placeStone", Polygon.class, Color.class);
        placeStone.setAccessible(true);
        placeStone.invoke(tester, p1, HelloController.RED);

        // Place BLUE on p2
        placeStone.invoke(tester, p2, HelloController.BLUE);

        Method isCapturingMove = HelloController.class.getDeclaredMethod("isCapturingMove", Polygon.class, Color.class);
        isCapturingMove.setAccessible(true);
        isCapturingMove.invoke(tester, p1, HelloController.RED);
    }
}