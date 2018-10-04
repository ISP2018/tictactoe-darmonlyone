## Tic-Tac-Toe https://travis-ci.com/darmonlyone/tictactoe.svg?branch=master

### Description

A tic-tac-toe game written using JavaFX.

| Class  | Responsibility              |
|--------|-----------------------------|
| Main   | Start the app, show the view. |
| GameUI.fxml | FXML file for game board and buttons. |
| GameController | Handle user input, update game. |
| TicTacToeGame  | "Model" in MVC. Logic for tic-tac-toe. Also updates board. |
| Board          | View of the game board, using JavaFX components. |
| Player         | Enum of players: X, O, and NONE. |
| Piece          | When a player clicks on BoardSquare, a Piece containing "X" or "O" for a Player is added to board. |


Please do the following exercises in the order given.

### 1. Code Review

Review the code in the TicTacToeGame class.
Find at least 3 defects. Defects may include bad style,
missing Javadoc, or failing to follow guidelines as you
learned in Programming 2.

**To Do:** 

1. For each defect you find, open an issue on Github.
In the issue describe the problem and reference to the file
or lines in the file (you can include reference to code lines in issues).
2. Completely review the class before fixing issues.
3. Fix the issues in code and review again.
4. Run the JUnit tests to verify you didn't introduce any errors.
5. Commit code and close the issue.  Close the issues using [keywords in commit messages](https://help.github.com/articles/closing-issues-using-keywords/).  For example: `git commit -m "This closes #2"`, when you push to the default branch will close issue 2.  See [list of keywords](https://help.github.com/articles/closing-issues-using-keywords/) that Github recognizes.

### 2. Create a Release Tag
 
Add an annotated tag named "VER_1.0" for this release.

### 3. Create a Feature Branch for Next Iteration

The World TicTacToe Association (WTA) wants to you modify game to use a 4x4 board.
Create a new branch for this work. 
Check out the branch and make changed necessary for 4x4 tic-tac-toe.
Periodically push the branch code to Github.
Write JUnit tests for the TicTacToe class to verify it works for 4x4 game.

### 4. Flash News!

To be announced...

### 5. What to Submit

When the new 4x4 TicTacToe is working, and has incorporated (merged) the bug fix from Item 4:

1. create a JAR file and add it do the `dist/` directory
2. merge the branch into master
3. create an annotated tag "VER_2.0" for this release
