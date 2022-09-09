package edu.westga.cs1302.password_manager.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2022
 */
public class MainWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> cmbCredentialList;

    @FXML
    private TextField password;

    @FXML
    private TextField systemName;

    @FXML
    private TextField userName;

    @FXML
    void submitCredential(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert this.cmbCredentialList != null : "fx:id=\"cmbCredentialList\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.password != null : "fx:id=\"password\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.systemName != null : "fx:id=\"systemName\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }

}
