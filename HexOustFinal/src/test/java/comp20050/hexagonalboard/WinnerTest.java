/**
 * This class implements systematic unit tests for the Winner dialog, which displays winner of the
 * HexOust hexagonal board game. The tests follow the FIRST principles:
 *   Fast: Tests execute rapidly with minimal wait times
 *   Independent: Each test operates with a fresh dialog instance via BeforeEach setup
 *   Repeatable: Using SwingUtilities.invokeAndWait ensures consistent thread management
 *   Self-validating: JUnit assertions automatically verify dialog state after actions
 *   Timely: Tests validate core dialog functionality and user interaction patterns
 * The test strategy includes:
 *   Properly initializing and disposing of Swing components with BeforeEac hooks
 *   Testing UI interaction through button clicks
 *   Validating window closing behavior
 * The class utilizes JUnit 5 for test execution and assertions, with careful handling of
 * Swing components to ensure thread safety and proper event processing in the test environment.
 *
 * @see Winner
 */
package comp20050.hexagonalboard;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {
    public static final javafx.scene.paint.Color RED = javafx.scene.paint.Color.web("#f4727d");
    public static final javafx.scene.paint.Color BLUE = Color.web("#86b3d3");
    private Winner dialog;

    @BeforeEach
    void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            dialog = new Winner();
            dialog.pack();
            dialog.setVisible(true);
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        });
    }

    @Test
    void testEscapeKeyClosesDialog() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            KeyEvent escEvent = new KeyEvent(dialog, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ESCAPE, (char) KeyEvent.VK_ESCAPE);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(escEvent);
        });

        // Allow time for the dialog to process the event
        Thread.sleep(200);
        assertFalse(dialog.isVisible(),"Dialog should be closed after pressing ESC");
    }

    @Test
    void testClickingOKClosesDialog() throws Exception {
        JButton okButton = findButton(dialog,"OK");
        assertNotNull(okButton,"OK button should not be null");

        SwingUtilities.invokeAndWait(okButton::doClick);

        // Wait for the dialog to close
        Thread.sleep(100);
        assertFalse(dialog.isVisible(),"Dialog should be closed after clicking OK");
    }

    @Test
    void testWindowClose() throws Exception {
        SwingUtilities.invokeAndWait(() -> dialog.dispatchEvent(new java.awt.event.WindowEvent(dialog,java.awt.event.WindowEvent.WINDOW_CLOSING)));

        Thread.sleep(100);
        assertFalse(dialog.isVisible(),"Dialog should be closed after window close event");
    }

    // Helper to find JButton with specific text
    private JButton findButton(Container container,String text) {
        for (Component c : container.getComponents()) {
            if (c instanceof JButton && text.equals(((JButton) c).getText())) {
                return (JButton) c;
            } else if (c instanceof Container) {
                JButton result = findButton((Container) c,text);
                if (result != null) return result;
            }
        }
        return null;
    }
}