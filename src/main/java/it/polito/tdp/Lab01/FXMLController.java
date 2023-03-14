package it.polito.tdp.Lab01;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.Lab01.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnCancella;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTempiEsecuzione;
    
    @FXML
    void doCancella(ActionEvent event) {  
    	long startTime = System.nanoTime();
    	String risultato = "";
    	String parolaSelezionata = txtResult.getSelectedText();
    	elenco.elimina(parolaSelezionata);
    	for (String s: elenco.getElenco()) 
    		risultato += s + "\n";
    	txtResult.setText(risultato);
    	long elapsedNanos = System.nanoTime() - startTime;
    	txtTempiEsecuzione.appendText(String.valueOf(elapsedNanos) + "\n");
    }

    @FXML
    void doInsert(ActionEvent event) {
    	long startTime = System.nanoTime();
    	String risultato = "";
    	elenco.addParola(txtParola.getText());
    	txtParola.clear();
    	for (String p: elenco.getElenco()) 
    		risultato += p + "\n";
    	txtResult.setText(risultato);
    	long elapsedNanos = System.nanoTime() - startTime;
    	txtTempiEsecuzione.appendText(String.valueOf(elapsedNanos) + "\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	long startTime = System.nanoTime();
    	elenco.reset();
    	txtResult.clear();
    	long elapsedNanos = System.nanoTime() - startTime;
    	txtTempiEsecuzione.appendText(String.valueOf(elapsedNanos) + "\n");
    }

    @FXML
    void initialize() {
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }

}
