package edu.westga.cs1302.password_manager.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Utility class for JavaFX
 * @author Vitor dos Santos
 * @version Fall 2022
 *
 */
public class JavaFXUtility {
	
	/**
	 * Displays an alert windows to the user for an Illegal Argument Exception
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param error the exception being throw
	 */
	public static void alertWindow(String error) {
		Alert alertWindow = new Alert(AlertType.ERROR);
		alertWindow.setContentText(error);
		alertWindow.showAndWait();
		return;
	}

	/**
	 * Displays an alert windows to the user for an Illegal Argument Exception
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param error the exception being throw
	 */
	public static void alertWindow(IllegalArgumentException error) {
		Alert alertWindow = new Alert(AlertType.ERROR);
		alertWindow.setContentText(error.getMessage());
		alertWindow.showAndWait();
		return;
	}
	
	/**
	 * Displays an alert windows to the user for an Illegal State Exception
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param error the exception being throw
	 */
	public static void alertWindow(IllegalStateException error) {
		Alert alertWindow = new Alert(AlertType.ERROR);
		alertWindow.setContentText(error.getMessage());
		alertWindow.showAndWait();
		return;
	}

}
