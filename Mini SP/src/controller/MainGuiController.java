package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainGuiController extends Application {
	@FXML
	private Label lbl1;
	@FXML
	private Label lbl2;
	@FXML
	private Label lbl3;
	@FXML
	private Label lbl4;
	
	public void handle(KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.DIGIT1)) {
        	System.out.println("hello4");
        	try {
        		System.out.println("hello5");
    			Parent root = FXMLLoader.load(getClass().getResource("/view/descripitve/MainGui.fxml"));
    			Scene scene = new Scene(root);
    			scene.getStylesheets().add(getClass().getResource("/theme/bloodcrimson.css").toExternalForm());
    			Stage stage = (Stage) lbl1.getScene().getWindow();
    			stage.setTitle("Output");
    			stage.setScene(scene);
    			stage.setResizable(false);
    			stage.show();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
        } else if (ke.getCode().equals(KeyCode.DIGIT3)) {   // descriptive
        	try {
    			Parent root = FXMLLoader.load(getClass().getResource("/view/descriptive/Menu.fxml"));
    			Scene scene = new Scene(root);
    			scene.getStylesheets().add(getClass().getResource("/theme/bloodcrimson.css").toExternalForm());
    			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
    				@Override
    				public void handle(KeyEvent ke)
    			    {
    			        if (ke.getCode().equals(KeyCode.DIGIT1))
    			        {
    			        	System.out.println("hello2");
    			        }
    			    }
    			});
    			Stage stage = (Stage) lbl1.getScene().getWindow();
    			stage.setTitle("Descriptive Statistics");
    			stage.setScene(scene);
    			stage.setResizable(false);
    			stage.show();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
        }
    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
	}
}
