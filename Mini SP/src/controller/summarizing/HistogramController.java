package controller.summarizing;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.MainFields2;

public class HistogramController implements Initializable {
	 @FXML private CategoryAxis xAxis;
     @FXML private NumberAxis yAxis;
     @FXML private BarChart<String,Number> histogram;
	 @FXML private Button btnConfirmHistogram;
		
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	histogram.setCategoryGap(0);
    	histogram.setBarGap(0);
    	histogram.setTitle(MainFields2.getTitle());
          
    	xAxis.setLabel("Midpoints");
    	yAxis.setLabel("Frequency");
    	xAxis.setVisible(true);
    	yAxis.setVisible(true);
    	XYChart.Series series1 = new XYChart.Series();
    	series1.setName(MainFields2.getTitle());  
    	for (int i = 0; i < MainFields2.getMidpoints().size(); i++) {
    		series1.getData().add(new XYChart.Data(MainFields2.getMidpoints().get(i), MainFields2.getFrequencies().get(i)));
    	}
    	histogram.getData().addAll(series1);
    }
    
    @FXML
	private void confirmHistogramClick(ActionEvent event) {
		Stage stage = (Stage) btnConfirmHistogram.getScene().getWindow();
		stage.close();
	}
}
