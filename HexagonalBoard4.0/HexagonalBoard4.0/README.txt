# This file includes instructions for running the code and playing our HexOust game.

Project Title: HexOust Game - by Software Masters

This project implements a hexagonal board game called HexOust, featuring:
- Main application launcher in `HelloApplication.java` handling game start sequence
- Game board interface using JavaFX in `hello-view.fxml`
- Game controllers and logic in supporting classes
- Player management and rules dialogs using Swing components

The game features a complete gameplay experience with splash screen, rules explanation, player customization, and an interactive hexagonal game board.

## HOW TO RUN THE JAR FILES FROM THE COMMAND LINE
----------------------------------------------------------------------------------------

Prerequisites:
- Ensure that Java is installed and `java` is accessible from your terminal/command prompt.
  You can verify by running:
    java -version

Step-by-step:

1. Open your terminal (Linux/macOS) or Command Prompt (Windows).
2. Navigate to the folder containing the JAR file using `cd`:
    Example: cd path/to/your/project
3. Run the JAR file with:  java -jar hexoust.jar

Notes:
- The JAR file contains all necessary resources including graphics and UI components.
- Make sure your system meets the minimum requirements for running JavaFX applications.

## HOW TO RUN THE PROJECT IN INTELLIJ IDEA
----------------------------------------------------------------------------------------

Prerequisites:
- IntelliJ IDEA
- JDK configured in IntelliJ (recommended: JDK 17 or above)
- JavaFX SDK properly configured

Step-by-step:

1. Open IntelliJ IDEA.

2. Click on "Open" and select the folder that contains your Java files:

3. Once opened, IntelliJ should automatically detect it's a Java project.

4. Make sure a valid JDK is selected:
- Go to `File → Project Structure → Project`
- Select your installed JDK (e.g., 17)

5. Run the main application class:
- Open `HelloApplication.java`
- Right-click anywhere in the file and choose "Run HelloApplication.main()"

6. The game will launch showing the logo splash screen, followed by rules dialog, player selection, and finally the game board.

## Project Files:

- `HelloApplication.java` — Main application launcher class
- `HelloController.java` — Main game controller
- `Rules.java` — Dialog for displaying game rules
- `Players.java` — Dialog for player name input
- `Winner.java` — Dialog for winner name display
- `hello-view.fxml` — JavaFX layout for game board
- Various resource files including images in the resources folder
- `README.txt` — Instructions
- `HexOust_S2_BoardWithNC.jar` — JAR file generated from this project for easy execution

----------------------------------------------------------------------------------------

Questions or issues?
Feel free to contact the developers.

-Document made by Federica Fucetola, Laura González Calleja and Cian Latchford - 05/05/2025