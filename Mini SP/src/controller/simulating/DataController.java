package controller.simulating;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import main.Data;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import main.MainFields3;

public class DataController implements Initializable {
	@FXML
	private TextArea txtASampleData;
	@FXML
	private Button btnContinue;
	@FXML
	private Button btnDiscard;
	@FXML
	private Label lblTitle;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblTitle.setText("The Sampling Frame");
		for (Data data : MainFields3.getSamplingFrame()) {
			if (MainFields3.getDataType().equals("Integer")) {
				txtASampleData.appendText("{Index: " + (data.getIndex() + 1) + " ; Data: " + data.getDataInteger() + "} ");
			} else {
				txtASampleData.appendText("{Index: " + (data.getIndex() + 1) + " ; Data: " + data.getDataCharacter() + "} ");
			}
		}
	}
	
	// Event Listener on Button[#btnContinue].onAction
	@FXML
	public void continueClick(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/simulating/Output.fxml"));
		Stage stage = (Stage) btnContinue.getScene().getWindow();
		stage.setTitle("Choices");
		stage.setResizable(false);
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/theme/bloodcrimson.css");
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void discardClick(ActionEvent event) throws IOException {
		MainFields3.clearSamplingFrame();
		Stage stage = (Stage) btnDiscard.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/view/simulating/InputData.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/theme/bloodcrimson.css");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		
	}
}
