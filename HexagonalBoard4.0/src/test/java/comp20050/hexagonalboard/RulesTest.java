package comp20050.hexagonalboard;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class RulesTest {

    private Rules dialog;

    @BeforeEach
    void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            dialog = new Rules();
            dialog.pack();
            dialog.setVisible(true);
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        });
    }

    @AfterEach
    void tearDown() throws Exception {
        if (dialog != null) {
            SwingUtilities.invokeAndWait(() -> dialog.dispose());
        }
    }

    @Test
    void testClickingOKClosesDialog() throws Exception {
        JButton okButton = findButton(dialog, "OK");
        assertNotNull(okButton, "OK button should not be null");

        SwingUtilities.invokeAndWait(okButton::doClick);

        // Wait for the dialog to close
        Thread.sleep(100);
        assertFalse(dialog.isVisible(), "Dialog should be closed after clicking OK");
    }

    @Test
    void testEscapeKeyClosesDialog() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            KeyEvent escEvent = new KeyEvent(dialog, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ESCAPE, (char) KeyEvent.VK_ESCAPE);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(escEvent);
        });

        // Allow time for the dialog to process the event
        Thread.sleep(200);
        assertFalse(dialog.isVisible(), "Dialog should be closed after pressing ESC");
    }

    @Test
    void testWindowClose() throws Exception {
        SwingUtilities.invokeAndWait(() -> dialog.dispatchEvent(new java.awt.event.WindowEvent(dialog, java.awt.event.WindowEvent.WINDOW_CLOSING)));

        Thread.sleep(100);
        assertFalse(dialog.isVisible(), "Dialog should be closed after window close event");
    }

    // Helper to find JButton with specific text
    private JButton findButton(Container container, String text) {
        for (Component c : container.getComponents()) {
            if (c instanceof JButton && text.equals(((JButton) c).getText())) {
                return (JButton) c;
            } else if (c instanceof Container) {
                JButton result = findButton((Container) c, text);
                if (result != null) return result;
            }
        }
        return null;
    }
}
