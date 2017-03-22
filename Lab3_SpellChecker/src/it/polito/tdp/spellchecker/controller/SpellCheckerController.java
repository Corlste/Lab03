/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SpellCheckerController {
	private Dictionary dizionario = new Dictionary();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Label lblErrors;
    
    @FXML
    private Label lblTime;
    
    @FXML // fx:id="cmbBox"
    private ComboBox<String> cmbBox; // Value injected by FXMLLoader

    @FXML // fx:id="txtText"
    private TextField txtText; // Value injected by FXMLLoader

    @FXML // fx:id="btcSpellCheck"
    private Button btcSpellCheck; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btcClearText"
    private Button btcClearText; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    	txtText.clear();
    	txtResult.clear();
    }
    
    @FXML
    void chooseLanguage(ActionEvent event) {
    	dizionario.loadDictionary(cmbBox.getValue());

    }

    
    @FXML
    void doSpellCheck(ActionEvent event) {
    	long t1 = System.nanoTime();
    	int numErr=0;
    	LinkedList<RichWord> inputList = dizionario.spellCheckText( txtText.getText().split(" ") ); 
    	String boh="";
    	for (int i=0; i<inputList.size(); i++){
    		if (inputList.get(i).isCorretta()==false){
    			boh += inputList.get(i).getParola()+"\n";
    			numErr++;
    		}
    		
    	}
    	long t2= System.nanoTime();
    	txtResult.setText(boh);
    	lblErrors.setText("Number of errors: "+numErr);
		lblTime.setText("Time: " + (t2-t1)/1e09 + "secondi");
	}


 
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbBox != null : "fx:id=\"cmbBox\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        cmbBox.getItems().addAll("English","Italian");
        
        assert txtText != null : "fx:id=\"txtText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btcSpellCheck != null : "fx:id=\"btcSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btcClearText != null : "fx:id=\"btcClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }
}
