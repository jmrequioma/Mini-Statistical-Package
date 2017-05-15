package controller.simulating;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.MainFields3;

import java.io.IOException;

import javafx.event.ActionEvent;

public class PopulationInputController {
	@FXML
	private Button btnConfirm;
	@FXML
	private TextField txtFInput;
	final int MIN = 25;

	// Event Listener on Button[#btnConfirm].onAction
	@FXML
	public void btnClick(ActionEvent event) throws IOException {
		// TODO Autogenerated
		try {
			int populationSize = Integer.valueOf(txtFInput.getText());
			if (populationSize < MIN) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Critical Error");
				alert.setHeaderText("Invalid Input!!!");
				alert.setContentText("Ooops, input is too small! Please change the input.");
				alert.showAndWait();
			} else {
				System.out.println(txtFInput.getText());
				MainFields3.setPopulationSize(populationSize);
				Stage stage = (Stage) btnConfirm.getScene().getWindow();
				Parent root = FXMLLoader.load(getClass().getResource("/view/simulating/InputData.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add("/theme/bloodcrimson.css");
				stage.setScene(scene);
				stage.show();
			}
			
		} catch (java.lang.RuntimeException re) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Critical Error");
			alert.setHeaderText("Invalid Input!!!");
			alert.setContentText("Ooops, input is not allowed! Please change the input.");
			alert.showAndWait();
			re.printStackTrace();
		}
	}
}
