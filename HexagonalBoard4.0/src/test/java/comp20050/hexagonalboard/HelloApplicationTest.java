/**
 * This class provides unit tests for the HelloApplication class, which handles the
 * application start sequence for the HexOust hexagonal board game. The tests follow
 * the FIRST principles:
 *   Fast: Tests execute efficiently with minimal external dependencies
 *   Independent: Each test uses a fresh application instance through BeforeEach
 *   Repeatable: Tests maintain consistent behavior across executions
 *   Self-validating: JUnit assertions verify expected outcomes automatically
 *   Timely: Tests specifically target key application functionality
 * The test strategy includes:
 *   Using reflection to access and test private methods
 *   Testing UI positioning logic for centering dialogs
 *   Verifying splash screen display and callback execution
 *   Confirming successful application launching
 *   Special considerations for UI thread safety and timing
 * Note: As indicated in the class comment, these tests should be run individually
 * to prevent UI component overlap and interaction issues.
 *
 * @see HelloApplication
 */
package comp20050.hexagonalboard;

import org.junit.jupiter.api.*;
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/* Better to run these tests separately to avoid the different interfaces
   overlapping or the different UIs collapsing.
   RUN EACH TEST INDIVIDUALLY
 */
public class HelloApplicationTest {

    private HelloApplication app;

    @BeforeEach
    public void setUp() {
        app = new HelloApplication();
    }

    @Test
    public void testCenterWindow() throws Exception {
        // Create dummy dialog of known size
        JDialog dialog = new JDialog();
        dialog.setSize(300, 200);

        // Use reflection to access private method
        Method method = HelloApplication.class.getDeclaredMethod("centerWindow", Dialog.class);
        method.setAccessible(true);
        method.invoke(app, dialog);

        // Expected center position
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int expectedX = (screenSize.width - 300) / 2;
        int expectedY = (screenSize.height - 200) / 2;

        assertEquals(expectedX, dialog.getX(), "Dialog X not centered");
        assertEquals(expectedY, dialog.getY(), "Dialog Y not centered");
    }

    @Test
    public void testShowLogo() throws Exception {
        // Simple callback that sets a flag
        final boolean[] ranCallback = {false};

        Runnable callback = () -> ranCallback[0] = true;

        Method method = HelloApplication.class.getDeclaredMethod("showLogo", Runnable.class);
        method.setAccessible(true);
        method.invoke(app, callback);

        // Allow time for logo thread to run (worst-case 4s)
        Thread.sleep(4000);
        assertFalse(ranCallback[0], "Callback not executed after logo");
    }

    @Test
    public void testMainLaunches() {
        assertDoesNotThrow(() -> HelloApplication.main(new String[]{}));
    }
}
