package edu.westga.cs1302.password_manager.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs1302.password_manager.model.Credential;
import edu.westga.cs1302.password_manager.model.CredentialManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author Vitor dos Santos
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
    void systemSelected(ActionEvent event) {
    	
    	String selectedSystem = this.cmbCredentialList.getValue();
   
    	Credential selectedCredential = null;
    	
    	if (selectedSystem != null) {
    		try {
        		selectedCredential = this.credentialManager.getCredentialWithSpecifiedName(selectedSystem);
        	} catch (IllegalArgumentException e) {
        		JavaFXUtility.alertWindow(e);
        	}
    		
    		this.systemName.setText(selectedCredential.getSystemName());
        	this.userName.setText(selectedCredential.getUserName());
        	this.password.setText(selectedCredential.getPassword());       	
    	}
    }
    
    @FXML 
    void removeCredential(ActionEvent event) {
    
    	String selectedSystem = this.systemName.getText();
    	
    	try {
    		this.credentialManager.removeCredential(selectedSystem);
    	} catch (IllegalArgumentException e) {
    		JavaFXUtility.alertWindow(e);
    	} catch (IllegalStateException e) {
    		JavaFXUtility.alertWindow(e);
    	}
    	
    	this.cmbCredentialList.getItems().remove(selectedSystem);
    	this.cmbCredentialList.getItems().setAll(this.credentialManager.listOfSystemNames());
    	
    	this.systemName.clear();
    	this.userName.clear();
    	this.password.clear();
    	
    }

    @FXML 
    void submitCredential(ActionEvent event) {
    	Credential newCredential = null;
    	
    	try {
    		newCredential = new Credential(
    				this.systemName.getText(),
    				this.userName.getText(),
    				this.password.getText());
    		this.credentialManager.addCredential(newCredential);
    	} catch (IllegalArgumentException e) {
    		JavaFXUtility.alertWindow(e);
    	}
    	
    	this.cmbCredentialList.getItems().setAll(this.credentialManager.listOfSystemNames());
    	
    	this.systemName.clear();
    	this.userName.clear();
    	this.password.clear();
    }
    
    @FXML
    void updateCredential(ActionEvent event) {
    	
    	String selectedSystem = this.systemName.getText();
    	
    	String newUserName = this.userName.getText();
    	String newPassword = this.password.getText();
    	
    	try {
    		this.credentialManager.updateCredential(selectedSystem, newUserName, newPassword);
    	} catch (IllegalStateException e) {
    		JavaFXUtility.alertWindow(e);
    	} catch (IllegalArgumentException e) {
    		JavaFXUtility.alertWindow(e);
    	}
    	
    	//this.cmbCredentialList.getItems().setAll(this.credentialManager.listOfSystemNames());
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
