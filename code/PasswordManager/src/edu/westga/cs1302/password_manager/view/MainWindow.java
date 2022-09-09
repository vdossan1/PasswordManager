package edu.westga.cs1302.password_manager.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs1302.password_manager.model.Credential;
import edu.westga.cs1302.password_manager.model.CredentialManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2022
 */
public class MainWindow {

    @FXML private ResourceBundle resources;

    @FXML private URL location;

    @FXML private ComboBox<String> cmbCredentialList;

    @FXML private TextField password;

    @FXML private TextField systemName;

    @FXML private TextField userName;
    
    private CredentialManager credentialManager;
    
    @FXML
    void removeCredential(ActionEvent event) {

    }

    @FXML void submitCredential(ActionEvent event) {
    	Credential newCredential = new Credential();
    	
    	try {
    		newCredential.setSystemName(this.systemName.getText());
    		newCredential.setUserName(this.userName.getText());
    		newCredential.setPassword(this.password.getText());
    	} catch (IllegalArgumentException e) {
    		Alert alertWindow = new Alert(AlertType.ERROR);
    		alertWindow.setContentText(e.getMessage());
    		alertWindow.showAndWait();
    		return;
    	}
    	
    	if (!this.credentialManager.addCredential(newCredential)) {
    		Alert alertWindow = new Alert(AlertType.ERROR);
    		alertWindow.setContentText("System name already exists");
    		alertWindow.showAndWait();
    		return;
    	}
    	
    	
    	this.cmbCredentialList.getItems().removeAll(this.credentialManager.listOfSystemNames());
    	this.cmbCredentialList.getItems().addAll(this.credentialManager.listOfSystemNames());
    }
    
    @FXML
    void systemSelected(ActionEvent event) {
    	
    	String selectedSystem = this.cmbCredentialList.getValue();
    	Credential selectedCredential = null;
    	
    	try {
    		selectedCredential = this.credentialManager.getCredentialWithSpecifiedName(selectedSystem);
    	} catch (IllegalArgumentException e) {
    		Alert alertWindow = new Alert(AlertType.ERROR);
    		alertWindow.setContentText(e.getMessage());
    		alertWindow.showAndWait();
    		return;
    	}
    	
    	this.systemName.setText(selectedCredential.getSystemName());
    	this.userName.setText(selectedCredential.getUserName());
    	this.password.setText(selectedCredential.getPassword());
    }

    @FXML
    void initialize() {
        assert this.cmbCredentialList != null : "fx:id=\"cmbCredentialList\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.password != null : "fx:id=\"password\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.systemName != null : "fx:id=\"systemName\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'MainWindow.fxml'.";
        
        this.credentialManager = new CredentialManager();

    }

}
