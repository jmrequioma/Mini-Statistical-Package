package controller.summarizing;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.MainFields2;

public class PieChartController implements Initializable {
	private ObservableList<PieChart.Data> details = FXCollections.observableArrayList();
	@FXML private PieChart pieChart;
	@FXML private Button btnConfirmPieChart;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for (int i = 0; i < MainFields2.getFusedData().size(); i++) {
			details.add(new PieChart.Data(MainFields2.getFusedData().get(i), MainFields2.getDataPercentage().get(i)));
		}
		
		pieChart.setData(details);
		pieChart.setTitle(MainFields2.getTitle());
		pieChart.setLegendSide(Side.BOTTOM);
		pieChart.setLabelsVisible(true);
		
		for (final PieChart.Data data : pieChart.getData()) {
			DecimalFormat df = new DecimalFormat("#.##");
			data.nameProperty().bind(Bindings.concat(data.getName(), " ", "(", df.format(data.getPieValue()), " %", ")"));
		}
	}
	
	@FXML
	private void confirmPieChartClick(ActionEvent event) {
		Stage stage = (Stage) btnConfirmPieChart.getScene().getWindow();
		stage.close();
	}
}
