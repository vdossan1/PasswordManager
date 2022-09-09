package edu.westga.cs1302.password_manager;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Launches the GUI for the password manager
 * 
 * @author Vitor dos Santos
 * @version Fall 2022
 *
 */
public class Main extends Application {
	private static final String WINDOW_TITLE = "Password Manager";
	private static final String GUI_RESOURCE = "view/MainWindow.fxml";

	/**
	 * JavaFX entry point.
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @throws IOException
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource(Main.GUI_RESOURCE));
		Scene scene = new Scene(parent);
		primaryStage.setTitle(WINDOW_TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Primary Java entry point.
	 *
	 * @precondition none
	 * @postcondition none
	 *
	 * @param args command line arguments
	 */

	public static void main(String[] args) {
		Main.launch(args);
	}

}
