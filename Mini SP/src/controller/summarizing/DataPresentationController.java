package controller.summarizing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.common.eventbus.EventBus;

import controller.summarizing.CollapseFirstEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.MainFields2;

public class DataPresentationController implements Initializable {

	@FXML private Button btnSampleData;
	@FXML private Button btnGenerateTable;
	@FXML private Button btnGenerateGraph;
	@FXML private Button btnFinish;
	@FXML private CheckBox cbCollapseFirst;
	@FXML private CheckBox cbCollapseLast;
	@FXML private Label lblTitle;
	@FXML private Pane paneTable;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblTitle.setText(MainFields2.getTitle());
		cbCollapseState();
	}
	
	private void cbCollapseState() {
		String type = MainFields2.getType();
		if(type.equals("Categorical")) {
			cbCollapseFirst.setDisable(true);
			cbCollapseLast.setDisable(true);
		} else {
			cbCollapseFirst.setDisable(false);
			cbCollapseLast.setDisable(false);
		}
	}
	
	@FXML
	private void collapseFirst() {
		EventBus eventBus = MainFields2.getEventBus();
		eventBus.post(new CollapseFirstEvent(cbCollapseFirst));
	}
	
	@FXML
	private void collapseLast() {
		EventBus eventBus = MainFields2.getEventBus();
		eventBus.post(new CollapseLastEvent(cbCollapseLast));
	}
	
	@FXML
	public void sampleDataClick(ActionEvent event) throws IOException {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/summarizing/SampleData.fxml"));		
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/theme/bloodcrimson.css");
		stage.setTitle("Sample Data");
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(btnSampleData.getScene().getWindow());
		stage.showAndWait();
	}
	
	@FXML
	public void generateTableClick(ActionEvent event) throws IOException {
		if (MainFields2.getValid()) {
			Pane paneTypeTable;
			String type = MainFields2.getType();
			
			if(type.equals("Categorical")) {
				paneTypeTable = FXMLLoader.load(getClass().getResource("/view/summarizing/CategoricalTable.fxml"));
			} else { // type.equals("Numerical")
				paneTypeTable = FXMLLoader.load(getClass().getResource("/view/summarizing/NumericalTable.fxml"));
			}
			
			paneTable.getChildren().add(paneTypeTable);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Critical Error");
			alert.setHeaderText("Invalid Click!!!");
			alert.setContentText("Ooops, clicking this is not allowed. Please enter sample data first.");
			alert.showAndWait();
		}
	}
	
	@FXML
	public void generateGraphClick(ActionEvent event) throws IOException {
		if (MainFields2.getValid()) {
			Parent root;
			Stage stage = new Stage();
			if (MainFields2.getType().equals("Categorical")) {
				root = FXMLLoader.load(getClass().getResource("/view/summarizing/PieChart.fxml"));
				stage.setTitle("Pie Chart");
			} else {
				root = FXMLLoader.load(getClass().getResource("/view/summarizing/Histogram.fxml"));
				stage.setTitle("Histogram");
			}
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/theme/bloodcrimson.css");
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(btnGenerateGraph.getScene().getWindow());
			stage.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Critical Error");
			alert.setHeaderText("Invalid Click!!!");
			alert.setContentText("Ooops, clicking this is not allowed. Please enter sample data first.");
			alert.showAndWait();
		}
	}
	
	@FXML
	public void finishClick() throws IOException {
		Stage stage = (Stage) btnFinish.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/view/summarizing/Menu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/theme/bloodcrimson.css");
		stage.setScene(scene);
		stage.show();
		MainFields2.reset(); 
	}
}
