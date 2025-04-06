package comp20050.hexagonalboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    //because they're private in the Players.java
    private Players players;
    private JTextField name1Field;
    private JTextField name2Field;

    @BeforeEach
    void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            players = new Players();
            players.setModal(false); // Don't block during tests
        });

        // reflection to access private name1/name2
        name1Field = getPrivateTextField(players, "name1");
        name2Field = getPrivateTextField(players, "name2");
    }

    @Test
    void getName1() {
        Players p = new Players();
        assertEquals("", p.getName1());
    }

    @Test
    void getName2() {
        Players p = new Players();
        assertEquals("", p.getName2());
    }

    @Test
    void testNameInputRetrieval() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            name1Field.setText("Cian");
            name2Field.setText("Federica");

            assertEquals("Cian", players.getName1(), "Should return 'Cian'");
            assertEquals("Federica", players.getName2(), "Should return 'Federica'");
        });
    }

    @Test
    void checkOnOkColors() {
        Players p = new Players();
        p.onOK();

        assertEquals("red", p.getPlayer1Color());
        assertEquals("blue", p.getPlayer2Color());
    }

    @Test
    void onCancelDialog() {
        Players players = new Players();
        SwingUtilities.invokeLater(() -> {
            players.setVisible(true);
            assertTrue(players.isDisplayable(), "Dialog should be displayable before cancel");

            // Simulate closing the window
            players.dispose();
            assertFalse(players.isDisplayable(), "Dialog should be disposed after cancel");
        });
    }

    // get private JTextField using reflection
    private JTextField getPrivateTextField(Object instance, String fieldName) throws Exception {
        Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (JTextField) field.get(instance);
    }

}