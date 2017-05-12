package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class IntroController implements Initializable {
	@FXML
	private TextArea txtA;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		txtA.appendText("Description:\n Gamma Basic Statistics Calculator is a simple program \n which is a compilation of "
				+ "different statistical methods like different sampling methods, \n ways to summarize and present data, and descriptive statistics." + "\n\n\n\n\n");
		txtA.appendText("Developers:\n Gamaliel E. Petralba & Jerome Enrico M. Requioma");
		
	}
	
	public void handle(KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
        	System.out.println("hello4");
        	try {
        		System.out.println("hello5");
    			Parent root = FXMLLoader.load(getClass().getResource("/view/MainGui.fxml"));
    			Scene scene = new Scene(root);
    			scene.getStylesheets().add(getClass().getResource("/theme/bloodcrimson.css").toExternalForm());
    			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
    				@Override
    				public void handle(KeyEvent ke) {
    			        if (ke.getCode().equals(KeyCode.DIGIT1)) {
    			        	System.out.println("hello1");
    			        	try {
    			    			Parent root = FXMLLoader.load(getClass().getResource("/view/MainGui.fxml"));
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
    			    		} catch(Exception e) {
    			    			e.printStackTrace();
    			    		}
    			        } else if (ke.getCode().equals(KeyCode.DIGIT2)) {   // summarizing
    			        	try {
    			        		System.out.println("summarizing");
    			    			Parent root = FXMLLoader.load(getClass().getResource("/view/summarizing/Menu.fxml"));
    			    			Scene scene = new Scene(root);
    			    			scene.getStylesheets().add(getClass().getResource("/theme/bloodcrimson.css").toExternalForm());
    			    			Stage stage = new Stage();
    			    			//stage.setTitle("Menu");
    			    			stage.setScene(scene);
    			    			stage.setResizable(false);
    			    			stage.show();
    			    		} catch(Exception e) {
    			    			e.printStackTrace();
    			    		}
    			        } else if (ke.getCode().equals(KeyCode.DIGIT3)) {   // descriptive
    			        	try {
    			        		System.out.println("descriptive");
    			    			Parent root = FXMLLoader.load(getClass().getResource("/view/descriptive/Menu.fxml"));
    			    			Scene scene = new Scene(root);
    			    			scene.getStylesheets().add(getClass().getResource("/theme/bloodcrimson.css").toExternalForm());
    			    			Stage stage = new Stage();
    			    			//stage.setTitle("Menu");
    			    			stage.setScene(scene);
    			    			stage.setResizable(false);
    			    			stage.show();
    			    		} catch(Exception e) {
    			    			e.printStackTrace();
    			    		}
    			        } else if (ke.getCode().equals(KeyCode.DIGIT4)) {
    			        	System.exit(0);
    			        }
    			    }
    			});
    			Stage stage = (Stage) txtA.getScene().getWindow();
    			stage.setTitle("Menu");
    			stage.setScene(scene);
    			stage.setResizable(false);
    			stage.show();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
        }
    }
}
