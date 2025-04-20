package comp20050.hexagonalboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class HelloControllerTest {

    @Test
    void testPlayerNames() {
        HelloController tester = new HelloController();

        assertEquals("Player 1", tester.getPlayer1Name());
        assertEquals("Player 2", tester.getPlayer2Name());
    }

    @Test
    void getPlayerTurn() {
        HelloController tester = new HelloController();

        //false is red player, and they should be initialized to start first
        assertEquals(false, tester.getPlayerTurn());
    }

    @Test
    void testHexagonsFilled() {
        HelloController tester = new HelloController();

        //checks that the array of hexagons for the board is completely full
        assertEquals(127, tester.getHexagons().length);
    }

}