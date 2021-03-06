package tictactoe;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * UI controller for the JavaFX interface to tic-tac-toe game.
 * This class handles user input events.
 * @author Manusporn Fukkham
 */
public class GameController {
	@FXML
	private Label topLabel;
	@FXML
	private Pane centerPane;
	@FXML
	private Button newGameButton;
	/** TicTacToeGame class of the application*/
	private TicTacToeGame game;

	@FXML
	public void initialize() {
		game = new TicTacToeGame(4);
		Board board = game.getBoard();
		// make the board size match the size of pane where it is shown
		centerPane.getChildren().add(board);
		centerPane.prefWidthProperty().bind(board.prefWidthProperty());
		centerPane.prefHeightProperty().bind(board.prefHeightProperty());
		
		// listen to each square for mouse click
		EventHandler<MouseEvent> mouseClicked = this::handleCellClicked;
		board.getChildren().forEach(child -> child.setOnMouseClicked(mouseClicked));
		// The "New Game" button action
		newGameButton.setOnAction( this::handleNewGameEvent );
		
		// Listen to TicTacToeGame for changes in status.
		game.gameOver().addListener( (observable,oldValue,newValue)-> updateGameStatus());
		
		updateGameStatus();
	}

	/**To update the status of game*/
	private void updateGameStatus() {
		Player winner = game.winner();
		if (winner != Player.NONE) {
			topLabel.setText("Player "+winner+" wins!");
//			alertWinner(winner);
		}
		else if (game.isGameOver()) {
			topLabel.setText("Draw. No winner.");
//			alertWinner(winner);
		}
		else topLabel.setText("Next Player: " + game.getNextPlayer());

	}

	/**To alert winner player*/
	private void alertWinner(Player winner) {
		String player = winner.text;
		if (winner == Player.NONE) player = "No one";
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Game was end");
		alert.setHeaderText(player+" wins the game");
		alert.setContentText("Star the new game");
		alert.showAndWait();
		game.startNewGame();
	}

	/** Event handler for mouse clicks on game board. */
	public void handleCellClicked(MouseEvent event) {
		Object source = event.getSource();
		if (source instanceof BoardSquare) {
			BoardSquare cell = (BoardSquare)source;
			int row = cell.getRow();
			int col = cell.getColumn();
			double size = cell.getHeight();
			//System.out.printf("Clicked on [%d,%d]\n", row, col);
			Player player = game.getNextPlayer();
			if (game.canMoveTo(player,col, row)) {
				game.moveTo(new Piece(player, size), col, row);
				// The game will add piece to the board
			}
			updateGameStatus();
		}
	}
	
	/** Handler for button click to start a new game. */
	public void handleNewGameEvent(ActionEvent event) {
		game.startNewGame();
	}
}
