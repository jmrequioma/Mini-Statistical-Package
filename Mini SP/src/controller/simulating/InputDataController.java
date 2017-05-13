package controller.simulating;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import main.MainFields3;
import main.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;

public class InputDataController {
	@FXML
	private TextField txtFSampleData;
	@FXML
	private Button btnAddItem;
	@FXML
	private Button btnConfirmSampleData;
	final int MIN = 25;
	private int index = 0;
	private List<Data> samplingFrame = new ArrayList<Data>();
	private String dataType = "Neutral";
	private int population = MainFields3.getPopulationSize();
	private int populationCounter = 0;
	
	// Event Listener on Button[#btnAddItem].onAction
	@FXML
	public void addItemClick(ActionEvent event) throws IOException {
		boolean valid = true;
		String text = txtFSampleData.getText();
		Data data = null;
		
		if(isInteger(text) && !dataType.equals("Character")) {
			int dataInteger = Integer.valueOf(text);
			data = new Data(dataInteger, index);
			dataType = "Integer";
		} else if(!isInteger(text) && !specialChar(text) && !dataType.equals("Integer")){
			if(text.length() == 1) {
				char dataCharacter = text.charAt(0);
				data = new Data(dataCharacter, index);
				dataType = "Character";
			} else {
				valid = false;
			}
		} else {
			valid = false;
		}
		
		if(valid) {
			samplingFrame.add(data);
			index++;
			populationCounter++;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Critical Error");
			alert.setHeaderText("Invalid Input!!!");
			alert.setContentText("Ooops, input is not allowed! Please change the input.");
			alert.showAndWait();
		}
		txtFSampleData.setText("");
		if (population == populationCounter) {
			MainFields3.setSamplingFrame(samplingFrame);
			MainFields3.setDataType(dataType);
			//go to next scene
			Stage stage = (Stage) btnAddItem.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("/view/simulating/Data.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/theme/bloodcrimson.css");
			stage.setTitle("Data");
			stage.setScene(scene);
			stage.show();
		}
	}
	// Event Listener on Button[#btnConfirmSampleData].onAction
	@FXML
	public void confirmSampleDataClick(ActionEvent event) throws IOException {
		
	}
	
	private boolean isInteger(String text) {
		return text.matches("^-?\\d+$");
	}
	
	private boolean specialChar(String text) {

		return !text.matches("^[a-zA-Z]*$");
	}
	
	public void reset() {
		populationCounter = 0;
		index = 0;
		samplingFrame = new ArrayList<Data>();
		dataType = "Neutral";
	}
}
