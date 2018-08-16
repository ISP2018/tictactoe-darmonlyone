package tictactoe;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Launch the JavaFX application.
 * @author Manusporn Fukkham
 */
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Start the UI using FXML form.
	 */
	@Override
	public void start(Stage primaryStage) {
		String fxml = "tictactoe/GameUI.fxml";
		URL formURL = this.getClass().getClassLoader().getResource(fxml);
		if (formURL == null) {
			Logger.getLogger("Main").severe("Could not find UI form "+fxml);
			return;
		}
		try {
			FXMLLoader loader = new FXMLLoader(formURL);
			Parent parent = loader.load();
			primaryStage.setTitle("Tic-Tac-Toe");
			Scene scene = new Scene(parent);
	        primaryStage.setScene(scene);
	        primaryStage.sizeToScene();
	        primaryStage.show();
		} catch (Exception ex) {
			Logger.getLogger("Main").log(Level.SEVERE, "Exception initializing game: \n"+ex.getMessage(), ex);
		}
	}

}
