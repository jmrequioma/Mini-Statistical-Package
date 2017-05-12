package controller.summarizing;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.MainFields2;

public class SampleDataController implements Initializable {
	
	@FXML private TextField txtFSampleData;
	@FXML private TextArea txtASampleData;
	@FXML private Button btnAddItem;
	@FXML private Button btnDeleteSampleData;
	@FXML private Button btnClearSampleData;
	@FXML private Button btnConfirmSampleData;
	private ArrayList<String> sampleDatasString = new ArrayList<String>();   // this container is supposed to be dynamic, i was thinking of using the Data class like before
	private ArrayList<Float> sampleDatasFloat = new ArrayList<Float>();
	private int ctr;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (MainFields2.getType().equals("Categorical")) {
			if (MainFields2.getStringExists()) {
				for (int i = 0; i < MainFields2.getSampleDataString().size(); i++) {
					txtASampleData.appendText(MainFields2.getSampleDataString().get(i) + " ");
					sampleDatasString.add(MainFields2.getSampleDataString().get(i));
				}
				MainFields2.setSampleDataString(sampleDatasString);
				ctr = MainFields2.getSampleDataString().size();
			} else {
				System.out.println("empty");
			}
		} else {
			if (MainFields2.getFloatExists()) {
				for (int i = 0; i < MainFields2.getSampleDataFloat().size(); i++) {
					txtASampleData.appendText(MainFields2.getSampleDataFloat().get(i) + " ");
					sampleDatasFloat.add(MainFields2.getSampleDataFloat().get(i));
				}
				ctr = MainFields2.getSampleDataFloat().size();
			} else {
				System.out.println("empty");
			}
		}
	}
	
	@FXML
	private void addItemClick(ActionEvent event) throws IOException {
		String type = MainFields2.getType();
		String input = txtFSampleData.getText();
		if (input.equals("") || input.startsWith(" ")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Critical Error");
			alert.setHeaderText("Invalid Input!!!");
			alert.setContentText("Ooops, input is not allowed! Please change the input.");
			alert.showAndWait();
		} else {
			if(type.equals("Categorical")) {
				txtASampleData.appendText(input + " ");
				sampleDatasString.add(input);
				//System.out.println(sampleDatas.get(ctr++));   // testing purposes
			} else { // type.equals("Numerical")
				try {
					float inputFloat = Float.valueOf(input);
					txtASampleData.appendText(inputFloat + " ");
					sampleDatasFloat.add(inputFloat);
				} catch ( java.lang.RuntimeException re) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Critical Error");
					alert.setHeaderText("Invalid Input!!!");
					alert.setContentText("Ooops, input is not allowed! Please change the input.");
					alert.showAndWait();
				}
			}	
		}
		txtFSampleData.clear();
		ctr++;
	}
	
	@FXML
	private void deleteSampleDataClick(ActionEvent event) throws IOException {
		String type = MainFields2.getType();
		
		if (ctr > 0) {
			if(type.equals("Categorical")) {
				updateTxtACategorical();
			} else { // type.equals("Numerical")
				updateTxtANumerical();
			}
			ctr--;
		}
	}
	
	private void updateTxtACategorical() {
		if (MainFields2.getStringExists()) {
			System.out.println(MainFields2.getSampleDataString().remove(MainFields2.getSampleDataString().size() - 1));
			txtASampleData.clear();
			for (int i = 0; i < MainFields2.getSampleDataString().size(); i++) {
				txtASampleData.appendText(MainFields2.getSampleDataString().get(i) + " ");
			}
		} else {
			System.out.println(sampleDatasString.remove(sampleDatasString.size() - 1));
			txtASampleData.clear();
			for (int i = 0; i < sampleDatasString.size(); i++) {
				txtASampleData.appendText(sampleDatasString.get(i) + " ");
			}
		}
	}
	
	private void updateTxtANumerical() {
		System.out.println(sampleDatasFloat.remove(sampleDatasFloat.size() - 1));
		txtASampleData.clear();
		for (int i = 0; i < sampleDatasFloat.size(); i++) {
			txtASampleData.appendText(sampleDatasFloat.get(i) + " ");
		}
	}
	
	@FXML
	private void clearSampleDataClick(ActionEvent event) throws IOException {
		String type = MainFields2.getType();
		
		if(type.equals("Categorical")) {
			sampleDatasString.clear();
		} else { // type.equals("Numerical")
			sampleDatasFloat.clear();
		}
		
		txtASampleData.clear();
		ctr = 0;
	}
	
	@FXML
	private void confirmSampleDataClick(ActionEvent event) {
		Stage stage = (Stage) btnConfirmSampleData.getScene().getWindow();
		
		String type = MainFields2.getType();
		if(type.equals("Categorical")) {
			if (sampleDatasString.isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Critical Error");
				alert.setHeaderText("Invalid Click!!!");
				alert.setContentText("Ooops, clicking this is not allowed. Please enter sample data first.");
				alert.showAndWait();
			} else {
				MainFields2.setSampleDataString(sampleDatasString);
				MainFields2.setStringExists(true);
				stage.close();
			}
		} else { // type.equals("Numerical")
			if (sampleDatasFloat.isEmpty() || sampleDatasFloat.size() <= 1) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Critical Error");
				alert.setHeaderText("Invalid Click!!!");
				alert.setContentText("Ooops, clicking this is not allowed. Please enter sample data first.");
				alert.showAndWait();
			} else {
				MainFields2.setSampleDataFloat(sampleDatasFloat);
				MainFields2.setFloatExists(true);
				stage.close();
			}
		}
		MainFields2.setValid(true);
	}
}
